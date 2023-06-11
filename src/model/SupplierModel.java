/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class SupplierModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(SupplierModel.class.getName());

    public SupplierModel() {
        dbConnection = database.dbConnection.getConnection();
    }

    public String registerSupplier(String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo, int companyNo) {
        String query = "INSERT INTO supplier(supplier_name, supplier_nic, supplier_email, supplier_contact_no, supplier_address, supplier_city, district_no, province_no, company_no, supplier_status)"
                + "VALUE(?,?,?,?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, nic);
            psm.setString(3, email);
            psm.setString(4, contactNo);
            psm.setString(5, address);
            psm.setString(6, city);
            psm.setInt(7, distictNo);
            psm.setInt(8, provinceNo);
            psm.setInt(9, companyNo);
            psm.setInt(10, 1);
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

    public String updateSupplier(String supplierNo, String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo, int companyNo) {
        String query = "UPDATE supplier SET supplier_name = ?, supplier_nic = ?, supplier_email = ?, supplier_contact_no = ?, supplier_address = ?, supplier_city = ?, "
                + "district_no = ?, province_no = ?, company_no = ? WHERE supplier_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, nic);
            psm.setString(3, email);
            psm.setString(4, contactNo);
            psm.setString(5, address);
            psm.setString(6, city);
            psm.setInt(7, distictNo);
            psm.setInt(8, provinceNo);
            psm.setInt(9, companyNo);
            psm.setString(10, supplierNo);
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

    public String removeSupplier(String supplierNo) {
        String query = "UPDATE supplier SET supplier_status = ? WHERE supplier_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, 0);
            psm.setString(2, supplierNo);
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

    public void loadSupplierTable(String keyword, DefaultTableModel supplierTableModel) {
        String query = "SELECT * FROM supplier INNER JOIN district INNER JOIN province INNER JOIN company "
                + "ON supplier.district_no = district.district_no AND supplier.province_no = province.province_no AND supplier.company_no =company.company_no "
                + "WHERE (supplier_no LIKE ? OR supplier_name LIKE ? OR supplier_contact_no LIKE ? OR supplier_city LIKE ? OR company_name LIKE ?) AND supplier_status = ? ORDER BY supplier_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keyword + "%");
            psm.setString(2, "%" + keyword + "%");
            psm.setString(3, "%" + keyword + "%");
            psm.setString(4, "%" + keyword + "%");
            psm.setString(5, "%" + keyword + "%");
            psm.setInt(6, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            supplierTableModel.setRowCount(0);
            while (rs.next()) {
                int supplierNo = rs.getInt("supplier_no");
                String name = rs.getString("supplier_name");
                String email = rs.getString("supplier_email");
                String contactNo = rs.getString("supplier_contact_no");
                String city = rs.getString("supplier_city");
                String company = rs.getString("company_name");
                rowData = new Object[]{supplierNo, name, email, contactNo, city, company};
                supplierTableModel.addRow(rowData);
                logger.debug("loadSupplierTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedSupplierData(int supplierNo) {
        String query = "SELECT * FROM supplier WHERE supplier_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, supplierNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int supplierNoo = rs.getInt("supplier_no");
                String name = rs.getString("supplier_name");
                String nic = rs.getString("supplier_nic");
                String email = rs.getString("supplier_email");
                String contactNo = rs.getString("supplier_contact_no");
                String address = rs.getString("supplier_address");
                String city = rs.getString("supplier_city");
                int districtNo = rs.getInt("district_no");
                int provinceNo = rs.getInt("province_no");
                int companyNo = rs.getInt("company_no");
                rowData = new Object[]{supplierNoo, name, nic, email, contactNo, address, city, districtNo, provinceNo, companyNo};
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

    public void loadSupplierTableFull(String keywordFull, DefaultTableModel supplierTableModelFull) {
        String query = "SELECT * FROM supplier INNER JOIN district INNER JOIN province INNER JOIN company "
                + "ON supplier.district_no = district.district_no AND supplier.province_no = province.province_no AND supplier.company_no =company.company_no "
                + "WHERE (supplier_no LIKE ? OR supplier_name LIKE ? OR supplier_contact_no LIKE ? OR supplier_city LIKE ? OR company_name LIKE ?) AND supplier_status = ? ORDER BY supplier_no";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%" + keywordFull + "%");
            psm.setString(2, "%" + keywordFull + "%");
            psm.setString(3, "%" + keywordFull + "%");
            psm.setString(4, "%" + keywordFull + "%");
            psm.setString(5, "%" + keywordFull + "%");
            psm.setInt(6, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            supplierTableModelFull.setRowCount(0);
            while (rs.next()) {
                int supplierNo = rs.getInt("supplier_no");
                String name = rs.getString("supplier_name");
                String nic = rs.getString("supplier_nic");
                String email = rs.getString("supplier_email");
                String contactNo = rs.getString("supplier_contact_no");
                String address = rs.getString("supplier_address");
                String city = rs.getString("supplier_city");
                String district = rs.getString("district_name");
                String province = rs.getString("province_name");
                String company = rs.getString("company_name");
                rowData = new Object[]{supplierNo, name, nic, email, contactNo, address, city, district, province, company};
                supplierTableModelFull.addRow(rowData);
                logger.debug("loadSupplierTableFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

}
