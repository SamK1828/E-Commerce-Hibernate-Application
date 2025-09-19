package com.ecommerce.controller;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.User;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.UserService;
import com.ecommerce.service.impl.OrderServiceImpl;
import com.ecommerce.service.impl.UserServiceImpl;
import com.ecommerce.util.UtilHib;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class OrderController {

    private static final Scanner sc = new Scanner(System.in);
    private static final SessionFactory sessionFactory = UtilHib.getFactory();
    private static final UserService userService = new UserServiceImpl(sessionFactory);
    private static final OrderService orderService = new OrderServiceImpl(sessionFactory);

    public static void orderMenu() {
        while (true) {
            System.out.println("\n===== Order Menu =====");
            System.out.println("1: Create Order");
            System.out.println("2: View All Orders");
            System.out.println("3: Get Order By ID");
            System.out.println("4: Delete Order");
            System.out.println("5: Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    viewAllOrders();
                    break;
                case 3:
                    getOrderById();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 5:
                    return; // back to main
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createOrder() {
        System.out.print("Enter User Phone Number: ");
        String phone = sc.nextLine();
        User user = userService.getUserByPhoneNumber(phone);

        if (user == null) {
            System.out.println("⚠️ User not found with phone: " + phone);
            return;
        }

        Order order = new Order();
        order.setUser(user);

        // For now just mark order creation (later we can attach products, total etc.)
        orderService.createOrder(order);

        System.out.println("✅ Order created successfully for User: " + user.getUsername());
    }

    private static void viewAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            orders.forEach(order ->
                    System.out.println("Order ID: " + order.getId() +
                            ", User: " + order.getUser().getUsername() +
                            ", Phone: " + order.getUser().getPhoneNumber()));
        }
    }

    private static void getOrderById() {
        System.out.print("Enter Order ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Order order = orderService.getOrderById(id);
        if (order != null) {
            System.out.println("Order ID: " + order.getId() +
                    ", User: " + order.getUser().getUsername() +
                    ", Phone: " + order.getUser().getPhoneNumber());
        } else {
            System.out.println("⚠️ Order not found!");
        }
    }

    private static void deleteOrder() {
        System.out.print("Enter Order ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        orderService.deleteOrder(id);
        System.out.println("✅ Order deleted if existed.");
    }
}
