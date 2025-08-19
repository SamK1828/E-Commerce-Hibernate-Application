package com.ecommerce;

import com.ecommerce.dao.DAOUser;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.User;

public class App {
	public static void main(String[] args) {
		DAOUser userDAO = new DAOUser();

//		// Create
//		User user1 = new User("Samarth", "pass123", "sam@example.com");
//		userDAO.saveUser(user1);
//
//		// Read
//		System.out.println("All Users: " + userDAO.getAllUsers());
//
//		// Update
//		user1.setPassword("newpassword");
//		userDAO.updateUser(user1);
//
//		// Delete
//		userDAO.deleteUser(user1.getId());

		Address addr = new Address();
		addr.setStreet("Manjunadha PG, Hinjewadi, Pune");
		addr.setCity("Pune");
		addr.setState("MH");
		addr.setZip("411057");

		User u = new User();
		u.setUsername("samarth"); 
		u.setPassword("sam123");
		u.setEmail("samarth@example.com");
		u.setAddress(addr); 
		
		userDAO.saveUser(u);

	}
}
