/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class ProductModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(ProductModel.class.getName());

    public ProductModel() {
        dbConnection = database.dbConnection.getConnection();
    }

    public String registerProduct(String name, String qty, String unitSellPrice, String discount, String tax, int unitNo, String image, String description) {
        String query = "INSERT INTO product(product_name, product_image_url, product_description, product_quantity, unit_no, product_unit_sell_price, product_discount, product_tax, product_status)"
                + "VALUE(?,?,?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, image);
            psm.setString(3, description);
            psm.setString(4, qty);
            psm.setInt(5, unitNo);
            psm.setString(6, unitSellPrice);
            psm.setString(7, discount);
            psm.setString(8, tax);
            psm.setInt(9, 1);
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

    public String updateProduct(String productNo, String name, String qty, String unitSellPrice, String discount, String tax, int unitNo) {
        String query = "UPDATE product SET product_name = ?, product_quantity = ?, unit_no = ?, product_unit_sell_price = ?, product_discount = ?, product_tax = ? "
                + "WHERE product_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, qty);
            psm.setInt(3, unitNo);
            psm.setString(4, unitSellPrice);
            psm.setString(5, discount);
            psm.setString(6, tax);
            psm.setString(7, productNo);
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

    public String saveProduct(String productNo, String image, String description) {
        String query = "UPDATE product SET product_image_url = ?, product_description = ? WHERE product_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, image);
            psm.setString(2, description);
            psm.setString(3, productNo);
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

    public String removeProduct(String productNo) {
        String query = "UPDATE product SET product_status = ? WHERE product_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, 0);
            psm.setString(2, productNo);
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

    public void loadProductTable(String keyword, DefaultTableModel productTableModel) {
        String query = "SELECT * FROM product INNER JOIN unit "
                + "ON product.unit_no = unit.unit_no "
                + "WHERE (product_no LIKE ? OR product_name LIKE ?) AND product_status = ? ORDER BY product_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setInt(3, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            productTableModel.setRowCount(0);
            while (rs.next()) {
                int productNo = rs.getInt("product_no");
                String name = rs.getString("product_name");
                double qty = rs.getDouble("product_quantity");
                String unit = rs.getString("unit_name");
                double unitSellPrice = rs.getDouble("product_unit_sell_price");
                rowData = new Object[]{productNo, name, qty, unit, unitSellPrice};
                productTableModel.addRow(rowData);
                logger.debug("loadProductTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedProductData(int productNo) {
        String query = "SELECT * FROM product INNER JOIN unit ON product.unit_no = unit.unit_no WHERE product_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, productNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int productNoo = rs.getInt("product_no");
                String name = rs.getString("product_name");
                double qty = rs.getDouble("product_quantity");
                int unitNo = rs.getInt("unit_no");
                double unitSellPrice = rs.getDouble("product_unit_sell_price");
                double discount = rs.getDouble("product_discount");
                double tax = rs.getDouble("product_tax");
                String image = rs.getString("product_image_url");
                String description = rs.getString("product_description");
                String unitName = rs.getString("unit_name");
                rowData = new Object[]{productNoo, name, qty, unitNo, unitSellPrice, discount, tax, image, description, unitName};
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

    public void loadProductTableFull(String keywordFull, DefaultTableModel productTableModelFull) {
        String query = "SELECT * FROM product INNER JOIN unit "
                + "ON product.unit_no = unit.unit_no "
                + "WHERE (product_no LIKE ? OR product_name LIKE ?) AND product_status = ? ORDER BY product_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keywordFull + "%");
            psm.setString(2, "%" + keywordFull + "%");
            psm.setInt(3, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            productTableModelFull.setRowCount(0);
            while (rs.next()) {
                int productNo = rs.getInt("product_no");
                String name = rs.getString("product_name");
                String image = rs.getString("product_image_url");

                ImageIcon ii = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(160, 100, Image.SCALE_SMOOTH));
                JLabel imageLable = new JLabel();
                imageLable.setIcon(ii);

                String description = rs.getString("product_description");
                double qty = rs.getDouble("product_quantity");
                String unit = rs.getString("unit_name");
                double unitSellPrice = rs.getDouble("product_unit_sell_price");
                double discount = rs.getDouble("product_discount");
                double tax = rs.getDouble("product_tax");
                rowData = new Object[]{productNo, name, imageLable, description, qty, unit, unitSellPrice, discount, tax};
                productTableModelFull.addRow(rowData);
                logger.debug("loadProductTableFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

}
