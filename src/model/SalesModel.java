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
public class SalesModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(SalesModel.class.getName());

    public SalesModel() {
        dbConnection = database.dbConnection.getConnection();
    }

    public int getInvoiceNo() {
        String query = "SELECT * FROM customer_invoice ORDER BY customer_invoice_no DESC LIMIT 1";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            int rowData = 0;
            while (rs.next()) {
                int invoiceNo = rs.getInt("customer_invoice_no");
                rowData = invoiceNo;
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

    public String saveInvoice(String invoiceNo, Date invoiceDate, int customerNo, String itemCount, String deliveryCharge, String totalDiscount, String totalTax, String totalAmount) {
        String query = "INSERT INTO customer_invoice(customer_invoice_no, customer_invoice_date, customer_no, customer_invoice_item_count, customer_invoice_delivery_charge, customer_invoice_discount, customer_invoice_tax, customer_invoice_amount)"
                + "VALUE(?,?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, invoiceNo);
            psm.setDate(2, new java.sql.Date(invoiceDate.getTime()));
            psm.setInt(3, customerNo);
            psm.setString(4, itemCount);
            psm.setString(5, deliveryCharge);
            psm.setString(6, totalDiscount);
            psm.setString(7, totalTax);
            psm.setString(8, totalAmount);
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

    public String saveSales(int productNo, double qty, double unitSellPrice, double discount, double tax, double amount, String invoiceNo) {
        String query1 = "INSERT INTO sales(product_no, sales_quantity, sales_unit_sell_price, sales_discount, sales_tax, sales_amount, customer_invoice_no) VALUE(?,?,?,?,?,?,?)";
        String query2 = "SELECT * FROM product WHERE product_no = ?";
        String query3 = "UPDATE product SET product_quantity = ? WHERE product_no = ?";
        logger.debug("SQL query String: " + query1);
        logger.debug("SQL query String: " + query2);
        logger.debug("SQL query String: " + query3);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query1);
            psm.setInt(1, productNo);
            psm.setDouble(2, qty);
            psm.setDouble(3, unitSellPrice);
            psm.setDouble(4, discount);
            psm.setDouble(5, tax);
            psm.setDouble(6, amount);
            psm.setString(7, invoiceNo);
            psm.execute();
            logger.debug("Query1 execution done");

            PreparedStatement psm2 = dbConnection.prepareStatement(query2);
            psm2.setInt(1, productNo);
            ResultSet rs = psm2.executeQuery();
            logger.debug("Query2 execution done");
            double currentQty = qty;
            while (rs.next()) {
                currentQty = rs.getDouble("product_quantity") - currentQty;
            }
            PreparedStatement psm3 = dbConnection.prepareStatement(query3);
            psm3.setDouble(1, currentQty);
            psm3.setInt(2, productNo);
            psm3.execute();
            logger.debug("Query3 execution done");
            logger.debug("Query3 execution done");
            logger.debug("return result");
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Error !";
        }
    }

    public void loadInvoiceTableFull(String keywordFull, DefaultTableModel invoiceTableModelFull) {
        String query = "SELECT * FROM customer_invoice INNER JOIN customer "
                + "ON customer_invoice.customer_no = customer.customer_no "
                + "WHERE customer_invoice_no LIKE ? OR customer_invoice_date LIKE ? OR customer_name LIKE ? ORDER BY customer_invoice_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keywordFull + "%");
            psm.setString(2, "%" + keywordFull + "%");
            psm.setString(3, "%" + keywordFull + "%");
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            invoiceTableModelFull.setRowCount(0);
            while (rs.next()) {
                int invoiceNo = rs.getInt("customer_invoice_no");
                Date date = rs.getDate("customer_invoice_date");
                String customerName = rs.getString("customer_name");
                int itemCount = rs.getInt("customer_invoice_item_count");
                double diliveryCharge = rs.getDouble("customer_invoice_delivery_charge");
                double totatlDiscount = rs.getDouble("customer_invoice_discount");
                double totatlTax = rs.getDouble("customer_invoice_tax");
                double totatlAmount = rs.getDouble("customer_invoice_amount");
                rowData = new Object[]{invoiceNo, date, customerName, itemCount, diliveryCharge, totatlDiscount, totatlTax, totatlAmount};
                invoiceTableModelFull.addRow(rowData);
                logger.debug("loadInvoiceTableFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public void loadSalesTableFull(String keywordFull1, DefaultTableModel salesTableModelFull) {
        String query = "SELECT * FROM sales INNER JOIN customer_invoice INNER JOIN product INNER JOIN unit "
                + "ON sales.customer_invoice_no = customer_invoice.customer_invoice_no AND sales.product_no = product.product_no AND product.unit_no = unit.unit_no "
                + "WHERE sales_no LIKE ? OR customer_invoice.customer_invoice_no LIKE ? OR customer_invoice_date LIKE ? OR sales.product_no LIKE ? OR product_name LIKE ? ORDER BY sales_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keywordFull1 + "%");
            psm.setString(2, "%" + keywordFull1 + "%");
            psm.setString(3, "%" + keywordFull1 + "%");
            psm.setString(4, "%" + keywordFull1 + "%");
            psm.setString(5, "%" + keywordFull1 + "%");
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            salesTableModelFull.setRowCount(0);
            while (rs.next()) {
                int salesNo = rs.getInt("sales_no");
                Date sellDate = rs.getDate("customer_invoice_date");
                int productNo = rs.getInt("product_no");
                String productName = rs.getString("product_name");
                double qty = rs.getDouble("sales_quantity");
                String unitName = rs.getString("unit_name");
                double unitSellPrice = rs.getDouble("sales_unit_sell_price");
                double discount = rs.getDouble("sales_discount");
                double tax = rs.getDouble("sales_tax");
                double amount = rs.getDouble("sales_amount");
                int invoiceNo = rs.getInt("customer_invoice_no");
                rowData = new Object[]{salesNo, sellDate, productNo, productName, qty, unitName, unitSellPrice, discount, tax, amount, invoiceNo};
                salesTableModelFull.addRow(rowData);
                logger.debug("loadSalesTableFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedInvoiceData(int invoiceNo) {
        String query = "SELECT * FROM customer_invoice WHERE customer_invoice_no = ? ORDER BY customer_invoice_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, invoiceNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int invoiceNoo = rs.getInt("customer_invoice_no");
                double deliveryCharge = rs.getDouble("customer_invoice_delivery_charge");
                rowData = new Object[]{invoiceNoo, deliveryCharge};
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

    public void loadInvoiceTableFullForLoadInvoiceDialog(String keywordFull, DefaultTableModel invoiceTableModelFull) {
        String query = "SELECT * FROM customer_invoice INNER JOIN customer "
                + "ON customer_invoice.customer_no = customer.customer_no "
                + "WHERE (customer_invoice_no LIKE ? OR customer_invoice_date LIKE ? OR customer_name LIKE ?) AND customer_invoice_delivery_charge != ? ORDER BY customer_invoice_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keywordFull + "%");
            psm.setString(2, "%" + keywordFull + "%");
            psm.setString(3, "%" + keywordFull + "%");
            psm.setInt(4, 0);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            invoiceTableModelFull.setRowCount(0);
            while (rs.next()) {
                int invoiceNo = rs.getInt("customer_invoice_no");
                Date date = rs.getDate("customer_invoice_date");
                String customerName = rs.getString("customer_name");
                int itemCount = rs.getInt("customer_invoice_item_count");
                double diliveryCharge = rs.getDouble("customer_invoice_delivery_charge");
                double totatlDiscount = rs.getDouble("customer_invoice_discount");
                double totatlTax = rs.getDouble("customer_invoice_tax");
                double totatlAmount = rs.getDouble("customer_invoice_amount");
                rowData = new Object[]{invoiceNo, date, customerName, itemCount, diliveryCharge, totatlDiscount, totatlTax, totatlAmount};
                invoiceTableModelFull.addRow(rowData);
                logger.debug("loadInvoiceTableFullForLoadInvoiceDialog [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

}
