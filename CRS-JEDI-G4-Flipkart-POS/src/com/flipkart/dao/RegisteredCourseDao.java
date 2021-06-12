package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;

public class RegisteredCourseDao {
	public static boolean addRegisteredCourse(RegisteredCourse s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO registerCourse (sId,cId,gId,semId) VALUES (?,?,?,?)";
				
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, s.getsId()); // This would set age
			stmt.setInt(2, s.getcId());
			stmt.setInt(3, s.getgId());
			stmt.setInt(4, s.getSemId());


			//stmt.setString(5, s.getEmpID());
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
		 String sql = "SELECT sId from registercourse where cId=?";
	      
	      
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

}
