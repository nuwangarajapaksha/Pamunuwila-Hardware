/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EZIO AUDITORY
 */
public class UserModelTest {
    
    public UserModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerUser method, of class UserModel.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        String username = "";
        String password = "";
        int jobroleNo = 0;
        UserModel instance = new UserModel();
        String expResult = "";
        String result = instance.registerUser(name, nic, email, contactNo, address, city, distictNo, provinceNo, username, password, jobroleNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserModel.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        String userNo = "";
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        String username = "";
        String password = "";
        int jobroleNo = 0;
        UserModel instance = new UserModel();
        String expResult = "";
        String result = instance.updateUser(userNo, name, nic, email, contactNo, address, city, distictNo, provinceNo, username, password, jobroleNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class UserModel.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        String userNo = "";
        UserModel instance = new UserModel();
        String expResult = "";
        String result = instance.removeUser(userNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadUserTable method, of class UserModel.
     */
    @Test
    public void testLoadUserTable() {
        System.out.println("loadUserTable");
        String keyword = "";
        DefaultTableModel userTableModel = null;
        UserModel instance = new UserModel();
        instance.loadUserTable(keyword, userTableModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedUserData method, of class UserModel.
     */
    @Test
    public void testGetSelectedUserData() {
        System.out.println("getSelectedUserData");
        int userNo = 0;
        UserModel instance = new UserModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedUserData(userNo);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadUserTableFull method, of class UserModel.
     */
    @Test
    public void testLoadUserTableFull() {
        System.out.println("loadUserTableFull");
        String keywordFull = "";
        DefaultTableModel userTableModelFull = null;
        UserModel instance = new UserModel();
        instance.loadUserTableFull(keywordFull, userTableModelFull);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
