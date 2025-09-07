package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.entity.Category;
import com.ecommerce.util.UtilHib;

public class DAOCategory {
    private SessionFactory sessionFactory;

    public DAOCategory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCategory(Category category) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.save(category);
            session.persist(category);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public Category getCategoryById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Category.class, id);
        }
    }

    public void updateCategory(Category category) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.update(category);
            session.merge(category);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public void deleteCategory(Category category) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.delete(category);
            session.remove(category);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Category> getAllCategories() {

        try {
            Session session = UtilHib.getFactory().openSession();

            List<Category> categories = session.createQuery("from Category", Category.class).list();

            return categories;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
