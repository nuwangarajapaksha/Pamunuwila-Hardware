/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class HomeModel {
    private Connection dbConnection;
    static Logger logger = Logger.getLogger(HomeModel.class.getName());

    public HomeModel() {
        dbConnection = database.dbConnection.getConnection();
    }
    
    public Object[] getPurchaseAmount(){
       String query = "SELECT SUM(grn_amount) FROM grn" ;
       logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                double purchaseAmount = rs.getDouble("SUM(grn_amount)");
                rowData = new Object[]{purchaseAmount};
                logger.debug("return rowData");
                return rowData;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        } 
        logger.debug("return null");
        return null;
    }
    
    public Object[] getSalesAmount(){
       String query = "SELECT SUM(customer_invoice_amount) FROM customer_invoice;" ;
       logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                double salesAmount = rs.getDouble("SUM(customer_invoice_amount)");
                logger.debug("return rowData");
                rowData = new Object[]{salesAmount};
                return rowData;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        } 
        logger.debug("return null");
        return null;
    }
}
