package com.ecommerce;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.dao.DAOUser;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.User;
import com.ecommerce.util.UtilHib;

public class App {
	public static void main(String[] args) {
//		DAOUser userDAO = new DAOUser();
		// Testing CRUD Operations
		// // Create
		// User user1 = new User("Samarth", "pass123", "sam@example.com");
		// userDAO.saveUser(user1);
		//
		// // Read
		// System.out.println("All Users: " + userDAO.getAllUsers());
		//
		// // Update
		// user1.setPassword("newpassword");
		// userDAO.updateUser(user1);
		//
		// // Delete
		// userDAO.deleteUser(user1.getId());
		// // Testing One to One Association
		// Address addr = new Address();
		// addr.setStreet("Manjunadha PG, Hinjewadi, Pune");
		// addr.setCity("Pune");
		// addr.setState("MH");
		// addr.setZip("411057");

		// User u = new User();
		// u.setUsername("samarth");
		// u.setPassword("sam123");
		// u.setEmail("samarth@example.com");
		// u.setAddress(addr);

		// userDAO.saveUser(u);

		// Testing One To Many Operation
		Session session = UtilHib.getFactory().openSession();
		Transaction tx = session.beginTransaction();

		// Create User
		User user = new User("Samarth", "samarth@example.com");
		user.setPassword("sam123");

		// Create Orders
		Order o1 = new Order("Laptop", 55000.0, LocalDate.now());
		Order o2 = new Order("Smartphone", 25000.0, LocalDate.now());

		// Add Orders to User
		user.addOrder(o1);
		user.addOrder(o2);

		// Save User (Cascade saves orders)
		session.persist(user);

		tx.commit();
		session.close();

		// Fetch and display
		Session session2 = UtilHib.getFactory().openSession();
		User fetchedUser = session2.get(User.class, user.getId());
		System.out.println("User: " + fetchedUser.getUsername());

		for (Order order : fetchedUser.getOrders()) {
			System.out.println(order);
		}

		session2.close();

	}
}
