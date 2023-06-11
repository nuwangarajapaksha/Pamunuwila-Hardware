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
public class BackupAndRestoreModelTest {
    
    public BackupAndRestoreModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of backup method, of class BackupAndRestoreModel.
     */
    @Test
    public void testBackup() {
        System.out.println("backup");
        String backupPath = "";
        BackupAndRestoreModel instance = new BackupAndRestoreModel();
        String expResult = "";
        String result = instance.backup(backupPath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restore method, of class BackupAndRestoreModel.
     */
    @Test
    public void testRestore() {
        System.out.println("restore");
        String restorePath = "";
        BackupAndRestoreModel instance = new BackupAndRestoreModel();
        String expResult = "";
        String result = instance.restore(restorePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
