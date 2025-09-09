package com.ecommerce.controller;

import java.util.Scanner;

public class MainController {

    // public static void main(String[] args) {
    // boolean exit = false;

    // while(!exit)
    // {
    // System.out.println("\n=== E-COMMERCE CONSOLE APP ===");
    // System.out.println("1. Manage Users");
    // System.out.println("2. Manage Addresses");
    // System.out.println("3. Manage Orders");
    // System.out.println("4. Manage Products");
    // System.out.println("5. Manage Categories");
    // System.out.println("0. Exit");
    // System.out.print("Enter choice: ");

    // int choice = sc.nextInt();

    // switch (choice) {
    // // case 1 : UserController.userMenu();
    // // case 2 : AddressController.addressMenu();
    // // case 3 : OrderController.orderMenu();
    // // case 4 : ProductController.productMenu();
    // // case 5 : CategoryController.categoryMenu();
    // case 0:
    // exit = true;
    // default:
    // System.out.println("Invalid choice!");
    // }
    // }

    // System.out.println("Exiting... Bye!");sc.close();}
    // // }

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== E-Commerce Management System =====");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Addresses");
            System.out.println("3. Manage Orders");
            System.out.println("4. Manage Products");
            System.out.println("5. Manage Categories");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    UserController.userMenu();
                    break;
                // case 2:
                //     AddressController.addressMenu();
                //     break;
                // case 3:
                //     OrderController.orderMenu(); // to be implemented
                //     break;
                // case 4:
                //     ProductController.productMenu(); // to be implemented
                //     break;
                // case 5:
                //     CategoryController.categoryMenu(); // to be implemented
                //     break;
                case 0:
                    System.out.println("👋 Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice, please try again.");
            }
        }
    }
}
