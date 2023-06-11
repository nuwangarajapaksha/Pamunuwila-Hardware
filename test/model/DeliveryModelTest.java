/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EZIO AUDITORY
 */
public class DeliveryModelTest {
    
    public DeliveryModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDeliveryNo method, of class DeliveryModel.
     */
    @Test
    public void testGetDeliveryNo() {
        System.out.println("getDeliveryNo");
        DeliveryModel instance = new DeliveryModel();
        int expResult = 0;
        int result = instance.getDeliveryNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveDelivery method, of class DeliveryModel.
     */
    @Test
    public void testSaveDelivery() {
        System.out.println("saveDelivery");
        String deliveryNo = "";
        Date deliveryDate = null;
        int trnsporterNo = 0;
        String invoiceNo = "";
        String startLocation = "";
        String endLocation = "";
        String deliveryCharge = "";
        DeliveryModel instance = new DeliveryModel();
        String expResult = "";
        String result = instance.saveDelivery(deliveryNo, deliveryDate, trnsporterNo, invoiceNo, startLocation, endLocation, deliveryCharge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDelivery method, of class DeliveryModel.
     */
    @Test
    public void testUpdateDelivery() {
        System.out.println("updateDelivery");
        String deliveryNo = "";
        Date deliveryDate = null;
        int trnsporterNo = 0;
        String invoiceNo = "";
        String startLocation = "";
        String endLocation = "";
        String deliveryCharge = "";
        DeliveryModel instance = new DeliveryModel();
        String expResult = "";
        String result = instance.updateDelivery(deliveryNo, deliveryDate, trnsporterNo, invoiceNo, startLocation, endLocation, deliveryCharge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeDelivery method, of class DeliveryModel.
     */
    @Test
    public void testRemoveDelivery() {
        System.out.println("removeDelivery");
        String deliveryNo = "";
        DeliveryModel instance = new DeliveryModel();
        String expResult = "";
        String result = instance.removeDelivery(deliveryNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadDeliveryTable method, of class DeliveryModel.
     */
    @Test
    public void testLoadDeliveryTable() {
        System.out.println("loadDeliveryTable");
        String keyword = "";
        DefaultTableModel deliveryTableModel = null;
        DeliveryModel instance = new DeliveryModel();
        instance.loadDeliveryTable(keyword, deliveryTableModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedDeliveryData method, of class DeliveryModel.
     */
    @Test
    public void testGetSelectedDeliveryData() {
        System.out.println("getSelectedDeliveryData");
        int deliveryNo = 0;
        DeliveryModel instance = new DeliveryModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedDeliveryData(deliveryNo);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadDeliveryTableFull method, of class DeliveryModel.
     */
    @Test
    public void testLoadDeliveryTableFull() {
        System.out.println("loadDeliveryTableFull");
        String keywordFull = "";
        DefaultTableModel deliveryTableModelFull = null;
        DeliveryModel instance = new DeliveryModel();
        instance.loadDeliveryTableFull(keywordFull, deliveryTableModelFull);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
