package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.entity.Product;
import com.ecommerce.util.UtilHib;
import com.ecommerce.entity.Product;

public class DAOProduct {
    private SessionFactory sessionFactory;

    public DAOProduct(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveProduct(Product product) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.save(product);
            session.persist(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public Product getProductById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, id);
        }
    }

    public void updateProduct(Product product) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.update(product);
            session.merge(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public void deleteProduct(Product product) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.delete(product);
            session.remove(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {

        try {
            Session session = UtilHib.getFactory().openSession();

            List<Product> products = session.createQuery("from Product", Product.class).list();

            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
