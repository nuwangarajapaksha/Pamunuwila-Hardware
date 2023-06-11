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
public class CompanyModel {

    private Connection dbConnection;
    static Logger logger = Logger.getLogger(CompanyModel.class.getName());

    public CompanyModel() {
        dbConnection = database.dbConnection.getConnection();
    }

    public String registerCompany(String name, String email, String contactNo, String address, String city, int distictNo, int provinceNo, int countryNo) {
        String query = "INSERT INTO company(company_name, company_email, company_contact_no, company_address, company_city, district_no, province_no, country_no, company_status)"
                + "VALUE(?,?,?,?,?,?,?,?,?)";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, email);
            psm.setString(3, contactNo);
            psm.setString(4, address);
            psm.setString(5, city);
            psm.setInt(6, distictNo);
            psm.setInt(7, provinceNo);
            psm.setInt(8, countryNo);
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

    public String updateCompany(String companyNo, String name, String email, String contactNo, String address, String city, int distictNo, int provinceNo, int countryNo) {
        String query = "UPDATE company SET company_name = ?, company_email = ?, company_contact_no = ?, company_address = ?, company_city = ?, district_no = ?, "
                + "province_no = ?, country_no = ? WHERE company_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, email);
            psm.setString(3, contactNo);
            psm.setString(4, address);
            psm.setString(5, city);
            psm.setInt(6, distictNo);
            psm.setInt(7, provinceNo);
            psm.setInt(8, countryNo);
            psm.setString(9, companyNo);
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

    public String removeCompany(String companyNo) {
        String query = "UPDATE company SET company_status = ? WHERE company_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, 0);
            psm.setString(2, companyNo);
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

    public void loadCompanyTable(String keyword, DefaultTableModel companyTableModel) {
        String query = "SELECT * FROM company INNER JOIN district INNER JOIN province INNER JOIN country "
                + "ON company.district_no = district.district_no AND company.province_no = province.province_no AND company.country_no = country.country_no "
                + "WHERE (company_no LIKE ? OR company_name LIKE ? OR company_contact_no LIKE ? OR company_city LIKE ? OR country_name LIKE ?) AND company_status = ? ORDER BY company_no";
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
            companyTableModel.setRowCount(0);
            while (rs.next()) {
                int companyNo = rs.getInt("company_no");
                String name = rs.getString("company_name");
                String email = rs.getString("company_email");
                String contactNo = rs.getString("company_contact_no");
                String city = rs.getString("company_city");
                String country = rs.getString("country_name");
                rowData = new Object[]{companyNo, name, email, contactNo, city, country};
                companyTableModel.addRow(rowData);
                logger.debug("loadCompanyTable [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

    public Object[] getSelectedCompanyData(int companyNo) {
        String query = "SELECT * FROM company WHERE company_no = ?";
        logger.debug("SQL query String: " + query);

        try {
            PreparedStatement psm = dbConnection.prepareStatement(query);
            psm.setInt(1, companyNo);
            ResultSet rs = psm.executeQuery();
            logger.debug("Query execution done");
            Object[] rowData = null;
            while (rs.next()) {
                int companyNoo = rs.getInt("company_no");
                String name = rs.getString("company_name");
                String email = rs.getString("company_email");
                String contactNo = rs.getString("company_contact_no");
                String address = rs.getString("company_address");
                String city = rs.getString("company_city");
                int districtNo = rs.getInt("district_no");
                int provinceNo = rs.getInt("province_no");
                int countryNo = rs.getInt("country_no");
                rowData = new Object[]{companyNoo, name, email, contactNo, address, city, districtNo, provinceNo, countryNo};
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

    public void loadCompanyTableFull(String keywordFull, DefaultTableModel companyTableModelFull) {
        String query = "SELECT * FROM company INNER JOIN district INNER JOIN province INNER JOIN country "
                + "ON company.district_no = district.district_no AND company.province_no = province.province_no AND company.country_no = country.country_no "
                + "WHERE (company_no LIKE ? OR company_name LIKE ? OR company_contact_no LIKE ? OR company_city LIKE ? OR country_name LIKE ?) AND company_status = ? ORDER BY company_no";
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
            companyTableModelFull.setRowCount(0);
            while (rs.next()) {
                int companyNo = rs.getInt("company_no");
                String name = rs.getString("company_name");
                String email = rs.getString("company_email");
                String contactNo = rs.getString("company_contact_no");
                String address = rs.getString("company_address");
                String city = rs.getString("company_city");
                String district = rs.getString("district_name");
                String province = rs.getString("province_name");
                String country = rs.getString("country_name");
                rowData = new Object[]{companyNo, name, email, contactNo, address, city, district, province, country};
                companyTableModelFull.addRow(rowData);
                logger.debug("loadCompanyTableFull [addRow]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
    }

}
