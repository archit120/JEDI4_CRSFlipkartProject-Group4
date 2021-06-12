package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.RegisteredCourse;

public class RegisteredCourseDao {
	public static boolean addRegisteredCourse(RegisteredCourse s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO registeredCourse (semesterRegistrationId, courseId, grade, studentId) VALUES (?, ?, ?, ?);";
				
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, s.getStudentId()); // This would set age
			stmt.setInt(2, s.getCourseId());
			stmt.setInt(3, s.getGradeId());
			stmt.setInt(4, s.getSemesterRegistrationId());


			//stmt.setString(5, s.getEmpID());
			stmt.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}
		return true;

	}
	
	public static boolean deleteRegisteredCourse(int sId , int cId) {
		
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "DELETE FROM registeredCourse where sId = ? and cId = ?";
		try {
			//System.out.println("hi");
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, sId); // This would set age
				stmt.setInt(2, cId);
				
				stmt.executeUpdate();

			} catch (Exception e) {

				System.out.println(e);
			}
		return true;
		
	}
	
	public static List<Integer> getEnrolledStudents(int cId){
		
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		 List<Integer>enrolledStudentsId=new ArrayList<Integer>();
		try {
		 String sql = "SELECT sId from registeredCourse where cId=?";
	      
	      
	      stmt = conn.prepareStatement(sql);
	      stmt.setInt(1, cId);
	      ResultSet rs = stmt.executeQuery();
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	    	  
	    	  int temp=rs.getInt("sId");
	    	  enrolledStudentsId.add(temp);
	         
	      }
	      stmt.close();
	      conn.close();
		}catch (Exception e) {

			System.out.println(e);
		}
	      //STEP 6: Clean-up environment
	     // rs.close();
	     
		return enrolledStudentsId;
	}
	
	public static boolean setGradeStudent(int sId,int grade,int cId) {
		
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		
		
		
		try {
			
		//	String sql = "Select from registeredCourse where  cId = ? and sId = ?";
			String sql = "UPDATE registercourse SET grade = ? where  cId = ? and sId = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, grade);
			stmt.setInt(2, cId);
			stmt.setInt(3, sId);
			
			stmt.executeUpdate();
			
			
		}catch(Exception e){
			
			
			System.out.println(e);
		}
		
		return true;
	}

}
