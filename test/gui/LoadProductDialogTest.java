/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EZIO AUDITORY
 */
public class LoadProductDialogTest {
    
    public LoadProductDialogTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of productTableFullSettings method, of class LoadProductDialog.
     */
    @Test
    public void testProductTableFullSettings() {
        System.out.println("productTableFullSettings");
        JTable jtable = null;
        LoadProductDialog instance = null;
        instance.productTableFullSettings(jtable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class LoadProductDialog.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LoadProductDialog.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
