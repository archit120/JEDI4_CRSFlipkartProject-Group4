package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;

public class CourseDao {
	public static boolean addCourse(Course s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO course (courseCode, department, description, preRequisites, courseCatalogueId, professorId) VALUES (?,?,?,?,?,?)";
				
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, s.getCourseCode()); // This would set age
			stmt.setString(2, s.getDepartment());
			stmt.setString(3, s.getDescriptions());
			stmt.setString(4, s.getPreRequisites());
			stmt.setInt(5, s.getCourseCatalogueId());
			stmt.setInt(6, s.getProfessorId());
			
			s.setId(stmt.executeUpdate());

		} catch (Exception e) {

			System.out.println(e);
		}
		return true;

	}
	
	public static boolean removeCourse(int courseId) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "Delete from course where id=? ";
				
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, courseId);
			
			//stmt.setString(5, s.getEmpID());
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		
		return true;

	}

	private static Course readCourse(ResultSet rs) {
		try {
			Course temp = new Course();
			temp.setCourseCode(rs.getString("courseCode"));
			temp.setDepartment(rs.getString("department"));
			temp.setId(rs.getInt("id"));
			temp.setCourseCatalogueId(rs.getInt("courseCatalogueId"));
			temp.setProfessorId(rs.getInt("professorId"));
			temp.setPreRequisites(rs.getString("prerequisites"));
			temp.setDescriptions(rs.getString("description"));
			return temp;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	private static List<Course> getCourses(String sql) {
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		List<Course> courseList = new ArrayList<Course>();
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while (rs.next()) {
				//Retrieve by column name
				courseList.add(readCourse(rs));
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {

			System.out.println(e);
		}
		return courseList;
	}

	public  static Course getCourse(int courseId) {
		return getCourses("select * from course where id="+courseId).get(0);
	}

	public static List<Course> findCourses(CourseCatalogue courseCatalogue) {
		return getCourses("select * from course where courseCatalogueId="+courseCatalogue.getId());
	}

	public static Course findCourse(CourseCatalogue courseCatalogue, String coursecode) {
		return getCourses("select * from course where courseCatalogueId="+courseCatalogue.getId()+" and coursecode='" + coursecode + "'").get(0);
	}



		public static boolean markCourseToTeach(int cId,int pId) {			
			Connection conn = Connection1.getConnection();

			PreparedStatement stmt = null;
			String sql = "UPDATE course SET professorId = ? where id = ? ";
			
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
