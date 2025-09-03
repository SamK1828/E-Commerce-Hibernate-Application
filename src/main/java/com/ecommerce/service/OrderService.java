package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Order;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    Order updateOrder(Order order);
    boolean deleteOrder(Long id);
}
