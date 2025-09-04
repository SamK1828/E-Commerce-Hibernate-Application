package com.ecommerce.service.impl;

import java.util.List;

import com.ecommerce.dao.DAOOrder;
import com.ecommerce.entity.Order;
import com.ecommerce.service.OrderService;



public class OrderServiceImpl implements OrderService {
    private final DAOOrder orderDao;

    public OrderServiceImpl(DAOOrder orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order createOrder(Order order) {
        orderDao.saveOrder(order);
        return order;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDao.getOrderById(id.intValue());
    }

    @Override
    public List<Order> getAllOrders() {
        throw new UnsupportedOperationException("getAllOrders not implemented in DAOOrder yet");
    }

    @Override
    public Order updateOrder(Order order) {
        orderDao.updateOrder(order);
        return order;
    }

    @Override
    public boolean deleteOrder(Long id) {
        Order order = orderDao.getOrderById(id.intValue());
        if (order != null) {
            orderDao.deleteOrder(order);
            return true;
        }
        return false;
    }
}
