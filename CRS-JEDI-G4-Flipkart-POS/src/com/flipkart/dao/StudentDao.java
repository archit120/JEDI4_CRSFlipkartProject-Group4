package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Student;

public class StudentDao {

	public static Student login(String username, String password) {
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "Select * from Student where username=? and password=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			if(!rs.next())
				return null;
			Student temp = new Student();
			temp.setUserID(rs.getInt("id"));
			temp.setName(rs.getString("name"));
			temp.setEmail(rs.getString("email"));
			temp.setUsername(rs.getString("username"));
			temp.setPassword(rs.getString("password"));
			temp.setRollNo(rs.getString("rollno"));
			temp.setDepartment(rs.getString("department"));
			return temp;
		} catch (Exception e) {

			System.out.println(e);
		}
		return null;
	}

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
	
	public static List<Student>getStudentsfromId(List<Integer>sId){
		
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		List<Student>students=new ArrayList<Student>();
		for(Integer id:sId) {
			String sql ="Select * from Student where id= ? ";
			try {
				stmt = conn.prepareStatement(sql);

				stmt.setInt(1,id);
				ResultSet rs = stmt.executeQuery();
				 while(rs.next()){
			         //Retrieve by column name
			    	  Student temp=new Student();
			    	  temp.setUserID(rs.getInt("id"));
			    	  temp.setName(rs.getString("name"));
			    	  temp.setEmail(rs.getString("email"));
			    	  temp.setUsername(rs.getString("username"));
			    	  
			    	  students.add(temp);
			    	 
			         
			      }
	
			} catch (Exception e) {
	
				System.out.println(e);
			}
		}
		return students;
		
	}
}
