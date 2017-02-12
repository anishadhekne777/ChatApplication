/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Achal
 */
public class ChatFrameIT {
    
    public ChatFrameIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isWin32 method, of class ChatFrame.
     */
    @Test
    public void testIsWin32() {
        System.out.println("isWin32");
        ChatFrame instance = new ChatFrame();
        boolean expResult = false;
        boolean result = instance.isWin32();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ChatFrame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ChatFrame.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
