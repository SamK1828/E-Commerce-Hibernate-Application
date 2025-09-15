package com.ecommerce;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.entity.*;
import com.ecommerce.util.UtilHib;

public class App {
    // public static void main(String[] args) {
    // // Build SessionFactory
    // SessionFactory factory = new Configuration()
    // .configure("hibernate.cfg.xml")
    // .addAnnotatedClass(User.class)
    // .addAnnotatedClass(Address.class)
    // .addAnnotatedClass(Order.class)
    // .addAnnotatedClass(Product.class)
    // .addAnnotatedClass(Category.class)
    // .buildSessionFactory();
    // Session session = factory.openSession();
    // Transaction tx = session.beginTransaction();
    // try {
    // // ✅ Create Address
    // Address addr = new Address();
    // addr.setStreet("MG Road");
    // addr.setCity("Bangalore");
    // addr.setState("Karnataka");
    // addr.setZip("560001");
    // // ✅ Create User
    // User user = new User();
    // user.setUsername("samarth");
    // user.setPassword("secret123");
    // user.setEmail("samarth@example.com");
    // user.setAddress(addr);
    // // ✅ Create Products
    // Product phone = new Product();
    // phone.setName("Smartphone");
    // phone.setPrice(25000);
    // Product tshirt = new Product();
    // tshirt.setName("T-Shirt");
    // tshirt.setPrice(1200);
    // // ✅ Create Categories
    // Category electronics = new Category();
    // electronics.setName("Electronics");
    // Category fashion = new Category();
    // fashion.setName("Fashion");
    // // Link Products ↔ Categories
    // phone.getCategories().add(electronics);
    // electronics.getProducts().add(phone);
    // tshirt.getCategories().add(fashion);
    // fashion.getProducts().add(tshirt);
    // // ✅ Create Order
    // Order order = new Order();
    // order.setOrderNumber("ORD001");
    // order.setAmount(26200.0);
    // order.setOrderDate(LocalDate.now());
    // order.setUser(user);
    // // Link Order ↔ Products
    // order.getProducts().add(phone);
    // order.getProducts().add(tshirt);
    // phone.getOrders().add(order);
    // tshirt.getOrders().add(order);
    // // ✅ Persist everything
    // session.persist(user);
    // session.persist(order);
    // session.persist(phone);
    // session.persist(tshirt);
    // session.persist(electronics);
    // session.persist(fashion);
    // tx.commit();
    // // ✅ Fetch back order
    // Session newSession = factory.openSession();
    // Order fetchedOrder = newSession.get(Order.class, order.getId());
    // System.out.println("Order Number: " + fetchedOrder.getOrderNumber());
    // System.out.println("User: " + fetchedOrder.getUser().getUsername());
    // System.out.println("Products in Order:");
    // for (Product p : fetchedOrder.getProducts()) {
    // System.out.println(" - " + p.getName() + " | Price: " + p.getPrice());
    // for (Category c : p.getCategories()) {
    // System.out.println(" -> Category: " + c.getName());
    // }
    // }
    // newSession.close();
    // factory.close();
    // System.out.println("✅ Associations tested successfully!");
    // } catch (Exception e) {
    // tx.rollback();
    // e.printStackTrace();
    // }
    // }

    public static void main(String[] args) {
        Session session = UtilHib.getFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Create a user
            User user = new User();
            user.setUsername("samarth");
            user.setPassword("test123");
            user.setEmail("samarth@example.com");

            // Create addresses
            Address addr1 = new Address();
            addr1.setStreet("MG Road");
            addr1.setCity("Pune");
            addr1.setState("MH");
            addr1.setZip("411001");

            Address addr2 = new Address();
            addr2.setStreet("IT Park Road");
            addr2.setCity("Nagpur");
            addr2.setState("MH");
            addr2.setZip("440001");

            // link addresses to user
            user.addAddress(addr1);
            user.addAddress(addr2);

            // save
            session.persist(user);

            tx.commit();

            // Fetching back
            session.clear();
            User dbUser = session.get(User.class, user.getId());
            System.out.println("User: " + dbUser.getUsername() + " | Email: " + dbUser.getEmail());
            dbUser.getAddresses().forEach(a -> System.out.println("Address: " + a.getStreet() + ", " + a.getCity()));

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
