package com.flipkart.dao;

import com.flipkart.bean.SemesterRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.constants.SQLConstants;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/** The Class SemesterRegistrationDao. */
public class SemesterRegistrationDao implements SemesterRegistrationDaoInterface {

  private static Logger logger = Logger.getLogger(AdminDao.class);


  /**
   * Adds the semester registration.
   *
   * @param s the s
   * @return true, if successful
   */
  public static boolean addSemesterRegistration(SemesterRegistration s) {

	  Connection conn = Connection1.getConnection();

    PreparedStatement stmt = null;

    try {
      // System.out.println("hi");
      stmt = conn.prepareStatement(SQLConstants.addSemesterRegistration, Statement.RETURN_GENERATED_KEYS);
      stmt.setInt(1, s.getSemester()); // This would set age
      stmt.setInt(2, s.getYear());
      stmt.setInt(3, s.getStudentId());

      stmt.executeUpdate();
      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        s.setId(rs.getInt(1));
      }

    } catch (Exception e) {

    	logger.error(e);
    }
    return true;
  }

  /**
   * Gets the semester registrations.
   *
   * @param sql the sql
   * @return the semester registrations
   */
  private static List<SemesterRegistration> getSemesterRegistrations(String sql) {
    Connection conn = Connection1.getConnection();

    PreparedStatement stmt = null;
    List<SemesterRegistration> courseList = new ArrayList<SemesterRegistration>();
    try {
      stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      // STEP 5: Extract data from result set
      while (rs.next()) {
        // Retrieve by column name
        SemesterRegistration temp = new SemesterRegistration();
        temp.setId(rs.getInt("id"));
        temp.setSemester(rs.getInt("semester"));
        temp.setYear(rs.getInt("year"));
        temp.setStudentId(rs.getInt("studentId"));
        courseList.add(temp);
      }
      stmt.close();
      conn.close();
    } catch (Exception e) {

    	logger.error(e);
    }
    return courseList;
  }

  /**
   * Gets the semester registrations by student id.
   *
   * @param studentId the student id
   * @return the semester registrations by student id
   */
  public static List<SemesterRegistration> getSemesterRegistrationsByStudentId(int studentId) {
    return getSemesterRegistrations(
        SQLConstants.getSemesterRegisrationsByStudentId + studentId);
  }

  /**
   * Gets the semester registrations.
   *
   * @return the semester registrations
   */
  public static List<SemesterRegistration> getSemesterRegistrations() {
    return getSemesterRegistrations(SQLConstants.getSemesterRegistrations);
  }

}
