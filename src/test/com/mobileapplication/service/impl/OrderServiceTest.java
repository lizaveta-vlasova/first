package com.mobileapplication.service.impl;


import com.mobileapplication.dao.OrderDao;
import com.mobileapplication.domain.Order;
import com.mobileapplication.service.OrderService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @Mock
    OrderDao orderDao;

    @InjectMocks
    OrderServiceImpl orderService;

    @BeforeMethod
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        order.setId(1);
        order.setSessionId("12345");
        orderList.add(order);

        doNothing().when(this.orderDao).saveOrder(order);
        when(this.orderDao.getOrderById(1)).thenReturn(order);
        doNothing().when(this.orderDao).update(order);
        doNothing().when(this.orderDao).delete(order);

    }
    @Test
    public void deleteOrderTest() throws Exception{
        Order order = new Order();
        orderService.deleteOrder(order);
        verify(orderDao).delete(order);
    }

}
