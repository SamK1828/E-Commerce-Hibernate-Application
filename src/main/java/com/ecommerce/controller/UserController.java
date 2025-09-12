// package com.ecommerce.controller;

// import java.util.List;
// import java.util.Scanner;

// import com.ecommerce.entity.Address;
// import com.ecommerce.entity.User;
// import com.ecommerce.service.UserService;
// import com.ecommerce.service.impl.UserServiceImpl;
// import com.ecommerce.util.UtilHib;

// public class UserController {

//     // private static UserService userService = new
//     // UserServiceImpl(UtilHib.getFactory());

//     // public static void main(String[] args) {
//     // // // Create a new user
//     // // User newUser = new User();
//     // // newUser.setUsername("Samarth");
//     // // newUser.setEmail("samarth@example.com");
//     // // newUser.setPassword("12345");
//     // // User savedUser = userService.createUser(newUser);
//     // // System.out.println("User created: " + savedUser.getUsername());
//     // // // Fetch all users
//     // // System.out.println("\nFetching all users from DB:");
//     // // for (User u : userService.getAllUsers()) {
//     // // System.out.println(u.getId() + " | " + u.getUsername() + " | " +
//     // u.getEmail());
//     // // }
//     // }

//     private static final Scanner sc = new Scanner(System.in);
//     private static final UserService userService = new UserServiceImpl(UtilHib.getFactory());

//     public static void userMenu() {
//         while (true) {
//             System.out.println("\n==== User Menu ====");
//             System.out.println("1. Create User");
//             System.out.println("2. Get User by ID");
//             System.out.println("3. Get All Users");
//             System.out.println("4. Update User");
//             System.out.println("5. Delete User");
//             System.out.println("7. Add User with Addresses");
//             System.out.println("8. View User with Addresses");

//             System.out.println("0. Back to Main Menu");
//             System.out.print("Choose an option: ");

//             int choice = sc.nextInt();
//             sc.nextLine(); // consume newline

//             switch (choice) {
//                 case 1:
//                     createUser();
//                 case 2:
//                     getUserById();
//                 case 3:
//                     getAllUsers();
//                 case 4:
//                     updateUser();
//                 case 5:
//                     deleteUser();
//                 case 7: {
//                     System.out.print("Enter username: ");
//                     String username = sc.nextLine();
//                     System.out.print("Enter email: ");
//                     String email = sc.nextLine();

//                     User user = new User();
//                     user.setUsername(username);
//                     user.setEmail(email);

//                     System.out.print("How many addresses to add? ");
//                     int count = sc.nextInt();
//                     sc.nextLine();

//                     for (int i = 0; i < count; i++) {
//                         System.out.println("Enter Address " + (i + 1));
//                         System.out.print("Street: ");
//                         String street = sc.nextLine();
//                         System.out.print("City: ");
//                         String city = sc.nextLine();
//                         System.out.print("State: ");
//                         String state = sc.nextLine();
//                         System.out.print("Zip: ");
//                         String zip = sc.nextLine();

//                         Address address = new Address();
//                         address.setStreet(street);
//                         address.setCity(city);
//                         address.setState(state);
//                         address.setZip(zip);

//                         user.addAddress(address); // links both sides
//                     }

//                     userService.createUser(user);
//                     System.out.println("✅ User with addresses saved!");
//                 }
//                     break;

//                 case 8: {
//                     System.out.print("Enter user ID to fetch: ");
//                     Long userId = sc.nextLong();
//                     sc.nextLine();

//                     User fetched = userService.getUserById(userId);
//                     if (fetched != null) {
//                         System.out.println("User: " + fetched.getUsername() + " | " + fetched.getEmail());
//                         for (Address addr : fetched.getAddresses()) {
//                             System.out.println(" - " + addr.getStreet() + ", " + addr.getCity());
//                         }
//                     } else {
//                         System.out.println("❌ User not found.");
//                     }
//                 }
//                     break;

//                 case 0: {
//                     return;
//                 }
//                 default:
//                     System.out.println("❌ Invalid choice, try again.");
//             }
//         }
//     }

//     private static void createUser() {
//         System.out.print("Enter username: ");
//         String username = sc.nextLine();
//         System.out.print("Enter password: ");
//         String password = sc.nextLine();
//         System.out.print("Enter email: ");
//         String email = sc.nextLine();

//         User user = new User();
//         user.setUsername(username);
//         user.setPassword(password);
//         user.setEmail(email);

