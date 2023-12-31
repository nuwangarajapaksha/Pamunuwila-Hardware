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
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class ComboBoxLoadModel {
    
    private Connection dbConnection;
    static Logger logger = Logger.getLogger(ComboBoxLoadModel.class.getName());
    
    public ComboBoxLoadModel(){
        dbConnection = database.dbConnection.getConnection();
    }
    public Vector districtComboBoxLoad() {
        String query = "SELECT * FROM district ORDER BY district_no";
        logger.debug("SQL query String: " + query);
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString("district_name"));
            }
            logger.debug("return Vector");
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return null");
        return null;
    }

    public Vector provinceComboBoxLoad() {
        String query = "SELECT * FROM province ORDER BY province_no";
        logger.debug("SQL query String: " + query);
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString("province_name"));
            }
            logger.debug("return Vector");
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return null");
        return null;
    }
    
    public Vector countryComboBoxLoad() {
        String query = "SELECT * FROM country ORDER BY country_no";
        logger.debug("SQL query String: " + query);
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString("country_name"));
            }
            logger.debug("return Vector");
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return null");
        return null;
    }

    public Vector companyComboBoxLoad() {
        String query = "SELECT * FROM company ORDER BY company_no";
        logger.debug("SQL query String: " + query);
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString("company_name"));
            }
            logger.debug("return Vector");
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return null");
        return null;
    }

    public Vector jobroleComboBoxLoad() {
        String query = "SELECT * FROM jobrole ORDER BY jobrole_no";
        logger.debug("SQL query String: " + query);
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString("jobrole_name"));
            }
            logger.debug("return Vector");
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return null");
        return null;
    }

    public Vector unitComboBoxLoad() {
        String query = "SELECT * FROM unit ORDER BY unit_no";
        logger.debug("SQL query String: " + query);
        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString("unit_name"));
            }
            logger.debug("return Vector");
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return null");
        return null;
    }
}
