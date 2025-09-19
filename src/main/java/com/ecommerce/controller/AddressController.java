// package com.ecommerce.controller;

// import java.util.List;
// import java.util.Scanner;

// import com.ecommerce.entity.Address;
// import com.ecommerce.entity.User;
// import com.ecommerce.service.AddressService;
// import com.ecommerce.service.UserService;
// import com.ecommerce.service.impl.AddressServiceImpl;
// import com.ecommerce.service.impl.UserServiceImpl;
// import com.ecommerce.util.UtilHib;

// public class AddressController {

//     private static final Scanner scanner = new Scanner(System.in);
//     private static final AddressService addressService = new AddressServiceImpl(UtilHib.getFactory());

//     public static void addressMenu() {
//         int choice;
//         do {
//             System.out.println("\n===== Address Management =====");
//             System.out.println("1. Add Address");
//             System.out.println("2. View Address by ID");
//             System.out.println("3. View All Addresses");
//             System.out.println("4. Update Address");
//             System.out.println("5. Delete Address");
//             System.out.println("0. Back to Main Menu");
//             System.out.print("Enter choice: ");
//             choice = scanner.nextInt();
//             scanner.nextLine(); // consume newline

//             switch (choice) {
//                 case 1:
//                     addAddress();
//                     break;
//                 case 2:
//                     getAddressById();
//                     break;
//                 case 3:
//                     getAllAddresses();
//                     break;
//                 case 4:
//                     updateAddress();
//                     break;
//                 case 5:
//                     deleteAddress();
//                     break;
//                 case 0:
//                     System.out.println("Returning to Main Menu...");
//                     break;
//                 default:
//                     System.out.println("❌ Invalid choice! Try again.");
//             }
//         } while (choice != 0);
//     }

//     private static void addAddress() {
//         Address address = new Address();
//         System.out.print("Enter Street: ");
//         address.setStreet(scanner.nextLine());
//         System.out.print("Enter City: ");
//         address.setCity(scanner.nextLine());
//         System.out.print("Enter State: ");
//         address.setState(scanner.nextLine());

//         // Proper way: fetch user object
//         System.out.print("Enter Phone Number for this Address: ");
//         String phoneNumber = scanner.nextLine();

//         // fetch user from service
//         UserService userService = new UserServiceImpl(UtilHib.getFactory());
//         User user = userService.getUserByPhoneNumber(phoneNumber);
//         if (user == null) {
//             System.out.println("❌ User not found. Cannot assign address.");
//             return;
//         }
//         address.setUser(user);

//         Address saved = addressService.createAddress(address);
//         System.out.println("✅ Address added with ID: " + saved.getId());
//     }

//     private static void getAddressById() {
//         System.out.print("Enter Address ID: ");
//         int id = scanner.nextInt();
//         scanner.nextLine();

//         Address address = addressService.getAddressById(id);
//         if (address != null) {
//             System.out.println("✅ Found Address: " + address);
//         } else {
//             System.out.println("❌ Address not found!");
//         }
//     }

//     private static void getAllAddresses() {
//         List<Address> addresses = addressService.getAllAddresses();
//         if (addresses.isEmpty()) {
//             System.out.println("⚠️ No addresses found.");
//         } else {
//             addresses.forEach(System.out::println);
//         }
//     }

//     private static void updateAddress() {
//         System.out.print("Enter Address ID to Update: ");
//         int id = scanner.nextInt();
//         scanner.nextLine();

//         Address existing = addressService.getAddressById(id);
//         if (existing == null) {
//             System.out.println("❌ Address not found!");
//             return;
//         }

//         System.out.print("Enter new Street (" + existing.getStreet() + "): ");
//         existing.setStreet(scanner.nextLine());
//         System.out.print("Enter new City (" + existing.getCity() + "): ");
//         existing.setCity(scanner.nextLine());
//         System.out.print("Enter new State (" + existing.getState() + "): ");
//         existing.setState(scanner.nextLine());

//         Address updated = addressService.updateAddress(existing);
//         System.out.println("✅ Address updated: " + updated);
//     }

//     private static void deleteAddress() {
//         System.out.print("Enter Address ID to Delete: ");
//         int id = scanner.nextInt();
//         scanner.nextLine();

