package com.flipkart.dao;

import com.flipkart.bean.Professor;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/** The Class ProfessorDao. */
public class ProfessorDao implements ProfessorDaoInterface {
	
	private static Logger logger = Logger.getLogger(ProfessorDao.class);


  /**
   * Login.
   *
   * @param username the username
   * @param password the password
   * @return the professor
   */
  public static Professor login(String username, String password) {
    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    String sql = SQLConstants.professorLogin;
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);

      ResultSet rs = stmt.executeQuery();
      if (!rs.next()) return null;
      Professor temp = new Professor();
      temp.setUserID(rs.getInt("id"));
      temp.setName(rs.getString("name"));
      temp.setEmail(rs.getString("email"));
      temp.setUsername(rs.getString("username"));
      temp.setPassword(rs.getString("password"));
      temp.setEmpID(rs.getString("empid"));
      logger.info("Professor login successful");
      return temp;
    } catch (Exception e) {

    	logger.error(e);
    }
    return null;
  }

  /**
   * Adds the professor.
   *
   * @param s the s
   * @return true, if successful
   */
  public static boolean addProfessor(Professor s) {

	  Connection conn = DBUtil.getConnection();
    
    boolean check = true;

    PreparedStatement stmt = null;
    String sql1 = SQLConstants.addProfessor_check;
    try {
      stmt = conn.prepareStatement(sql1);
      stmt.setString(1, s.getEmpID());
//      stmt.setInt(2, s.getCourseCatalogueId());
      ResultSet rs = stmt.executeQuery();
      rs.next();
      int cnt = rs.getInt("cnt");
      if (cnt > 0) check = false;
    } catch (Exception e) {
      check = false;
      System.out.println(e);
    }

    if (check == false) return check;

    stmt = null;
    String sql =SQLConstants.addProfessor;
    try {
      stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, s.getName()); // This would set age
      stmt.setString(2, s.getEmail());
      stmt.setString(3, s.getUsername());
      stmt.setString(4, s.getPassword());

      stmt.setString(5, s.getEmpID());
      stmt.setString(6, s.getDept());
      stmt.executeUpdate();

      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        s.setUserID(rs.getInt(1));
      }
      logger.info("Professor added successfully");
    } catch (Exception e) {

    	logger.error(e);
    }
    return true;
  }
  
  public static boolean changePassword(int id,String password , String newPassword) {
		
		Connection conn = Connection1.getConnection();
		
		 String sql = "UPDATE professor SET PASSWORD = ? WHERE ID = ? AND PASSWORD = ?";
		 
		 try {
			 
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.setString(1, newPassword);
			 stmt.setInt(2, id);
			 stmt.setString(3, password);
			 stmt.executeUpdate();
			
			 return true;
			 
		 }catch(Exception e) {
			
			 logger.error(e.getMessage());
			 return false;
		 }
		 
		
	}
}
