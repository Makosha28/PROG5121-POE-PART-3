package com.mycompany.main;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Registration registration = new Registration();
        Login loginSystem = new Login(registration);
        MessageManager messageManager = new MessageManager();
        messageManager.populateTestData();
        
        System.out.println("=== QUICKCHAT APPLICATION ===");

        int choice;
        do {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select your option: ");

            while (!keyboard.hasNextInt()) {
                keyboard.next();
                System.out.print("Invalid input. Enter a number: ");
            }
            choice = keyboard.nextInt();
            keyboard.nextLine();

            switch (choice) {
                case 1:
                    String result = registration.registerUser(keyboard);
                    System.out.println(result);
                    break;
                case 2:
                    if (loginSystem.loginUser(keyboard)) {
                        startQuickChat(keyboard, messageManager);
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        keyboard.close();
    }

    private static void startQuickChat(Scanner scanner, MessageManager manager) {
        System.out.println("\nWelcome to QuickChat!");

        System.out.print("How many messages would you like to send? ");
        int messageLimit = scanner.nextInt();
        scanner.nextLine();

        boolean running = true;
        while (running) {
            System.out.println("\n=== QUICKCHAT MENU ===");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Stored Messages");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    sendMessage(scanner, messageLimit);
                    break;
                case 2:
                    Message.printAllSentMessages();
                    break;
                case 3:
                    storedMessagesMenu(scanner, manager);
                    break;
                case 4:
                    System.out.println("\nTotal messages sent: " + Message.getTotalMessages());
                    System.out.println("Thank you for using QuickChat. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void sendMessage(Scanner scanner, int limit) {
        if (Message.getTotalMessages() >= limit) {
            System.out.println("You have reached your message limit.");
            return;
        }

        System.out.println("\n--- Send New Message ---");
        System.out.print("Enter recipient cell number (+27...): ");
        String recipient = scanner.nextLine();

        System.out.print("Enter message (max 250 chars): ");
        String text = scanner.nextLine();

        if (text.length() > 250) {
            System.out.println("Please enter a message of less than 250 characters.");
            return;
        }

        Message msg = new Message(recipient, text);
        System.out.println(msg.checkRecipientCell());
        Message.addSentMessage(msg);
        System.out.println("Message sent successfully!");
        msg.printMessageDetails();
    }

    private static void storedMessagesMenu(Scanner scanner, MessageManager manager) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- STORED MESSAGES MENU ---");
            System.out.println("a. Display sender and recipient of all stored messages");
            System.out.println("b. Display the longest stored message");
            System.out.println("c. Search for a message ID");
            System.out.println("d. Search messages for a particular recipient");
            System.out.println("e. Delete a message using the message hash");
            System.out.println("f. Display full report of all stored messages");
            System.out.println("g. Back to main menu");
            System.out.print("Choose option: ");

            String opt = scanner.nextLine().trim().toLowerCase();

            switch (opt) {
                case "a": manager.displayAllSenderRecipient(); break;
                case "b": manager.displayLongestMessage(); break;
                case "c":
                    System.out.print("Enter Message ID: ");
                    manager.searchByMessageId(scanner.nextLine().trim());
                    break;
                case "d":
                    System.out.print("Enter recipient: ");
                    manager.searchByRecipient(scanner.nextLine().trim());
                    break;
                case "e":
                    System.out.print("Enter Message Hash: ");
                    manager.deleteByHash(scanner.nextLine().trim());
                    break;
                case "f": manager.displayFullReport(); break;
                case "g": back = true; break;
                default: System.out.println("Invalid option.");
            }
        }
    }
}