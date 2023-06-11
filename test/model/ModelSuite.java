/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author EZIO AUDITORY
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({model.GrnModelTest.class, model.LoginFormModelTest.class, model.UserModelTest.class, model.SupplierModelTest.class, model.TransporterModelTest.class, model.ComboBoxLoadModelTest.class, model.HomeModelTest.class, model.DeliveryModelTest.class, model.ProductModelTest.class, model.CompanyModelTest.class, model.CustomerModelTest.class, model.BackupAndRestoreModelTest.class, model.SalesModelTest.class})
public class ModelSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
