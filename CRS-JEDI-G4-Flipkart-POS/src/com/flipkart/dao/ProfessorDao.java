package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public class ProfessorDao implements ProfessorDaoInterface {
	
	private static Logger logger = Logger.getLogger(ProfessorDao.class);
	public static Professor login(String username, String password) {
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "Select * from professor where username=? and password=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			if(!rs.next())
				return null;
			Professor temp = new Professor();
			temp.setUserID(rs.getInt("id"));
			temp.setName(rs.getString("name"));
			temp.setEmail(rs.getString("email"));
			temp.setUsername(rs.getString("username"));
			temp.setPassword(rs.getString("password"));
			temp.setEmpID(rs.getString("empid"));
			return temp;
		} catch (Exception e) {

			logger.error(e);
		}
		return null;
	}

  public static boolean addProfessor(Professor s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO professor (name, email, username, password,empId,department) VALUES (?, ?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, s.getName()); // This would set age
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getUsername());
			stmt.setString(4, s.getPassword());

			stmt.setString(5, s.getEmpID());
			stmt.setString(6,s.getDept());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				s.setUserID(rs.getInt(1));
			}


		} catch (Exception e) {

			logger.error(e);
		}
		return true;

	}

}
