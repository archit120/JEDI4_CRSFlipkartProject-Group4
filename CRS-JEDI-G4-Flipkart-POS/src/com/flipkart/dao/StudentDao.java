package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.Student;

public class StudentDao {

	public static boolean addStudent(Student s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO student (name, email, username, password, rollno, department) VALUES (?, ?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, s.getName()); // This would set age
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getUsername());
			stmt.setString(4, s.getPassword());

			stmt.setString(5, s.getRollNo());
			stmt.setString(6, s.getDepartment());
			stmt.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}
		return true;

	}
}
