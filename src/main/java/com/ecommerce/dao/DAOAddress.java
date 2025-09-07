package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.entity.Address;
import com.ecommerce.entity.Category;
import com.ecommerce.util.UtilHib;

public class DAOAddress {
    private SessionFactory sessionFactory;

    public DAOAddress(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveAddress(Address address) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.save(address);
            session.persist(address);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public Address getAddressById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Address.class, id);
        }
    }

    public void updateAddress(Address address) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.update(address);
            session.merge(address);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    public void deleteAddress(Address address) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // session.delete(address);
            session.remove(address);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    // // @SuppressWarnings("unchecked")
    // public List<Address> getAllAddresses() {
    // try (Session session = sessionFactory.openSession()) {
    // return session.createQuery("from Address").list();
    // }
    // }

    public List<Address> getAllAddresses() {

        try {
            Session session = UtilHib.getFactory().openSession();

            List<Address> addresses = session.createQuery("from Address", Address.class).list();

            return addresses;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

}
