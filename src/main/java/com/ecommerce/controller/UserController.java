package com.ecommerce.controller;

import java.util.List;
import java.util.Scanner;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;
import com.ecommerce.service.impl.UserServiceImpl;
import com.ecommerce.util.UtilHib;

public class UserController {

    // private static UserService userService = new UserServiceImpl(UtilHib.getFactory());
    

    public static void main(String[] args) {
        // // Create a new user 
        // User newUser = new User();
        // newUser.setUsername("Samarth");
        // newUser.setEmail("samarth@example.com");
        // newUser.setPassword("12345");
        // User savedUser = userService.createUser(newUser);
        // System.out.println("User created: " + savedUser.getUsername());
        // // Fetch all users
        // System.out.println("\nFetching all users from DB:");
        // for (User u : userService.getAllUsers()) {
        //     System.out.println(u.getId() + " | " + u.getUsername() + " | " + u.getEmail());
        // }
           
    }

     private static final Scanner sc = new Scanner(System.in);
    private static final UserService userService = new UserServiceImpl(UtilHib.getFactory());

    public static void userMenu() {
        while (true) {
            System.out.println("\n==== User Menu ====");
            System.out.println("1. Create User");
            System.out.println("2. Get User by ID");
            System.out.println("3. Get All Users");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 : createUser();
                case 2 : getUserById();
                case 3 : getAllUsers();
                case 4 : updateUser();
                case 5 : deleteUser();
                case 0 : { return; }
                default : System.out.println("❌ Invalid choice, try again.");
            }
        }
    }

    private static void createUser() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        userService.createUser(user);
        System.out.println("✅ User created successfully!");
    }

    private static void getUserById() {
        System.out.print("Enter User ID: ");
        Long id = sc.nextLong();
        sc.nextLine();
        User user = userService.getUserById(id);

        if (user != null) {
            System.out.println("User: " + user.getId() + " | " + user.getUsername() + " | " + user.getEmail());
        } else {
            System.out.println("❌ User not found!");
        }
    }

    private static void getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("⚠️ No users found!");
        } else {
            users.forEach(u -> 
                System.out.println("ID: " + u.getId() + " | Username: " + u.getUsername() + " | Email: " + u.getEmail())
            );
        }
    }

    private static void updateUser() {
        System.out.print("Enter User ID to update: ");
        Long id = sc.nextLong();
        sc.nextLine();
        User user = userService.getUserById(id);

        if (user == null) {
            System.out.println("❌ User not found!");
            return;
        }

        System.out.print("Enter new username (" + user.getUsername() + "): ");
        user.setUsername(sc.nextLine());
        System.out.print("Enter new password (" + user.getPassword() + "): ");
        user.setPassword(sc.nextLine());
        System.out.print("Enter new email (" + user.getEmail() + "): ");
        user.setEmail(sc.nextLine());

        userService.updateUser(user);
        System.out.println("✅ User updated successfully!");
    }

    private static void deleteUser() {
        System.out.print("Enter User ID to delete: ");
        Long id = sc.nextLong();
        sc.nextLine();
        User user = userService.getUserById(id);

        if (user != null) {
            userService.deleteUser(id);
            System.out.println("✅ User deleted successfully!");
        } else {
            System.out.println("❌ User not found!");
        }
    }

}
