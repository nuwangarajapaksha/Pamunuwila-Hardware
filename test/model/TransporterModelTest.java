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
public class TransporterModelTest {
    
    public TransporterModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerTransporter method, of class TransporterModel.
     */
    @Test
    public void testRegisterTransporter() {
        System.out.println("registerTransporter");
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        TransporterModel instance = new TransporterModel();
        String expResult = "";
        String result = instance.registerTransporter(name, nic, email, contactNo, address, city, distictNo, provinceNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateTransporter method, of class TransporterModel.
     */
    @Test
    public void testUpdateTransporter() {
        System.out.println("updateTransporter");
        String transporterNo = "";
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        TransporterModel instance = new TransporterModel();
        String expResult = "";
        String result = instance.updateTransporter(transporterNo, name, nic, email, contactNo, address, city, distictNo, provinceNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTransporter method, of class TransporterModel.
     */
    @Test
    public void testRemoveTransporter() {
        System.out.println("removeTransporter");
        String transporterNo = "";
        TransporterModel instance = new TransporterModel();
        String expResult = "";
        String result = instance.removeTransporter(transporterNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadTransporterTable method, of class TransporterModel.
     */
    @Test
    public void testLoadTransporterTable() {
        System.out.println("loadTransporterTable");
        String keyword = "";
        DefaultTableModel transporterTableModel = null;
        TransporterModel instance = new TransporterModel();
        instance.loadTransporterTable(keyword, transporterTableModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedTransporterData method, of class TransporterModel.
     */
    @Test
    public void testGetSelectedTransporterData() {
        System.out.println("getSelectedTransporterData");
        int transporterNo = 0;
        TransporterModel instance = new TransporterModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedTransporterData(transporterNo);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadTransporterTableFull method, of class TransporterModel.
     */
    @Test
    public void testLoadTransporterTableFull() {
        System.out.println("loadTransporterTableFull");
        String keywordFull = "";
        DefaultTableModel transporterTableModelFull = null;
        TransporterModel instance = new TransporterModel();
        instance.loadTransporterTableFull(keywordFull, transporterTableModelFull);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
