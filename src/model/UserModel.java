/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class UserModel {
    
    private Connection dbConnection;
    static Logger logger = Logger.getLogger(UserModel.class.getName());
    
    public UserModel(){
        dbConnection = database.dbConnection.getConnection();
    }

    public String registerUser(String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo, String username, String password, int jobroleNo) {
        String query = "INSERT INTO user(user_name, user_nic, user_email, user_contact_no, user_address, user_city, district_no, province_no, user_username, user_password, jobrole_no, user_status)"
                + "VALUE(?,?,?,?,?,?,?,?,?,?,?,?)";
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
            psm.setString(9, username);
            psm.setString(10, password);
            psm.setInt(11, jobroleNo);
            psm.setInt(12, 1);
            psm.execute();
            logger.debug("Query execution done");
            logger.debug("return result");
            return "Success";
        }catch(SQLIntegrityConstraintViolationException e){
            return "Username Already Exist !";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Error !";
        }
    }

    public String updateUser(String userNo, String name, String nic, String email, String contactNo, String address, String city, int distictNo, int provinceNo, String username, String password, int jobroleNo) {
        String query = "UPDATE user SET user_name = ?, user_nic = ?, user_email = ?, user_contact_no = ?, user_address = ?, user_city = ?, "
                + "district_no = ?, province_no = ?,user_username = ?, user_password = ?, jobrole_no = ? WHERE user_no = ?";
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
            psm.setString(9, username);
            psm.setString(10, password);
            psm.setInt(11, jobroleNo);
            psm.setString(12, userNo);
            psm.execute();
            logger.debug("Query execution done");
            logger.debug("return result");
            return "Success";
        }catch(SQLIntegrityConstraintViolationException e){
            return "Username Already Exist !";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
            logger.error("return result");
            return "Error !";
        }
    }

    public String removeUser(String userNo) {
        String query = "UPDATE user SET user_status = ? WHERE user_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, 0);
            psm.setString(2, userNo);
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

    public void loadUserTable(String keyword, DefaultTableModel userTableModel) {
        String query = "SELECT * FROM user INNER JOIN district INNER JOIN province INNER JOIN jobrole "
                + "ON user.district_no = district.district_no AND user.province_no = province.province_no AND user.jobrole_no =jobrole.jobrole_no "
                + "WHERE (user_no LIKE ? OR user_name LIKE ? OR user_contact_no LIKE ? OR user_city LIKE ? OR jobrole_name LIKE ?) AND user_status = ? ORDER BY user_no";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%"+keyword+"%");
            psm.setString(2, "%"+keyword+"%");
            psm.setString(3, "%"+keyword+"%");
            psm.setString(4, "%"+keyword+"%");
            psm.setString(5, "%"+keyword+"%");
            psm.setInt(6, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            userTableModel.setRowCount(0);
            while(rs.next()){
                int userNo = rs.getInt("user_no");
                String name = rs.getString("user_name");
                String email = rs.getString("user_email");
                String contactNo = rs.getString("user_contact_no");
                String city = rs.getString("user_city");
                String username = rs.getString("user_username");
                String jobroleNo = rs.getString("jobrole_name");
                rowData = new Object[]{userNo,name,email,contactNo,city,username,jobroleNo};
                userTableModel.addRow(rowData);
                logger.debug("loadUserTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedUserData(int userNo) {
        String query = "SELECT * FROM user WHERE user_no = ?";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, userNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while(rs.next()){
                int userNoo = rs.getInt("user_no");
                String name = rs.getString("user_name");
                String nic = rs.getString("user_nic");
                String email = rs.getString("user_email");
                String contactNo = rs.getString("user_contact_no");
                String address = rs.getString("user_address");
                String city = rs.getString("user_city");
                int districtNo = rs.getInt("district_no");
                int provinceNo = rs.getInt("province_no");
                String username = rs.getString("user_username");
                String password = rs.getString("user_password");
                int jobroleNo = rs.getInt("jobrole_no");
                rowData = new Object[]{userNoo,name,nic,email,contactNo,address,city,districtNo,provinceNo,username,password,jobroleNo};
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

    public void loadUserTableFull(String keywordFull, DefaultTableModel userTableModelFull) {
        String query = "SELECT * FROM user INNER JOIN district INNER JOIN province INNER JOIN jobrole "
                + "ON user.district_no = district.district_no AND user.province_no = province.province_no AND user.jobrole_no =jobrole.jobrole_no "
                + "WHERE (user_no LIKE ? OR user_name LIKE ? OR user_contact_no LIKE ? OR user_city LIKE ? OR jobrole_name LIKE ?) AND user_status = ? ORDER BY user_no";
        logger.debug("SQL query String: " + query);
        
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, "%"+keywordFull+"%");
            psm.setString(2, "%"+keywordFull+"%");
            psm.setString(3, "%"+keywordFull+"%");
            psm.setString(4, "%"+keywordFull+"%");
            psm.setString(5, "%"+keywordFull+"%");
            psm.setInt(6, 1);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            userTableModelFull.setRowCount(0);
            while(rs.next()){
                int userNo = rs.getInt("user_no");
                String name = rs.getString("user_name");
                String nic = rs.getString("user_nic");
                String email = rs.getString("user_email");
                String contactNo = rs.getString("user_contact_no");
                String address = rs.getString("user_address");
                String city = rs.getString("user_city");
                String district = rs.getString("district_name");
                String province = rs.getString("province_name");
                String username = rs.getString("user_username");
                String jobroleNo = rs.getString("jobrole_name");
                rowData = new Object[]{userNo,name,nic,email,contactNo,address,city,district,province,username,jobroleNo};
                userTableModelFull.addRow(rowData);
                logger.debug("loadUserTableFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }
    
}
