package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.flipkart.bean.Payment;

public class PaymentDao {
	
	public static boolean makePayment(Payment p) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO payment (mode, studentId , semesterRegistrationId ) VALUES (?,?,?)";
				
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getMode());
			stmt.setInt(2, p.getStudentId());
			stmt.setInt(3, p.getSemesterRegistrationId());
			
			stmt.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}
		return true;
	}
}
