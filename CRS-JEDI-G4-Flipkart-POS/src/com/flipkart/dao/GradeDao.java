package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.flipkart.bean.Grade;

public class GradeDao {
	
	public static boolean addGrade(Grade g) {
		
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO grade (grade) VALUES (?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, g.getGrade()); 
			stmt.executeUpdate();
			
		//	String sql1 = "SELECT LAST_INSERT_ID();"

		} catch (Exception e) {

			System.out.println(e);
		}
		return true;
		
	}

}
