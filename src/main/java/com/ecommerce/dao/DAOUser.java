package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.entity.User;

public class DAOUser {
	private final SessionFactory sessionFactory;

	public DAOUser(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveUser(User user) {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.persist(user);
			System.out.println("User created with ID: " + user.getId());
			tx.commit();
			session.close(); // ✅ flush session
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close(); // ✅ close session
		}
	}

	public User getUserById(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			return session.get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAllUsers() {
		try {
			Session session = sessionFactory.openSession();
			List<User> userList = session.createQuery("from User", User.class).list();
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateUser(User user) {
		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// session.update(user);
			session.merge(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}
	public User getUserByPhone(String phoneNumber) {
    try (Session session = sessionFactory.openSession()) {
        return session.createQuery("FROM User WHERE phoneNumber = :phone", User.class)
                      .setParameter("phone", phoneNumber)
                      .uniqueResult();
    }
}

	public void deleteUser(int id) {
		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			User user = session.get(User.class, id);
			if (user != null)
				session.remove(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}
}
