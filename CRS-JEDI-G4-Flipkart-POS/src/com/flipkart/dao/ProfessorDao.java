package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public class ProfessorDao {
	public static boolean addProfessor(Professor s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO professor (name, email, username, password,empId) VALUES (?, ?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, s.getName()); // This would set age
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getUsername());
			stmt.setString(4, s.getPassword());

			stmt.setString(5, s.getEmpID());
			stmt.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}
		return true;

	}

}