//         userService.createUser(user);
//         System.out.println("✅ User created successfully!");
//     }

//     private static void getUserById() {
//         System.out.print("Enter User ID: ");
//         Long id = sc.nextLong();
//         sc.nextLine();
//         User user = userService.getUserById(id);

//         if (user != null) {
//             System.out.println("User: " + user.getId() + " | " + user.getUsername() + " | " + user.getEmail());
//         } else {
//             System.out.println("❌ User not found!");
//         }
//     }

//     private static void getAllUsers() {
//         List<User> users = userService.getAllUsers();
//         if (users.isEmpty()) {
//             System.out.println("⚠️ No users found!");
//         } else {
//             users.forEach(u -> System.out
//                     .println("ID: " + u.getId() + " | Username: " + u.getUsername() + " | Email: " + u.getEmail()));
//         }
//     }

//     private static void updateUser() {
//         System.out.print("Enter User ID to update: ");
//         Long id = sc.nextLong();
//         sc.nextLine();
//         User user = userService.getUserById(id);

//         if (user == null) {
//             System.out.println("❌ User not found!");
//             return;
//         }

//         System.out.print("Enter new username (" + user.getUsername() + "): ");
//         user.setUsername(sc.nextLine());
//         System.out.print("Enter new password (" + user.getPassword() + "): ");
//         user.setPassword(sc.nextLine());
//         System.out.print("Enter new email (" + user.getEmail() + "): ");
//         user.setEmail(sc.nextLine());

//         userService.updateUser(user);
//         System.out.println("✅ User updated successfully!");
//     }

//     private static void deleteUser() {
//         System.out.print("Enter User ID to delete: ");
//         Long id = sc.nextLong();
//         sc.nextLine();
//         User user = userService.getUserById(id);

//         if (user != null) {
//             userService.deleteUser(id);
//             System.out.println("✅ User deleted successfully!");
//         } else {
//             System.out.println("❌ User not found!");
//         }
//     }

// }

package com.ecommerce.controller;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;
import com.ecommerce.service.impl.UserServiceImpl;
import com.ecommerce.util.UtilHib;

import java.util.List;
import java.util.Scanner;

public class UserController {

    private static final Scanner sc = new Scanner(System.in);
    private static final UserService userService = new UserServiceImpl(UtilHib.getFactory());

    // Entry point from MainController
    public static void userMenu() {
        while (true) {
            System.out.println("\n===== User Menu =====");
            System.out.println("1: Create User");
            System.out.println("2: View All Users");
            System.out.println("3: Get User By ID");
            System.out.println("4: Update User");
            System.out.println("5: Delete User");
            System.out.println("6: Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine()); // FIXED: avoids skipping input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    viewAllUsers();
                    break;
                case 3:
                    getUserById();
                    break;
                case 4:
                    updateUser();
                    break;
                case 5:
                    deleteUser();
                    break;
                case 6:
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void createUser() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);

        userService.createUser(user);
        System.out.println("User created successfully!");
    }

    private static void viewAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            users.forEach(u -> System.out
                    .println("ID: " + u.getId() + " | Username: " + u.getUsername() + " | Email: " + u.getEmail()));
        }
    }

    private static void getUserById() {
        System.out.print("Enter User ID: ");
        int id = Integer.parseInt(sc.nextLine());
        User user = userService.getUserById(id);

        if (user != null) {
            System.out.println("User: " + user.getId() + " | " + user.getUsername() + " | " + user.getEmail());
        } else {
            System.out.println("❌ User not found!");
        }
    }

    private static void updateUser() {
        System.out.print("Enter User ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        User user = userService.getUserById(id);
        if (user == null) {
            System.out.println("❌ User not found!");
            return;
        }
        System.out.print("Enter new name (leave blank to keep current): ");
        String name = sc.nextLine();
        if (!name.isBlank()) {
            user.setUsername(name);
        }

        System.out.print("Enter new email (leave blank to keep current): ");
        String email = sc.nextLine();
        if (!email.isBlank()) {
            user.setEmail(email);
        }
        System.out.print("Enter new password (leave blank to keep current): ");
        String password = sc.nextLine();
        if (!password.isBlank()) {
            user.setPassword(password);
        }

        userService.updateUser(user);
        System.out.println(" User updated successfully!");
    }

    private static void deleteUser() {
        System.out.print("Enter User ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        userService.deleteUser(id);
        System.out.println("✅ User deleted successfully!");
    }
}
