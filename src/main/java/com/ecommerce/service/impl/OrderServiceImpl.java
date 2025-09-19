package com.ecommerce.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ecommerce.dao.DAOOrder;
import com.ecommerce.entity.Order;
import com.ecommerce.service.OrderService;



public class OrderServiceImpl implements OrderService {
    private final DAOOrder orderDao;

    public OrderServiceImpl(SessionFactory sessionFactory) {
        this.orderDao = new DAOOrder(sessionFactory);
    }

    @Override
    public Order createOrder(Order order) {
        orderDao.saveOrder(order);
        return order;
    }

    @Override
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public Order updateOrder(Order order) {
        orderDao.updateOrder(order);
        return order;
    }

    @Override
    public boolean deleteOrder(int id) {
        Order order = orderDao.getOrderById(id);
        if (order != null) {
            orderDao.deleteOrder(order);
            return true;
        }
        return false;
    }
}
