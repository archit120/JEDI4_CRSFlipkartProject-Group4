package com.flipkart.dao;

import com.flipkart.bean.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/** The Class PaymentDao. */
public class PaymentDao implements PaymentDaoInterface {
	

private static Logger logger = Logger.getLogger(PaymentDao.class);


  /**
   * Make payment.
   *
   * @param p the p
   * @return true, if successful
   */
  public static boolean makePayment(Payment p) {
	  //BasicConfigurator.configure();
    Connection conn = Connection1.getConnection();

    PreparedStatement stmt = null;
    String sql = "INSERT INTO payment (mode, studentId , semesterRegistrationId ) VALUES (?,?,?)";

    try {
      stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, p.getMode());
      stmt.setInt(2, p.getStudentId());
      stmt.setInt(3, p.getSemesterRegistrationId());
      stmt.executeUpdate();
      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        p.setId(rs.getInt(1));
      }
      logger.info("Pay done");

    } catch (Exception e) {

    	logger.error(e);
    }
    return true;
  }
}
