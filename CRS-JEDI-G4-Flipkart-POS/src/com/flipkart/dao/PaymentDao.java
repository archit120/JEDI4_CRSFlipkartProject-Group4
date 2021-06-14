package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.flipkart.bean.Payment;

public class PaymentDao implements PaymentDaoInterface {
	
	private static Logger logger = Logger.getLogger(PaymentDao.class);
	
	public static boolean makePayment(Payment p) {

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
			if (rs.next()){
				p.setId(rs.getInt(1));
			}

		} catch (Exception e) {

			logger.error(e);
		}
		return true;
	}
}
