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
public class CompanyModelTest {
    
    public CompanyModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerCompany method, of class CompanyModel.
     */
    @Test
    public void testRegisterCompany() {
        System.out.println("registerCompany");
        String name = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        int countryNo = 0;
        CompanyModel instance = new CompanyModel();
        String expResult = "";
        String result = instance.registerCompany(name, email, contactNo, address, city, distictNo, provinceNo, countryNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCompany method, of class CompanyModel.
     */
    @Test
    public void testUpdateCompany() {
        System.out.println("updateCompany");
        String companyNo = "";
        String name = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        int countryNo = 0;
        CompanyModel instance = new CompanyModel();
        String expResult = "";
        String result = instance.updateCompany(companyNo, name, email, contactNo, address, city, distictNo, provinceNo, countryNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCompany method, of class CompanyModel.
     */
    @Test
    public void testRemoveCompany() {
        System.out.println("removeCompany");
        String companyNo = "";
        CompanyModel instance = new CompanyModel();
        String expResult = "";
        String result = instance.removeCompany(companyNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadCompanyTable method, of class CompanyModel.
     */
    @Test
    public void testLoadCompanyTable() {
        System.out.println("loadCompanyTable");
        String keyword = "";
        DefaultTableModel companyTableModel = null;
        CompanyModel instance = new CompanyModel();
        instance.loadCompanyTable(keyword, companyTableModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedCompanyData method, of class CompanyModel.
     */
    @Test
    public void testGetSelectedCompanyData() {
        System.out.println("getSelectedCompanyData");
        int companyNo = 0;
        CompanyModel instance = new CompanyModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedCompanyData(companyNo);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadCompanyTableFull method, of class CompanyModel.
     */
    @Test
    public void testLoadCompanyTableFull() {
        System.out.println("loadCompanyTableFull");
        String keywordFull = "";
        DefaultTableModel companyTableModelFull = null;
        CompanyModel instance = new CompanyModel();
        instance.loadCompanyTableFull(keywordFull, companyTableModelFull);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
