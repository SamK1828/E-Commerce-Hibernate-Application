package com.ecommerce;

import java.time.LocalDate;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ecommerce.entity.*;

public class App {
    public static void main(String[] args) {
        // Build SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            // ✅ Create Address
            Address addr = new Address();
            addr.setStreet("MG Road");
            addr.setCity("Bangalore");
            addr.setState("Karnataka");
            addr.setZip("560001");

            // ✅ Create User
            User user = new User();
            user.setUsername("samarth");
            user.setPassword("secret123");
            user.setEmail("samarth@example.com");
            user.setAddress(addr);

            // ✅ Create Products
            Product phone = new Product();
            phone.setName("Smartphone");
            phone.setPrice(25000);

            Product tshirt = new Product();
            tshirt.setName("T-Shirt");
            tshirt.setPrice(1200);

            // ✅ Create Categories
            Category electronics = new Category();
            electronics.setName("Electronics");

            Category fashion = new Category();
            fashion.setName("Fashion");

            // Link Products ↔ Categories
            phone.getCategories().add(electronics);
            electronics.getProducts().add(phone);

            tshirt.getCategories().add(fashion);
            fashion.getProducts().add(tshirt);

            // ✅ Create Order
            Order order = new Order();
            order.setOrderNumber("ORD001");
            order.setAmount(26200.0);
            order.setOrderDate(LocalDate.now());
            order.setUser(user);

            // Link Order ↔ Products
            order.getProducts().add(phone);
            order.getProducts().add(tshirt);

            phone.getOrders().add(order);
            tshirt.getOrders().add(order);

            // ✅ Persist everything
            session.persist(user);
            session.persist(order);
            session.persist(phone);
            session.persist(tshirt);
            session.persist(electronics);
            session.persist(fashion);

            tx.commit();

            // ✅ Fetch back order
            Session newSession = factory.openSession();
            Order fetchedOrder = newSession.get(Order.class, order.getId());

            System.out.println("Order Number: " + fetchedOrder.getOrderNumber());
            System.out.println("User: " + fetchedOrder.getUser().getUsername());
            System.out.println("Products in Order:");

            for (Product p : fetchedOrder.getProducts()) {
                System.out.println(" - " + p.getName() + " | Price: " + p.getPrice());
                for (Category c : p.getCategories()) {
                    System.out.println("   -> Category: " + c.getName());
                }
            }

            newSession.close();
            factory.close();

            System.out.println("✅ Associations tested successfully!");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}
