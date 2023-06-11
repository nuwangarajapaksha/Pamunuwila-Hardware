/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class TransporterModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(TransporterModel.class.getName());

    public TransporterModel() {
        dbConnection = database.dbConnection.getConnection();
    }

    public String registerTransporter(String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo) {
        String query = "INSERT INTO transporter(transporter_name, transporter_nic, transporter_email, transporter_contact_no, transporter_address, transporter_city, district_no, province_no, transporter_status)"
                + "VALUE(?,?,?,?,?,?,?,?,?)";
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

    public String updateTransporter(String transporterNo, String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo) {
        String query = "UPDATE transporter SET transporter_name = ?, transporter_nic = ?, transporter_email = ?, transporter_contact_no = ?, transporter_address = ?, transporter_city = ?, "
                + "district_no = ?, province_no = ? WHERE transporter_no = ?";
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
            psm.setString(9, transporterNo);
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

    public String removeTransporter(String transporterNo) {
        String query = "UPDATE transporter SET transporter_status = ? WHERE transporter_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, 0);
            psm.setString(2, transporterNo);
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

    public void loadTransporterTable(String keyword, DefaultTableModel transporterTableModel) {
        String query = "SELECT * FROM transporter INNER JOIN district INNER JOIN province "
                + "ON transporter.district_no = district.district_no AND transporter.province_no = province.province_no "
                + "WHERE (transporter_no LIKE ? OR transporter_name LIKE ? OR transporter_contact_no LIKE ? OR transporter_city LIKE ?) AND transporter_status = ? ORDER BY transporter_no";
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
            transporterTableModel.setRowCount(0);
            while (rs.next()) {
                int transporterNo = rs.getInt("transporter_no");
                String name = rs.getString("transporter_name");
                String email = rs.getString("transporter_email");
                String contactNo = rs.getString("transporter_contact_no");
                String city = rs.getString("transporter_city");
                rowData = new Object[]{transporterNo, name, email, contactNo, city};
                transporterTableModel.addRow(rowData);
                logger.debug("loadTransporterTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedTransporterData(int transporterNo) {
        String query = "SELECT * FROM transporter WHERE transporter_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, transporterNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int transporterNoo = rs.getInt("transporter_no");
                String name = rs.getString("transporter_name");
                String nic = rs.getString("transporter_nic");
                String email = rs.getString("transporter_email");
                String contactNo = rs.getString("transporter_contact_no");
                String address = rs.getString("transporter_address");
                String city = rs.getString("transporter_city");
                int districtNo = rs.getInt("district_no");
                int provinceNo = rs.getInt("province_no");
                rowData = new Object[]{transporterNoo, name, nic, email, contactNo, address, city, districtNo, provinceNo};
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

    public void loadTransporterTableFull(String keywordFull, DefaultTableModel transporterTableModelFull) {
        String query = "SELECT * FROM transporter INNER JOIN district INNER JOIN province "
                + "ON transporter.district_no = district.district_no AND transporter.province_no = province.province_no "
                + "WHERE (transporter_no LIKE ? OR transporter_name LIKE ? OR transporter_contact_no LIKE ? OR transporter_city LIKE ?) AND transporter_status = ? ORDER BY transporter_no";
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
            transporterTableModelFull.setRowCount(0);
            while (rs.next()) {
                int transporterNo = rs.getInt("transporter_no");
                String name = rs.getString("transporter_name");
                String nic = rs.getString("transporter_nic");
                String email = rs.getString("transporter_email");
                String contactNo = rs.getString("transporter_contact_no");
                String address = rs.getString("transporter_address");
                String city = rs.getString("transporter_city");
                String district = rs.getString("district_name");
                String province = rs.getString("province_name");
                rowData = new Object[]{transporterNo, name, nic, email, contactNo, address, city, district, province};
                transporterTableModelFull.addRow(rowData);
                logger.debug("loadTransporterTableFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

}
