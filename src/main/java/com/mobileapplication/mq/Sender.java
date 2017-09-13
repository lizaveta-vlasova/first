package com.mobileapplication.mq;

import com.google.gson.Gson;
import com.mobileapplication.domain.Tariff;
import com.mobileapplication.dto.TariffDTO;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.List;

@Component
public class Sender {

    /*public static void main(String... args) throws NamingException, JMSException {
*/

    public void send(List<TariffDTO> tariffList) throws NamingException, JMSException{
        Hashtable<String, String> props = new Hashtable<>();
        props.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put("java.naming.provider.url", "tcp://localhost:61616");
        props.put("queue.js-queue", "asd");
        props.put("connectionFactoryNames", "queueCF");

        Context context = new InitialContext(props);
        QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup("queueCF");
        Queue queue = (Queue) context.lookup("js-queue");

        QueueConnection connection = connectionFactory.createQueueConnection();
        connection.start();

        QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

        QueueSender sender = session.createSender(queue);

        Gson gson = new Gson();
        String jsonTariff = gson.toJson(tariffList);
//        message.setText(jsonTariff);

        TextMessage message = session.createTextMessage(jsonTariff);


        sender.send(message);

        sender.close();
        session.close();
        connection.close();
    }

}