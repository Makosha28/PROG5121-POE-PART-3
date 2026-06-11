package com.mycompany.main;

public class MessageManager {
    private Message[] storedMessages = new Message[10];
    private int storedCount = 0;

    public void populateTestData() {
        storedMessages[storedCount++] = new Message("+27834557896", "Did you get the cake?");
        storedMessages[storedCount++] = new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.");
        storedMessages[storedCount - 1].isFlagged = true; 
        storedMessages[storedCount++] = new Message("+27834484567", "Yohoooo,Iam at your gate");
        storedMessages[storedCount++] = new Message("0838884567","It is dinner time!");
        storedMessages[storedCount++] = new Message("+27838884567", "Ok, I am leaving without you.");
    }

    public void displayAllSenderRecipient() {
        System.out.println("\n=== STORED MESSAGES - RECIPIENTS ===");
        for (int i = 0; i < storedCount; i++) {
            System.out.println("Recipient: " + storedMessages[i].getRecipient());
        }
    }

    public void displayLongestMessage() {
        if (storedCount == 0) {
            System.out.println("No stored messages.");
            return;
        }
        Message longest = storedMessages[0];
        for (int i = 1; i < storedCount; i++) {
            if (storedMessages[i].getContent().length() > longest.getContent().length()) {
                longest = storedMessages[i];
            }
        }
        System.out.println("\n=== LONGEST STORED MESSAGE ===\n");
        longest.printMessageDetails();
    }

    public void searchByMessageId(String id) {
        for (int i = 0; i < storedCount; i++) {
            if (storedMessages[i].getMessageId().equalsIgnoreCase(id)) {
                storedMessages[i].printMessageDetails();
                return;
            }
        }
        System.out.println("Message ID not found.");
    }

    public void searchByRecipient(String recipient) {
        boolean found = false;
        for (int i = 0; i < storedCount; i++) {
            if (storedMessages[i].getRecipient().equalsIgnoreCase(recipient)) {
                storedMessages[i].printMessageDetails();
                found = true;
            }
        }
        if (!found) System.out.println("No messages found for this recipient.");
    }

    public void deleteByHash(String hash) {
        for (int i = 0; i < storedCount; i++) {
            if (storedMessages[i].getMessageHash().equalsIgnoreCase(hash)) {
                for (int j = i; j < storedCount - 1; j++) {
                    storedMessages[j] = storedMessages[j + 1];
                }
                storedMessages[--storedCount] = null;
                System.out.println("Message deleted successfully.");
                return;
            }
        }
        System.out.println("Message hash not found.");
    }

    public void displayFullReport() {
        System.out.println("\n=== FULL STORED MESSAGES REPORT ===");
        for (int i = 0; i < storedCount; i++) {
            storedMessages[i].printMessageDetails();
        }
        System.out.println("Total Stored Messages: " + storedCount);
    }
}