/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mamphekgonthabiseng
 */
public class MessageManagerTest {
    
    public MessageManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of populateTestData method, of class MessageManager.
     */
    @Test
    public void testPopulateTestData() {
        System.out.println("populateTestData");
        MessageManager instance = new MessageManager();
        instance.populateTestData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllSenderRecipient method, of class MessageManager.
     */
    @Test
    public void testDisplayAllSenderRecipient() {
        System.out.println("displayAllSenderRecipient");
        MessageManager instance = new MessageManager();
        instance.displayAllSenderRecipient();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestMessage method, of class MessageManager.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        MessageManager instance = new MessageManager();
        instance.displayLongestMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByMessageId method, of class MessageManager.
     */
    @Test
    public void testSearchByMessageId() {
        System.out.println("searchByMessageId");
        String id = "";
        MessageManager instance = new MessageManager();
        instance.searchByMessageId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByRecipient method, of class MessageManager.
     */
    @Test
    public void testSearchByRecipient() {
        System.out.println("searchByRecipient");
        String recipient = "";
        MessageManager instance = new MessageManager();
        instance.searchByRecipient(recipient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByHash method, of class MessageManager.
     */
    @Test
    public void testDeleteByHash() {
        System.out.println("deleteByHash");
        String hash = "";
        MessageManager instance = new MessageManager();
        instance.deleteByHash(hash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayFullReport method, of class MessageManager.
     */
    @Test
    public void testDisplayFullReport() {
        System.out.println("displayFullReport");
        MessageManager instance = new MessageManager();
        instance.displayFullReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
