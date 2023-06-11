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
public class SalesModelTest {
    
    public SalesModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInvoiceNo method, of class SalesModel.
     */
    @Test
    public void testGetInvoiceNo() {
        System.out.println("getInvoiceNo");
        SalesModel instance = new SalesModel();
        int expResult = 0;
        int result = instance.getInvoiceNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveInvoice method, of class SalesModel.
     */
    @Test
    public void testSaveInvoice() {
        System.out.println("saveInvoice");
        String invoiceNo = "";
        Date invoiceDate = null;
        int customerNo = 0;
        String itemCount = "";
        String deliveryCharge = "";
        String totalDiscount = "";
        String totalTax = "";
        String totalAmount = "";
        SalesModel instance = new SalesModel();
        String expResult = "";
        String result = instance.saveInvoice(invoiceNo, invoiceDate, customerNo, itemCount, deliveryCharge, totalDiscount, totalTax, totalAmount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveSales method, of class SalesModel.
     */
    @Test
    public void testSaveSales() {
        System.out.println("saveSales");
        int productNo = 0;
        double qty = 0.0;
        double unitSellPrice = 0.0;
        double discount = 0.0;
        double tax = 0.0;
        double amount = 0.0;
        String invoiceNo = "";
        SalesModel instance = new SalesModel();
        String expResult = "";
        String result = instance.saveSales(productNo, qty, unitSellPrice, discount, tax, amount, invoiceNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadInvoiceTableFull method, of class SalesModel.
     */
    @Test
    public void testLoadInvoiceTableFull() {
        System.out.println("loadInvoiceTableFull");
        String keywordFull = "";
        DefaultTableModel invoiceTableModelFull = null;
        SalesModel instance = new SalesModel();
        instance.loadInvoiceTableFull(keywordFull, invoiceTableModelFull);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadSalesTableFull method, of class SalesModel.
     */
    @Test
    public void testLoadSalesTableFull() {
        System.out.println("loadSalesTableFull");
        String keywordFull1 = "";
        DefaultTableModel salesTableModelFull = null;
        SalesModel instance = new SalesModel();
        instance.loadSalesTableFull(keywordFull1, salesTableModelFull);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedInvoiceData method, of class SalesModel.
     */
    @Test
    public void testGetSelectedInvoiceData() {
        System.out.println("getSelectedInvoiceData");
        int invoiceNo = 0;
        SalesModel instance = new SalesModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedInvoiceData(invoiceNo);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadInvoiceTableFullForLoadInvoiceDialog method, of class SalesModel.
     */
    @Test
    public void testLoadInvoiceTableFullForLoadInvoiceDialog() {
        System.out.println("loadInvoiceTableFullForLoadInvoiceDialog");
        String keywordFull = "";
        DefaultTableModel invoiceTableModelFull = null;
        SalesModel instance = new SalesModel();
        instance.loadInvoiceTableFullForLoadInvoiceDialog(keywordFull, invoiceTableModelFull);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