//         boolean deleted = addressService.deleteAddress(id);
//         if (deleted) {
//             System.out.println("✅ Address deleted successfully.");
//         } else {
//             System.out.println("❌ Failed to delete. Address not found.");
//         }
//     }

// }

package com.ecommerce.controller;

import com.ecommerce.entity.Address;
import com.ecommerce.entity.User;
import com.ecommerce.service.AddressService;
import com.ecommerce.service.UserService;
import com.ecommerce.service.impl.AddressServiceImpl;
import com.ecommerce.service.impl.UserServiceImpl;
import com.ecommerce.util.UtilHib;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class AddressController {

    private static final Scanner sc = new Scanner(System.in);
    private static final SessionFactory sessionFactory = UtilHib.getFactory();
    private static final UserService userService = new UserServiceImpl(sessionFactory);
    private static final AddressService addressService = new AddressServiceImpl(sessionFactory);

    public static void addressMenu() {
        while (true) {
            System.out.println("\n===== Address Menu =====");
            System.out.println("1: Add Address");
            System.out.println("2: View All Addresses");
            System.out.println("3: Get Address By ID");
            System.out.println("4: Update Address");
            System.out.println("5: Delete Address");
            System.out.println("6: Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addAddress();
                    break;
                case 2:
                    viewAllAddresses();
                    break;
                case 3:
                    getAddressById();
                    break;
                case 4:
                    updateAddress();
                    break;
                case 5:
                    deleteAddress();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addAddress() {
        System.out.print("Enter User Phone Number (Owner of Address): ");
        String phone = sc.nextLine();
        User user = userService.getUserByPhoneNumber(phone);

        if (user == null) {
            System.out.println("⚠️ User not found with phone: " + phone);
            return;
        }

        Address address = new Address();

        System.out.print("Enter Street: ");
        address.setStreet(sc.nextLine());

        System.out.print("Enter City: ");
        address.setCity(sc.nextLine());

        System.out.print("Enter State: ");
        address.setState(sc.nextLine());

        System.out.print("Enter ZIP Code: ");
        address.setZip(sc.nextLine());

        address.setUser(user);

        addressService.createAddress(address);
        System.out.println("✅ Address added successfully for User: " + user.getUsername());
    }

    private static void viewAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        if (addresses.isEmpty()) {
            System.out.println("No addresses found.");
        } else {
            addresses.forEach(addr -> System.out.println("Address ID: " + addr.getId() +
                    ", Street: " + addr.getStreet() +
                    ", City: " + addr.getCity() +
                    ", State: " + addr.getState() +
                    ", ZIP: " + addr.getZip() +
                    ", Owner: " + addr.getUser().getUsername() +
                    ", Phone: " + addr.getUser().getPhoneNumber()));
        }
    }

    private static void getAddressById() {
        System.out.print("Enter Address ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Address addr = addressService.getAddressById(id);
        if (addr != null) {
            System.out.println("Address ID: " + addr.getId() +
                    ", Street: " + addr.getStreet() +
                    ", City: " + addr.getCity() +
                    ", State: " + addr.getState() +
                    ", ZIP: " + addr.getZip() +
                    ", Owner: " + addr.getUser().getUsername() +
                    ", Phone: " + addr.getUser().getPhoneNumber());
        } else {
            System.out.println("⚠️ Address not found!");
        }
    }

    private static void updateAddress() {
        System.out.print("Enter Address ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Address addr = addressService.getAddressById(id);
        if (addr == null) {
            System.out.println("⚠️ Address not found!");
            return;
        }

        System.out.print("Enter new Street (current: " + addr.getStreet() + "): ");
        addr.setStreet(sc.nextLine());

        System.out.print("Enter new City (current: " + addr.getCity() + "): ");
        addr.setCity(sc.nextLine());

        System.out.print("Enter new State (current: " + addr.getState() + "): ");
        addr.setState(sc.nextLine());

        System.out.print("Enter new ZIP (current: " + addr.getZip() + "): ");
        addr.setZip(sc.nextLine());

        addressService.updateAddress(addr);
        System.out.println("✅ Address updated successfully.");
    }

    private static void deleteAddress() {
        System.out.print("Enter Address ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        addressService.deleteAddress(id);
        System.out.println("✅ Address deleted if existed.");
    }
}
