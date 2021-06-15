package com.flipkart.dao;

import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtil;
import com.flipkart.exception.GradeNotAssigned;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/** The Class RegisteredCourseDao. */
public class RegisteredCourseDao implements RegisteredCourseDaoInterface {
	
	private static Logger logger = Logger.getLogger(RegisteredCourseDao.class);


  /**
   * Adds the registered course.
   *
   * @param s the s
   * @return true, if successful
   */
  public static boolean addRegisteredCourse(RegisteredCourse s) {

	  Connection conn = DBUtil.getConnection();
	  
	  boolean check = true;

	    PreparedStatement stmt = null;
	    String sql1 = SQLConstants.addRegisteredCourse_check;
	    try {
	      stmt = conn.prepareStatement(sql1);
	      stmt.setInt(1, s.getCourseId());
	      stmt.setInt(2, s.getStudentId());
	      ResultSet rs = stmt.executeQuery();
	      rs.next();
	      int cnt = rs.getInt("cnt");
	      if (cnt > 0) check = false;
	    } catch (Exception e) {
	      check = false;
	      logger.error(e);
	    }

	    if (check == false) return check;

    stmt = null;
    String sql = SQLConstants.addRegisteredCourse;
    try {
      // System.out.println("hi");
      stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setInt(1, s.getStudentId()); // This would set age
      stmt.setInt(2, s.getCourseId());
      stmt.setInt(3, s.getGradeId());
      stmt.setInt(4, s.getSemesterRegistrationId());

      stmt.executeUpdate();

      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        s.setId(rs.getInt(1));
      }

    } catch (Exception e) {

    	logger.error(e);
    }
    return true;
  }

  /**
   * Gets the registered courses.
   *
   * @param sql the sql
   * @return the registered courses
   */
  private static List<RegisteredCourse> getRegisteredCourses(String sql) {
    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    List<RegisteredCourse> courseList = new ArrayList<RegisteredCourse>();
    try {
      stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      // STEP 5: Extract data from result set
      while (rs.next()) {
        // Retrieve by column name
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

    	logger.error(e);
    }
    return courseList;
  }

  /**
   * Gets the registered course by semester registration id and course code.
   *
   * @param semesterRegistrationId the semester registration id
   * @return the registered course by semester registration id and course code
   */
  public static List<RegisteredCourse> getRegisteredCourseBySemesterRegistrationIdAndCourseCode(
      int semesterRegistrationId) {
    return getRegisteredCourses(
            SQLConstants.registerCoursePrefix+" semesterRegistrationId=" + semesterRegistrationId);
  }

  /**
   * Gets the registered course by semester registration id and course code.
   *
   * @param semesterRegistrationId the semester registration id
   * @param courseCode the course code
   * @return the registered course by semester registration id and course code
   */
  public static RegisteredCourse getRegisteredCourseBySemesterRegistrationIdAndCourseCode(
      int semesterRegistrationId, String courseCode) {
    return getRegisteredCourses(
            SQLConstants.registerCoursePrefix+  "semesterRegistrationId="
                + semesterRegistrationId
                + " and courseid in (select id from course where coursecode='"
                + courseCode   
                + "')")
        .get(0);
  }

  /**
   * Delete registered course.
   *
   * @param registeredCourse the registered course
   * @return true, if successful
   */
  public static boolean deleteRegisteredCourse(RegisteredCourse registeredCourse) {

    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    String sql = SQLConstants.deleteRegisteredCourse;
    try {
      // System.out.println("hi");
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, registeredCourse.getId()); // This would set age

      stmt.executeUpdate();

    } catch (Exception e) {

    	logger.error(e);
    }
    return true;
  }

  /**
   * Gets the enrolled students.
   *
   * @param courseCatalogueId the course catalogue id
   * @param professorId the professor id
   * @return the enrolled students
   */
  public static List<Student> getEnrolledStudents(int courseCatalogueId, int professorId) {

    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    List<Integer> enrolledStudentsId = new ArrayList<Integer>();
    try {
      String sql =
          SQLConstants.getEnrolledStudent
              + " registeredCourse.courseid=course.id and course.courseCatalogueId=? and"
              + " course.professorId=?";

      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, courseCatalogueId);
      stmt.setInt(2, professorId);
      ResultSet rs = stmt.executeQuery();
      // STEP 5: Extract data from result set
      while (rs.next()) {
        // Retrieve by column name

        int temp = rs.getInt("registeredCourse.studentId");
        enrolledStudentsId.add(temp);
      }
      stmt.close();
      conn.close();
    } catch (Exception e) {

    	logger.error(e);
    }
    // STEP 6: Clean-up environment
    // rs.close();
    return StudentDao.getStudentsfromId(enrolledStudentsId);
    //		return enrolledStudentsId;
  }

  /**
   * Gets the enrolled students.
   *
   * @param courseId the course id
   * @return the enrolled students
   */
  public static List<Student> getEnrolledStudents(int courseId) {

    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    List<Integer> enrolledStudentsId = new ArrayList<Integer>();
    try {
      String sql = SQLConstants.registerCoursePrefix+"registeredCourse.courseid=?";

      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, courseId);
      ResultSet rs = stmt.executeQuery();
      // STEP 5: Extract data from result set
      while (rs.next()) {
        // Retrieve by column name

        int temp = rs.getInt("studentId");
        enrolledStudentsId.add(temp);
      }
      stmt.close();
      conn.close();
    } catch (Exception e) {

    	logger.error(e);
    }
    // STEP 6: Clean-up environment
    // rs.close();
    return StudentDao.getStudentsfromId(enrolledStudentsId);
    //		return enrolledStudentsId;
  }

  /**
   * Sets the grade student.
   *
   * @param courseCode the course code
   * @param courseCatalogueId the course catalogue id
   * @param rollNo the roll no
   * @param grade the grade
   * @return true, if successful
   */
  public static boolean setGradeStudent(
      String courseCode, int courseCatalogueId, String rollNo, int grade) {

    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;

    try {
      String sql =SQLConstants.setGradeStudent;
      stmt = conn.prepareStatement(sql);

      stmt.setInt(1, grade);
      stmt.setString(2, courseCode);
      stmt.setInt(3, courseCatalogueId);
      stmt.setString(4, rollNo);

      stmt.executeUpdate();

    } catch (Exception e) {
    	logger.error(e);
    }

    return true;
  }

  /**
   * Sets the grade student.
   *
   * @param id the id
   * @param grade the grade
   * @return true, if successful
   */
  public static boolean setGradeStudent(int id, int grade) {

    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;

    try {
      String sql = "UPDATE registeredcourse SET grade = ? where  Id=?";
      stmt = conn.prepareStatement(sql);

      stmt.setInt(1, grade);
      stmt.setInt(2, id);
      stmt.executeUpdate();

    } catch (Exception e) {
    	logger.error(e);
    }

    return true;
  }

  /**
   * Gets the report card.
   *
   * @param semesterRegistrationId the semester registration id
   * @return the report card
   */
  public static ReportCard getReportCard(int semesterRegistrationId)  throws GradeNotAssigned{
    double ans = 0;

    Connection conn = DBUtil.getConnection();
    ReportCard report = new ReportCard();
    PreparedStatement stmt = null;
    PreparedStatement stmt1 = null;
    List<Integer> grade = new ArrayList<Integer>();
    List<Integer> courseId = new ArrayList<Integer>();
    List<String> courseCodes = new ArrayList<String>();
    try {

      //	String sql = "Select from registeredCourse where  cId = ? and sId = ?";
      String sql1 =SQLConstants.getReportCard_GPA;
      stmt1 = conn.prepareStatement(sql1);
      stmt1.setInt(1, semesterRegistrationId);
      ResultSet rs1 = stmt1.executeQuery();
      while (rs1.next()) {
        ans = rs1.getDouble("average");
      }
      report.setSgpa(ans);
      String sql = SQLConstants.getRepoortCard
              + " registeredcourse,course where semesterRegistrationId = ? and"
              + " registeredcourse.courseId=course.id";
      stmt = conn.prepareStatement(sql);

      stmt.setInt(1, semesterRegistrationId);

      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
    	  
    	 if(rs.getInt("registeredcourse.grade") == -1) throw new GradeNotAssigned("Your grades are not been assigned"); 
        grade.add(rs.getInt("registeredcourse.grade"));
        courseId.add(rs.getInt("registeredcourse.courseId"));
        courseCodes.add(rs.getString("course.courseCode"));
      }
      report.setGrades(grade);
      report.setCourseIDs(courseId);
      report.setCourseCodes(courseCodes);

    } catch (Exception e) {

    	logger.error(e);
    }
    return report;
  }
}
