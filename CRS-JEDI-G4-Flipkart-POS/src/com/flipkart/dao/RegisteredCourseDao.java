package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.bean.ReportCard;

public class RegisteredCourseDao implements RegisteredCourseDaoInterface {
	public static boolean addRegisteredCourse(RegisteredCourse s) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "INSERT INTO registeredCourse (semesterRegistrationId, courseId, grade, studentId) VALUES (?, ?, ?, ?);";
				
		try {
		//System.out.println("hi");
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, s.getStudentId()); // This would set age
			stmt.setInt(2, s.getCourseId());
			stmt.setInt(3, s.getGradeId());
			stmt.setInt(4, s.getSemesterRegistrationId());


			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				s.setId(rs.getInt(1));
			}


		} catch (Exception e) {

			System.out.println(e);
		}
		return true;

	}
	private static List<RegisteredCourse> getRegisteredCourses(String sql) {
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		List<RegisteredCourse> courseList = new ArrayList<RegisteredCourse>();
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			//STEP 5: Extract data from result set
			while (rs.next()) {
				//Retrieve by column name
				RegisteredCourse temp = new RegisteredCourse();
				temp.setId(rs.getInt("id"));
				temp.setSemesterRegistrationId(rs.getInt("semesterRegistrationId"));
				temp.setCourseId(rs.getInt("courseId"));
				temp.setGradeId(rs.getInt("grade"));
				temp.setStudentId(rs.getInt("studentId"));
				courseList.add(temp);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {

			System.out.println(e);
		}
		return courseList;
	}

	public static List<RegisteredCourse> getRegisteredCourseBySemesterRegistrationIdAndCourseCode(int semesterRegistrationId) {
		return getRegisteredCourses("select * from registeredcourse where semesterRegistrationId="+semesterRegistrationId);
	}
	public static RegisteredCourse getRegisteredCourseBySemesterRegistrationIdAndCourseCode(int semesterRegistrationId, String courseCode) {
		return getRegisteredCourses("select * from registeredcourse where semesterRegistrationId="+semesterRegistrationId + " and courseid in (select id from course where coursecode='"+courseCode +"')").get(0);
	}

	public static boolean deleteRegisteredCourse(RegisteredCourse registeredCourse) {
		
		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		String sql = "DELETE FROM registeredCourse where id = ?";
		try {
			//System.out.println("hi");
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, registeredCourse.getId()); // This would set age

				stmt.executeUpdate();

			} catch (Exception e) {

				System.out.println(e);
			}
		return true;
		
	}
	
	public static List<Student> getEnrolledStudents(int courseCatalogueId, int professorId) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		List<Integer> enrolledStudentsId = new ArrayList<Integer>();
		try {
			String sql = "SELECT registeredCourse.studentId from registeredCourse, course where registeredCourse.courseid=course.id and course.courseCatalogueId=? and course.professorId=?";


			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, courseCatalogueId);
			stmt.setInt(2, professorId);
			ResultSet rs = stmt.executeQuery();
			//STEP 5: Extract data from result set
			while (rs.next()) {
				//Retrieve by column name

				int temp = rs.getInt("registeredCourse.studentId");
				enrolledStudentsId.add(temp);

			}
			stmt.close();
			conn.close();
		} catch (Exception e) {

			System.out.println(e);
		}
		//STEP 6: Clean-up environment
		// rs.close();
		return StudentDao.getStudentsfromId(enrolledStudentsId);
//		return enrolledStudentsId;
	}

	public static List<Student> getEnrolledStudents(int courseId) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;
		List<Integer> enrolledStudentsId = new ArrayList<Integer>();
		try {
			String sql = "SELECT studentId from registeredCourse where registeredCourse.courseid=?";


			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, courseId);
			ResultSet rs = stmt.executeQuery();
			//STEP 5: Extract data from result set
			while (rs.next()) {
				//Retrieve by column name

				int temp = rs.getInt("studentId");
				enrolledStudentsId.add(temp);

			}
			stmt.close();
			conn.close();
		} catch (Exception e) {

			System.out.println(e);
		}
		//STEP 6: Clean-up environment
		// rs.close();
		return StudentDao.getStudentsfromId(enrolledStudentsId);
//		return enrolledStudentsId;
	}




	public static boolean setGradeStudent(String courseCode, int courseCatalogueId, String rollNo, int grade) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;

		try {
			String sql = "UPDATE registeredcourse SET grade = ? where  courseID = (select Id from course where courseCode=? and courseCatalogueId=?) and studentId = (select Id from student where rollno=?)";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, grade);
			stmt.setString(2, courseCode);
			stmt.setInt(3, courseCatalogueId);
			stmt.setString(4, rollNo);

			stmt.executeUpdate();


		}catch(Exception e){
			System.out.println(e);
		}

		return true;
	}
	public static boolean setGradeStudent(int id, int grade) {

		Connection conn = Connection1.getConnection();

		PreparedStatement stmt = null;

		try {
			String sql = "UPDATE registeredcourse SET grade = ? where  Id=?";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, grade);
			stmt.setInt(2, id);
			stmt.executeUpdate();


		}catch(Exception e){
			System.out.println(e);
		}

		return true;
	}
	public static ReportCard getReportCard(int semesterRegistrationId) {
		double ans=0;
	
		Connection conn = Connection1.getConnection();
		ReportCard report=new ReportCard();
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		List <Integer> grade=new ArrayList<Integer>();
		List <Integer> courseId=new ArrayList<Integer>();
		List <String> courseCodes=new ArrayList<String>();
		try {
			
		//	String sql = "Select from registeredCourse where  cId = ? and sId = ?";
			String sql1="select avg(grade) as average from registeredcourse where semesterRegistrationId = ?";
			stmt1 = conn.prepareStatement(sql1);
			stmt1.setInt(1, semesterRegistrationId);
			ResultSet rs1=stmt1.executeQuery();
			while(rs1.next())
			{
				ans=rs1.getDouble("average");
			}
			report.setSgpa(ans);
			String sql = "select registeredcourse.courseId,registeredcourse.grade,course.courseCode from registeredcourse,course where semesterRegistrationId = ? and registeredcourse.courseId=course.id";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, semesterRegistrationId);
			
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				grade.add(rs.getInt("registeredcourse.grade"));
				courseId.add(rs.getInt("registeredcourse.courseId"));
				courseCodes.add(rs.getString("course.courseCode"));
			}
			report.setGrades(grade);
			report.setCourseIDs(courseId);
			report.setCourseCodes(courseCodes);

		}catch(Exception e){
						
			System.out.println(e);
		}
		return report;
		
		
	}

}
