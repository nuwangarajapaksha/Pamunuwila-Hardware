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
public class GrnModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(GrnModel.class.getName());

    public GrnModel() {
        dbConnection = database.dbConnection.getConnection();
    }

    public int getGrnNo() {
        String query = "SELECT * FROM grn ORDER BY grn_no DESC LIMIT 1";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            int rowData = 0;
            while (rs.next()) {
                int grnNoo = rs.getInt("grn_no");
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

    public String saveGrn(String grnNo, Date grnDate, int supplierNo, String itemCount, String totalDiscount, String totalVat, String totalAmount) {
        String query = "INSERT INTO grn(grn_no, grn_date, supplier_no, grn_item_count, grn_discount, grn_vat, grn_amount)"
                + "VALUE(?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, grnNo);
            psm.setDate(2, new java.sql.Date(grnDate.getTime()));
            psm.setInt(3, supplierNo);
            psm.setString(4, itemCount);
            psm.setString(5, totalDiscount);
            psm.setString(6, totalVat);
            psm.setString(7, totalAmount);
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

    public String saveGrnItem(int productNo, double unitSellPrice, double qty, double unitBuyPrice, double discount, double vat, double amount, String grnNo) {
        String query1 = "INSERT INTO grn_item(product_no, grn_item_quantity, grn_item_unit_buy_price, grn_item_discount, grn_item_vat, grn_item_amount, grn_no) VALUE(?,?,?,?,?,?,?)";
        String query2 = "SELECT * FROM product WHERE product_no = ?";
        String query3 = "UPDATE product SET product_quantity = ?, product_unit_sell_price = ? WHERE product_no = ?";
        logger.debug("SQL query String: " + query1);
        logger.debug("SQL query String: " + query2);
        logger.debug("SQL query String: " + query3);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query1);
            psm.setInt(1, productNo);
            psm.setDouble(2, qty);
            psm.setDouble(3, unitBuyPrice);
            psm.setDouble(4, discount);
            psm.setDouble(5, vat);
            psm.setDouble(6, amount);
            psm.setString(7, grnNo);
            psm.execute();
            logger.debug("Query1 execution done");

            PreparedStatement psm2 = dbConnection.prepareStatement(query2);
            psm2.setInt(1, productNo);
            ResultSet rs = psm2.executeQuery();
            logger.debug("Query2 execution done");
            double currentQty = qty;
            while (rs.next()) {
                currentQty = rs.getDouble("product_quantity") + currentQty;
            }
            PreparedStatement psm3 = dbConnection.prepareStatement(query3);
            psm3.setDouble(1, currentQty);
            psm3.setDouble(2, unitSellPrice);
            psm3.setInt(3, productNo);
            psm3.execute();
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

    public void loadGrnTableFull(String keywordFull, DefaultTableModel grnTableModelFull) {
        String query = "SELECT * FROM grn INNER JOIN supplier "
                + "ON grn.supplier_no = supplier.supplier_no "
                + "WHERE grn_no LIKE ? OR grn_date LIKE ? OR supplier_name LIKE ? ORDER BY grn_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keywordFull + "%");
            psm.setString(2, "%" + keywordFull + "%");
            psm.setString(3, "%" + keywordFull + "%");
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            grnTableModelFull.setRowCount(0);
            while (rs.next()) {
                int grnNo = rs.getInt("grn_no");
                Date date = rs.getDate("grn_date");
                String supplierName = rs.getString("supplier_name");
                int itemCount = rs.getInt("grn_item_count");
                double totatlDiscount = rs.getDouble("grn_discount");
                double totatlVat = rs.getDouble("grn_vat");
                double totatlAmount = rs.getDouble("grn_amount");
                rowData = new Object[]{grnNo, date, supplierName, itemCount, totatlDiscount, totatlVat, totatlAmount};
                grnTableModelFull.addRow(rowData);
                logger.debug("grnTableModelFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public void loadGrnItemTableFull(String keywordFull1, DefaultTableModel grnItemTableModelFull) {
        String query = "SELECT * FROM grn_item INNER JOIN grn INNER JOIN product INNER JOIN unit "
                + "ON grn_item.grn_no = grn.grn_no AND grn_item.product_no = product.product_no AND product.unit_no = unit.unit_no "
                + "WHERE grn_item_no LIKE ? OR grn_item.grn_no LIKE ? OR grn_date LIKE ? OR grn_item.product_no LIKE ? OR product_name LIKE ? ORDER BY grn_item_no";
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
            grnItemTableModelFull.setRowCount(0);
            while (rs.next()) {
                int grnItemNo = rs.getInt("grn_item_no");
                Date buydate = rs.getDate("grn_date");
                int productNo = rs.getInt("product_no");
                String productName = rs.getString("product_name");
                double qty = rs.getDouble("grn_item_quantity");
                String unitName = rs.getString("unit_name");
                double unitBuyPrice = rs.getDouble("grn_item_unit_buy_price");
                double discount = rs.getDouble("grn_item_discount");
                double vat = rs.getDouble("grn_item_vat");
                double amount = rs.getDouble("grn_item_amount");
                int grnNo = rs.getInt("grn_no");
                rowData = new Object[]{grnItemNo, buydate, productNo, productName, qty, unitName, unitBuyPrice, discount, vat, amount, grnNo};
                grnItemTableModelFull.addRow(rowData);
                logger.debug("grnItemTableModelFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

}
