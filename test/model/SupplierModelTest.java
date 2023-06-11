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
public class SupplierModelTest {
    
    public SupplierModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerSupplier method, of class SupplierModel.
     */
    @Test
    public void testRegisterSupplier() {
        System.out.println("registerSupplier");
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        int companyNo = 0;
        SupplierModel instance = new SupplierModel();
        String expResult = "";
        String result = instance.registerSupplier(name, nic, email, contactNo, address, city, distictNo, provinceNo, companyNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSupplier method, of class SupplierModel.
     */
    @Test
    public void testUpdateSupplier() {
        System.out.println("updateSupplier");
        String supplierNo = "";
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        int companyNo = 0;
        SupplierModel instance = new SupplierModel();
        String expResult = "";
        String result = instance.updateSupplier(supplierNo, name, nic, email, contactNo, address, city, distictNo, provinceNo, companyNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSupplier method, of class SupplierModel.
     */
    @Test
    public void testRemoveSupplier() {
        System.out.println("removeSupplier");
        String supplierNo = "";
        SupplierModel instance = new SupplierModel();
        String expResult = "";
        String result = instance.removeSupplier(supplierNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadSupplierTable method, of class SupplierModel.
     */
    @Test
    public void testLoadSupplierTable() {
        System.out.println("loadSupplierTable");
        String keyword = "";
        DefaultTableModel supplierTableModel = null;
        SupplierModel instance = new SupplierModel();
        instance.loadSupplierTable(keyword, supplierTableModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedSupplierData method, of class SupplierModel.
     */
    @Test
    public void testGetSelectedSupplierData() {
        System.out.println("getSelectedSupplierData");
        int supplierNo = 0;
        SupplierModel instance = new SupplierModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedSupplierData(supplierNo);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadSupplierTableFull method, of class SupplierModel.
     */
    @Test
    public void testLoadSupplierTableFull() {
        System.out.println("loadSupplierTableFull");
        String keywordFull = "";
        DefaultTableModel supplierTableModelFull = null;
        SupplierModel instance = new SupplierModel();
        instance.loadSupplierTableFull(keywordFull, supplierTableModelFull);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
