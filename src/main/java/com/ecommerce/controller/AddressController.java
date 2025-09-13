package com.ecommerce.controller;

import java.util.List;
import java.util.Scanner;

import com.ecommerce.entity.Address;
import com.ecommerce.entity.User;
import com.ecommerce.service.AddressService;
import com.ecommerce.service.UserService;
import com.ecommerce.service.impl.AddressServiceImpl;
import com.ecommerce.service.impl.UserServiceImpl;
import com.ecommerce.util.UtilHib;

public class AddressController {

    private static final Scanner scanner = new Scanner(System.in);
    private static final AddressService addressService = new AddressServiceImpl(UtilHib.getFactory());

    public static void addressMenu() {
        int choice;
        do {
            System.out.println("\n===== Address Management =====");
            System.out.println("1. Add Address");
            System.out.println("2. View Address by ID");
            System.out.println("3. View All Addresses");
            System.out.println("4. Update Address");
            System.out.println("5. Delete Address");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addAddress();
                    break;
                case 2:
                    getAddressById();
                    break;
                case 3:
                    getAllAddresses();
                    break;
                case 4:
                    updateAddress();
                    break;
                case 5:
                    deleteAddress();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 0);
    }

    private static void addAddress() {
        Address address = new Address();
        System.out.print("Enter Street: ");
        address.setStreet(scanner.nextLine());
        System.out.print("Enter City: ");
        address.setCity(scanner.nextLine());
        System.out.print("Enter State: ");
        address.setState(scanner.nextLine());


        // Proper way: fetch user object
        System.out.print("Enter User ID for this Address: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        // fetch user from service
        UserService userService = new UserServiceImpl(UtilHib.getFactory());
        User user = userService.getUserById(userId);
        if (user == null) {
            System.out.println("❌ User not found. Cannot assign address.");
            return;
        }
        address.setUser(user);

        Address saved = addressService.createAddress(address);
        System.out.println("✅ Address added with ID: " + saved.getId());
    }

    private static void getAddressById() {
        System.out.print("Enter Address ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Address address = addressService.getAddressById(id);
        if (address != null) {
            System.out.println("✅ Found Address: " + address);
        } else {
            System.out.println("❌ Address not found!");
        }
    }

    private static void getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        if (addresses.isEmpty()) {
            System.out.println("⚠️ No addresses found.");
        } else {
            addresses.forEach(System.out::println);
        }
    }

    private static void updateAddress() {
        System.out.print("Enter Address ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Address existing = addressService.getAddressById(id);
        if (existing == null) {
            System.out.println("❌ Address not found!");
            return;
        }

        System.out.print("Enter new Street (" + existing.getStreet() + "): ");
        existing.setStreet(scanner.nextLine());
        System.out.print("Enter new City (" + existing.getCity() + "): ");
        existing.setCity(scanner.nextLine());
        System.out.print("Enter new State (" + existing.getState() + "): ");
        existing.setState(scanner.nextLine());

        Address updated = addressService.updateAddress(existing);
        System.out.println("✅ Address updated: " + updated);
    }

    private static void deleteAddress() {
        System.out.print("Enter Address ID to Delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = addressService.deleteAddress(id);
        if (deleted) {
            System.out.println("✅ Address deleted successfully.");
        } else {
            System.out.println("❌ Failed to delete. Address not found.");
        }
    }

    
}
