package com.ecommerce.controller;

import java.util.Scanner;

public class MainController {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== E-COMMERCE CONSOLE APP ===");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Addresses");
            System.out.println("3. Manage Orders");
            System.out.println("4. Manage Products");
            System.out.println("5. Manage Categories");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                // case 1 : UserController.userMenu();
                // case 2 : AddressController.addressMenu();
                // case 3 : OrderController.orderMenu();
                // case 4 : ProductController.productMenu();
                // case 5 : CategoryController.categoryMenu();
                case 0 : exit = true;
                default : System.out.println("Invalid choice!");
            }
        }

        System.out.println("Exiting... Bye!");
        sc.close();
    }
}

