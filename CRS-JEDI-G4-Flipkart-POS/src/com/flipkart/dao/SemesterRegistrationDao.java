package com.flipkart.dao;

import com.flipkart.bean.SemesterRegistration;
import com.flipkart.bean.SemesterRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SemesterRegistrationDao {
	public static boolean addSemesterRegistration(SemesterRegistration s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO semesterregistration (semester, year, studentid) VALUES (?,?, ?)";
				
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, s.getSemester()); // This would set age
			stmt.setInt(2, s.getYear());
			stmt.setInt(3, s.getStudentId());

			s.setId(stmt.executeUpdate());


		} catch (Exception e) {

			System.out.println(e);
		}
		return true;

	}

	private static List<SemesterRegistration> getSemesterRegistrations(String sql) {
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		List<SemesterRegistration> courseList = new ArrayList<SemesterRegistration>();
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			//STEP 5: Extract data from result set
			while (rs.next()) {
				//Retrieve by column name
				SemesterRegistration temp = new SemesterRegistration();
				temp.setId(rs.getInt("id"));
				temp.setSemester(rs.getInt("semester"));
				temp.setYear(rs.getInt("year"));
				temp.setStudentId(rs.getInt("year"));
				courseList.add(temp);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {

			System.out.println(e);
		}
		return courseList;
	}

	public static List<SemesterRegistration> getSemesterRegistrationsByStudentId(int studentId) {
		return getSemesterRegistrations("select * from semesterregistration where studentid="+studentId);
	}

	public static List<SemesterRegistration> getSemesterRegistrations() {
		return getSemesterRegistrations("select * from semesterregistration");
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
	
		public static boolean addCouseToTeach(int cId,int pId) {
			
			Connection conn = Connection1.getConnection();

			PreparedStatement stmt = null;
			String sql = "UPDATE course SET pId = ? where id = ? ";
			
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, pId);
				stmt.setInt(2, cId);
				
				stmt.executeUpdate();
			}catch(Exception e) {
				System.out.println(e);
			}
			
			return true;
			
			
		}

}
