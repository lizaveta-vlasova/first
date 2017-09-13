package com.mobileapplication.service.impl;


import com.mobileapplication.dao.OrderDao;
import com.mobileapplication.domain.Order;
import com.mobileapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public void saveOrder(Order order) {

        orderDao.saveOrder(order);
    }
    public List<Order>findOrdersBySessionId(String sessionId){
        return orderDao.findOrdersBySessionId(sessionId);
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderDao.getOrderById(orderId);
    }

    @Override
    public void update(Order order) {
         orderDao.update(order);
    }

    @Override
    public List<Order> orderList() {
        return orderDao.orderList();
    }

    @Override
    public void deleteOrder(Order order) {
         orderDao.delete(order);
    }

    @Override
    public List<Order> getOrdersByEmail(String email) {
       return orderDao.getOrdersByEmail(email);
    }
}
