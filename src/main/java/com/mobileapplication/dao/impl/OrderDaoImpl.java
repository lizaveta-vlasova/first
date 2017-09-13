package com.mobileapplication.dao.impl;


import com.mobileapplication.dao.OrderDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveOrder(Order order) {

        entityManager.persist(order);
    }

    @Override
    public List<Order> findOrdersBySessionId(String sessionId) {
        Query query = entityManager.createQuery("FROM Order where  sessionId= :sessionId");
        query.setParameter("sessionId", sessionId);
        List<Order> orderList = query.getResultList();
        return orderList;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Query query = entityManager.createQuery("FROM Order where  id= :orderId");
        query.setParameter("orderId", orderId);
        Order order = (Order) query.getSingleResult();
        return order;
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }

    @Override
    public List<Order> orderList() {
        Query query = entityManager.createQuery("SELECT e FROM Order e");
        List <Order> orderList = query.getResultList();
        return (List<Order>) orderList;
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(entityManager.merge(order));
    }

    @Override
    public List<Order> getOrdersByEmail(String email) {
        Query query = entityManager.createQuery("FROM Order where client = :email");
        query.setParameter("email", email);
        List <Order> orderList = query.getResultList();
        return (List<Order>) orderList;
    }

}

