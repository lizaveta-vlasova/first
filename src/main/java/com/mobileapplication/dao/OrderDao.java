package com.mobileapplication.dao;


import com.mobileapplication.domain.Order;

import java.util.List;

public interface OrderDao {
    void saveOrder(Order order);
    List<Order> findOrdersBySessionId(String sessionId);

    Order getOrderById(Integer orderId);

    void update(Order order);

    List<Order> orderList();

    void delete(Order order);

    List<Order> getOrdersByEmail(String email);
}
