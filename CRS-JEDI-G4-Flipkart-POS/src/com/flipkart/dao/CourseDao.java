package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
