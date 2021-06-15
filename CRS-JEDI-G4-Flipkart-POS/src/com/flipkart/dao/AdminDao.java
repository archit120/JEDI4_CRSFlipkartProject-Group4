package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtil;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/** The Class AdminDao. */
public class AdminDao implements AdminDaoInterface {

  private static Logger logger = Logger.getLogger(AdminDao.class);

  /**
   * Login.
   *
   * @param username the username
   * @param password the password
   * @return the admin
   */
  public static Admin login(String username, String password) {

    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    String sql = SQLConstants.adminLogin;

    try {

      stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();

      if (!rs.next()) {
    	  logger.error("Admin login failed");
        return null;
      }

      Admin temp = new Admin();
      temp.setUserID(rs.getInt("id"));
      temp.setName(rs.getString("name"));
      temp.setEmail(rs.getString("email"));
      temp.setUsername(rs.getString("username"));
      temp.setPassword(rs.getString("password"));
      temp.setEmpID(rs.getString("empid"));
      logger.info("Admin login successful");
      return temp;
    } catch (Exception e) {

      logger.error(e);
    }

    return null;
  }

  /**
   * Adds the admin.
   *
   * @param s the s
   * @return true, if successful
   */
  public static boolean addAdmin(Admin s) {

    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    String sql = SQLConstants.adminAdd;

    try {

      stmt = conn.prepareStatement(sql);
      stmt.setString(1, s.getName()); // This would set age
      stmt.setString(2, s.getEmail());
      stmt.setString(3, s.getUsername());
      stmt.setString(4, s.getPassword());
      stmt.setString(5, s.getEmpID());
      stmt.executeUpdate();
      logger.info("Admin created");
    } catch (Exception e) {

      logger.error(e);
    }

    return true;
  }

  /**
   * Gets the admins.
   *
   * @return the admins
   */
  public static List<Admin> getAdmins() {

    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    String sql = SQLConstants.adminList;

    List<Admin> admins = new ArrayList<Admin>();

    try {

      stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {

        // Retrieve by column name
        Admin temp = new Admin();
        temp.setUserID(rs.getInt("id"));
        temp.setName(rs.getString("name"));
        temp.setEmail(rs.getString("email"));
        temp.setUsername(rs.getString("username"));
        temp.setPassword(rs.getString("password"));
        temp.setEmpID(rs.getString("empid"));
        admins.add(temp);
      }
    } catch (Exception e) {

      logger.error(e);
    }

    return admins;
  }
}
