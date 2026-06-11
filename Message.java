package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Message {
    String messageID;
    private int messageNumber;
    String recipient;
    private String message;
    String messageHash;
    boolean isFlagged;

    private static int totalMessages = 0;
    private static final List<Message> sentMessages = new ArrayList<>();
    String flag;

    public Message(String recipient, String messageText) {
        this.recipient = recipient != null ? recipient.trim() : "";
        this.message = messageText != null ? messageText.trim() : "";
        this.isFlagged = false;
        totalMessages++;
        this.messageNumber = totalMessages;
        this.messageID = generateMessageID();
        this.messageHash = generateMessageHash();
    }

    Message(String _Did_you_get_the_cake) {
       
    }


    private String generateMessageID() {
        return String.format("MSG%04d", totalMessages);
    }

    private String generateMessageHash() {
        String combined = (recipient + message).replaceAll("\\s+", "");
        return combined.toUpperCase();
    }

    public String checkRecipientCell() {
        if (recipient == null || !recipient.startsWith("+") || recipient.length() < 10) {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
        return "Cell phone number successfully captured.";
    }

    public void printMessageDetails() {
        System.out.println("Message ID     : " + messageID);
        System.out.println("Message Number : " + messageNumber);
        System.out.println("Recipient      : " + recipient);
        System.out.println("Message        : " + message);
        System.out.println("Message Hash   : " + messageHash);
        System.out.println("Flagged        : " + (isFlagged ? "Yes" : "No"));
        System.out.println("----------------------------------------");
    }

    public static void addSentMessage(Message msg) {
        sentMessages.add(msg);
        saveToJson();
    }

    public static void printAllSentMessages() {
        if (sentMessages.isEmpty()) {
            System.out.println("No messages sent yet.");
            return;
        }
        System.out.println("\n=== ALL SENT MESSAGES ===");
        for (Message m : sentMessages) m.printMessageDetails();
    }

    public static int getTotalMessages() {
        return totalMessages;
    }


    public String getRecipient() { return recipient; }
    public String getContent() { return message; }
    public String getMessageId() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public boolean isFlagged() { return isFlagged; }

    private static void saveToJson() {
        // Optional - keeps your existing functionality
        try (PrintWriter writer = new PrintWriter(new FileWriter("sent_messages.json"))) {
            writer.println("[");
            for (int i = 0; i < sentMessages.size(); i++) {
                Message m = sentMessages.get(i);
                writer.println("  {");
                writer.println("    \"messageID\": \"" + m.messageID + "\",");
                writer.println("    \"recipient\": \"" + m.recipient + "\",");
                writer.println("    \"message\": \"" + m.message.replace("\"", "\\\"") + "\"");
                writer.println("  }" + (i < sentMessages.size() - 1 ? "," : ""));
            }
            writer.println("]");
        } catch (IOException e) {}
    }
}