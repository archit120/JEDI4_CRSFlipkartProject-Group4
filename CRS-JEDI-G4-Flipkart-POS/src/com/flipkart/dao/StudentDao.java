package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Student;

public class StudentDao implements StudentDaoInterface {

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
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, s.getName()); // This would set age
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getUsername());
			stmt.setString(4, s.getPassword());

			stmt.setString(5, s.getRollNo());
			stmt.setString(6, s.getDepartment());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				s.setUserID(rs.getInt(1));
			}


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
					 temp.setRollNo(rs.getString("rollno"));
					 temp.setDepartment(rs.getString("department"));

			    	  students.add(temp);
			    	 
			         
			      }
	
			} catch (Exception e) {
	
				System.out.println(e);
			}
		}
		return students;
		
	}
	public static int getIDfromRollNo(String rollno)
	{
		int sId=-1;
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "Select id from student where rollno=?";
	
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, rollno);
			 ResultSet rs = stmt.executeQuery();
//			System.out.println(rs);
			 while(rs.next()) {
				 sId=rs.getInt("id");
//			 System.out.println(cId);
			 }
			stmt.close();
			conn.close();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		
		return sId;
	}
}
