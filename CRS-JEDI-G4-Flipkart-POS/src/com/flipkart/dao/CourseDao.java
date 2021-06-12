package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public class CourseDao {
	public static boolean addCourse(Course s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO course (courseCode,department , descriptions, preRequisites,catalogId,pId) VALUES (?,?,?,?,?,?)";
				
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, s.getCourseCode()); // This would set age
			stmt.setString(2, s.getDepartment());
			stmt.setString(3, s.getDescriptions());
			stmt.setString(4, s.getPreRequisites());
		
			stmt.setInt(5, 1);
			
			stmt.setInt(6, 01);
			

			//stmt.setString(5, s.getEmpID());
			stmt.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}
		return true;

	}
	
	public static boolean removeCourse(String courseCode) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "Delete from course where courseCode=? ";
				
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseCode);
			
			//stmt.setString(5, s.getEmpID());
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		
		return true;

	}
	
	public static List<Course> listCourses(){
		
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		 List<Course>courseList=new ArrayList<Course>();
		try {
		 String sql = "SELECT* FROM course";
	      
	      
	      stmt = conn.prepareStatement(sql);
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	    	  Course temp=new Course();
	         temp.setCourseCode(rs.getString("courseCode"));
	         temp.setDepartment(rs.getString("department"));
	         

	         courseList.add(temp);
	      }
	      stmt.close();
	      conn.close();
		}catch (Exception e) {

			System.out.println(e);
		}
	      //STEP 6: Clean-up environment
	     // rs.close();
	     
		return courseList;
	}
	
	public static int getCourseIdfromCode(String courseCode) {
//		System.out.println(courseCode);
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "Select id from course where courseCode=?";
		int cId=-1;	
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseCode);
			 ResultSet rs = stmt.executeQuery();
//			System.out.println(rs);
			 while(rs.next()) {
			 cId=rs.getInt("id");
//			 System.out.println(cId);
			 }
			stmt.close();
			conn.close();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		
		return cId;
	}

}
