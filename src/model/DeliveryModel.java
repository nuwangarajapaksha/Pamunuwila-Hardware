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
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class DeliveryModel {
    
    private Connection dbConnection;
    static Logger logger = Logger.getLogger(DeliveryModel.class.getName());

    public DeliveryModel() {
        dbConnection = database.dbConnection.getConnection();
    }

    public int getDeliveryNo() {
        String query = "SELECT * FROM delivery ORDER BY delivery_no DESC LIMIT 1";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            int rowData = 0;
            while (rs.next()) {
                int grnNoo = rs.getInt("delivery_no");
                rowData = grnNoo;
                logger.debug("return rowData");
                return rowData;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return 0");
        return 0;
    }

    public String saveDelivery(String deliveryNo, Date deliveryDate, int trnsporterNo, String invoiceNo, String startLocation, String endLocation, String deliveryCharge) {
        String query = "INSERT INTO delivery(delivery_no, delivery_date, transporter_no, customer_invoice_no, delivery_start_location, delivery_end_location, delivery_charge, delivery_status)"
                + "VALUE(?,?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, deliveryNo);
            psm.setDate(2, new java.sql.Date(deliveryDate.getTime()));
            psm.setInt(3, trnsporterNo);
            psm.setString(4, invoiceNo);
            psm.setString(5, startLocation);
            psm.setString(6, endLocation);
            psm.setString(7, deliveryCharge);
            psm.setInt(8, 1);
            psm.execute();
            logger.debug("Query execution done");
            logger.debug("return result");
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Error !";
        }
    }

    public String updateDelivery(String deliveryNo, Date deliveryDate, int trnsporterNo, String invoiceNo, String startLocation, String endLocation, String deliveryCharge) {
        String query = "UPDATE delivery SET delivery_date = ?, transporter_no = ?, customer_invoice_no = ?, delivery_start_location = ?, delivery_end_location = ?, delivery_charge = ? "
                + "WHERE delivery_no = ?";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setDate(1, new java.sql.Date(deliveryDate.getTime()));
            psm.setInt(2, trnsporterNo);
            psm.setString(3, invoiceNo);
            psm.setString(4, startLocation);
            psm.setString(5, endLocation);
            psm.setString(6, deliveryCharge);
            psm.setString(7, deliveryNo);
            psm.execute();
            logger.debug("Query execution done");
            logger.debug("return result");
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Error !";
        }
    }

    public String removeDelivery(String deliveryNo) {
        String query = "UPDATE delivery SET delivery_status = ? WHERE delivery_no = ?";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, 0);
            psm.setString(2, deliveryNo);
            psm.execute();
            logger.debug("Query execution done");
            logger.debug("return result");
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Error !";
        }
    }

    public void loadDeliveryTable(String keyword, DefaultTableModel deliveryTableModel) {
        String query = "SELECT * FROM delivery INNER JOIN transporter INNER JOIN customer_invoice "
                + "ON delivery.transporter_no = transporter.transporter_no AND delivery.customer_invoice_no = customer_invoice.customer_invoice_no "
                + "WHERE (delivery_no LIKE ? OR delivery_date LIKE ? OR transporter_name LIKE ? OR delivery.customer_invoice_no LIKE ?) AND delivery_status = ? ORDER BY delivery_no";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setString(3, "%" + keyword + "%");
            psm.setString(4, "%" + keyword + "%");
            psm.setInt(5, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            deliveryTableModel.setRowCount(0);
            while (rs.next()) {
                int deliveryNO = rs.getInt("delivery_no");
                Date date = rs.getDate("delivery_date");
                String transporterName = rs.getString("transporter_name");
                int invoiceNo = rs.getInt("customer_invoice_no");
                String startLocation = rs.getString("delivery_start_location");
                String endtLocation = rs.getString("delivery_end_location");
                double deliveryCharge = rs.getDouble("delivery_charge");
                rowData = new Object[]{deliveryNO,date,transporterName,invoiceNo,startLocation,endtLocation,deliveryCharge};
                deliveryTableModel.addRow(rowData);
                logger.debug("loadDeliveryTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedDeliveryData(int deliveryNo) {
        String query = "SELECT * FROM delivery INNER JOIN transporter INNER JOIN customer_invoice "
                + "ON delivery.transporter_no = transporter.transporter_no AND delivery.customer_invoice_no = customer_invoice.customer_invoice_no "
                + "WHERE delivery_no = ?";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, deliveryNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int deliveryNoo = rs.getInt("delivery_no");
                Date date = rs.getDate("delivery_date");
                int transporterNo = rs.getInt("transporter_no");
                String transporterName = rs.getString("transporter_name");
                int invoiceNo = rs.getInt("customer_invoice_no");
                String startLocation = rs.getString("delivery_start_location");
                String endLocation = rs.getString("delivery_end_location");
                double deliveryCharge = rs.getDouble("delivery_charge");
                rowData = new Object[]{deliveryNoo,date,transporterNo,transporterName,invoiceNo,startLocation,endLocation,deliveryCharge};
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

    public void loadDeliveryTableFull(String keywordFull, DefaultTableModel deliveryTableModelFull) {
        String query = "SELECT * FROM delivery INNER JOIN transporter INNER JOIN customer_invoice "
                + "ON delivery.transporter_no = transporter.transporter_no AND delivery.customer_invoice_no = customer_invoice.customer_invoice_no "
                + "WHERE (delivery_no LIKE ? OR delivery_date LIKE ? OR transporter_name LIKE ? OR delivery.customer_invoice_no LIKE ?) AND delivery_status = ? ORDER BY delivery_no";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keywordFull + "%");
            psm.setString(2, "%" + keywordFull + "%");
            psm.setString(3, "%" + keywordFull + "%");
            psm.setString(4, "%" + keywordFull + "%");
            psm.setInt(5, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            deliveryTableModelFull.setRowCount(0);
            while (rs.next()) {
                int deliveryNO = rs.getInt("delivery_no");
                Date date = rs.getDate("delivery_date");
                String transporterName = rs.getString("transporter_name");
                int invoiceNo = rs.getInt("customer_invoice_no");
                String startLocation = rs.getString("delivery_start_location");
                String endtLocation = rs.getString("delivery_end_location");
                double deliveryCharge = rs.getDouble("delivery_charge");
                rowData = new Object[]{deliveryNO,date,transporterName,invoiceNo,startLocation,endtLocation,deliveryCharge};
                deliveryTableModelFull.addRow(rowData);
                logger.debug("loadDeliveryTableFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }
    
}
