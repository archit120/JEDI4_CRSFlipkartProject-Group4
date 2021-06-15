package com.flipkart.dao;

import com.flipkart.bean.Payment;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

	  Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    PreparedStatement stmt1 = null;
    
    String sql1 = SQLConstants.makePayment_check;
    
    try {
    	stmt1 = conn.prepareStatement(sql1);
    	stmt1.setInt(1, p.getStudentId());
    	stmt1.setInt(2, p.getSemesterRegistrationId());
    	
    	ResultSet rs = stmt1.executeQuery();
    	
    	while(rs.next()) {
    		if(rs.getInt("cnt")  > 0) return false;
    	}
    }catch(Exception e){
    	logger.error(e);
    }
    
    String sql = SQLConstants.makePayment;

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

    } catch (Exception e) {

    	logger.error(e);
    }
    return true;
  }
}
