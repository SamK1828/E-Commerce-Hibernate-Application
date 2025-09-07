package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.entity.Order;
import com.ecommerce.util.UtilHib;
import com.ecommerce.entity.Order;

public class DAOOrder {
    private SessionFactory sessionFactory;

    public DAOOrder(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrder(Order order) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.save(order);
            session.persist(order);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public Order getOrderById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Order.class, id);
        }
    }

    public void updateOrder(Order order) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.update(order);
            session.merge(order);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public void deleteOrder(Order order) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.delete(order);
            session.remove(order);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {

        try {
            Session session = UtilHib.getFactory().openSession();

            List<Order> orders = session.createQuery("from Order", Order.class).list();

            return orders;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
