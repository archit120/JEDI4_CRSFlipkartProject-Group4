package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

	public static Admin login(String username, String password) {
		
		
		
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "Select * from admin where username=? and password=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			if(!rs.next())
				return null;
			Admin temp = new Admin();
			temp.setUserID(rs.getInt("id"));
			temp.setName(rs.getString("name"));
			temp.setEmail(rs.getString("email"));
			temp.setUsername(rs.getString("username"));
			temp.setPassword(rs.getString("password"));
			temp.setEmpID(rs.getString("empid"));
			return temp;
		} catch (Exception e) {

			System.out.println(e);
		}
		return null;
	}

	public static boolean addAdmin(Admin s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO admin (name, email, username, password, empid) VALUES (?, ?,?,?,?)";
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

	public static List<Admin> getAdmins() {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		List<Admin> admins = new ArrayList<Admin>();
		String sql = "Select * from admin ";
		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//Retrieve by column name
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

			System.out.println(e);
		}

		return admins;
	}

}

