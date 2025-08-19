package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.entity.User;
import com.ecommerce.util.UtilHib;

public class DAOUser {
	public void saveUser(User user) {
		Transaction tx = null;
		try  {
			Session session = UtilHib.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.persist(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			
		}
	}

	public User getUserById(int id) {
		try {
			Session session = UtilHib.getSessionFactory().openSession();
			return session.get(User.class, id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAllUsers(){
		try {
			Session session = UtilHib.getSessionFactory().openSession();
			List<User> userList = session.createQuery("from User", User.class).list();
			return userList;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateUser(User user) {
		Transaction tx = null;
		try  {
			Session session = UtilHib.getSessionFactory().openSession();
			tx = session.beginTransaction();
//			session.update(user);
			session.merge(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	public void deleteUser(int id) {
		Transaction tx = null;
		try  {
			Session session = UtilHib.getSessionFactory().openSession();
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
