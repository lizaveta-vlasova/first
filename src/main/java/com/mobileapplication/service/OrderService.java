package com.mobileapplication.service;


import com.mobileapplication.domain.Order;

import java.util.List;

public interface OrderService {
   void saveOrder(Order order);
   List<Order> findOrdersBySessionId(String sessionId);

    Order getOrderById(Integer orderId);

    void update(Order order);

    List<Order> orderList();

    void deleteOrder(Order order);

    List<Order> getOrdersByEmail(String email);
}

