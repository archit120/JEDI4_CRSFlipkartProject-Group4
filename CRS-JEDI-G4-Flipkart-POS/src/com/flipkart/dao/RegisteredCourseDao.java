package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
