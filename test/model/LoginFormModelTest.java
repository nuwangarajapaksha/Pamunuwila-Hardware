/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EZIO AUDITORY
 */
public class LoginFormModelTest {
    
    public LoginFormModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserData method, of class LoginFormModel.
     */
    @Test
    public void testGetUserData() {
        System.out.println("getUserData");
        String username = "";
        String password = "";
        LoginFormModel instance = new LoginFormModel();
        Object[] expResult = null;
        Object[] result = instance.getUserData(username, password);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUsers method, of class LoginFormModel.
     */
    @Test
    public void testCheckUsers() {
        System.out.println("checkUsers");
        LoginFormModel instance = new LoginFormModel();
        boolean expResult = false;
        boolean result = instance.checkUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
