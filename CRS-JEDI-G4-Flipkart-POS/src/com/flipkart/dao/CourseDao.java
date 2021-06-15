package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.CourseDoesntExistException;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/** The Class CourseDao. */
public class CourseDao implements CourseDaoInterface {

  /**
   * Adds the course.
   *
   * @param s the s
   * @return true, if successful
   */
	
	private static Logger logger = Logger.getLogger(CourseDao.class);

  public static boolean addCourse(Course s) {

	 Connection conn = DBUtil.getConnection();
    boolean check = true;

    PreparedStatement stmt = null;
    String sql1 = SQLConstants.addCourse_check;
    try {
      stmt = conn.prepareStatement(sql1);
      stmt.setString(1, s.getCourseCode());
      stmt.setInt(2, s.getCourseCatalogueId());
      ResultSet rs = stmt.executeQuery();
      rs.next();
      int cnt = rs.getInt("cnt");
      if (cnt > 0) check = false;
    } catch (Exception e) {
      check = false;
      logger.error(e);
    }

    if (check == false) return check;

    String sql = SQLConstants.addCourse;
    stmt = null;

    try {
      // System.out.println("hi");
      stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, s.getCourseCode()); // This would set age
      stmt.setString(2, s.getDepartment());
      stmt.setString(3, s.getDescriptions());
      stmt.setString(4, s.getPreRequisites());
      stmt.setInt(5, s.getCourseCatalogueId());
      stmt.setInt(6, s.getProfessorId());
      stmt.executeUpdate();
      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        s.setId(rs.getInt(1));
      }

    } catch (Exception e) {
      check = false;
      logger.error(e);
    }
    return check;
  }

  /**
   * Removes the course.
   *
   * @param courseId the course id
   * @return true, if successful
   */
  public static boolean removeCourse(int courseId) {

    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    String sql = SQLConstants.removeCourse;

    try {
      // System.out.println("hi");
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, courseId);

      // stmt.setString(5, s.getEmpID());
      stmt.executeUpdate();
      stmt.close();
      conn.close();

    } catch (Exception e) {

    	logger.error(e);
    }

    return true;
  }

  /**
   * Read course.
   *
   * @param rs the rs
   * @return the course
   */
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
    } catch (Exception e) {
    	logger.error(e);
      return null;
    }
  }

  /**
   * Gets the courses.
   *
   * @param sql the sql
   * @return the courses
   */
  private static List<Course> getCourses(String sql) {
    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    List<Course> courseList = new ArrayList<Course>();
    try {
      stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      // STEP 5: Extract data from result set
      while (rs.next()) {
        // Retrieve by column name
        courseList.add(readCourse(rs));
      }
      stmt.close();
      conn.close();
    } catch (Exception e) {

    	logger.error(e);
    }
    return courseList;
  }

  /**
   * Gets the course.
   *
   * @param courseId the course id
   * @return the course
   */
  public static Course getCourse(int courseId) {
    return getCourses(SQLConstants.getCoursePrefix+" id=" + courseId).get(0);
  }

  /**
   * Find courses.
   *
   * @param courseCatalogue the course catalogue
   * @return the list
   */
  public static List<Course> findCourses(CourseCatalogue courseCatalogue) {
    return getCourses(SQLConstants.getCoursePrefix+" courseCatalogueId=" + courseCatalogue.getId());
  }

  /**
   * Find course.
   *
   * @param courseCatalogue the course catalogue
   * @param coursecode the coursecode
   * @return the course
 * @throws CourseDoesntExistException 
   */
  public static Course findCourse(CourseCatalogue courseCatalogue, String coursecode) throws CourseDoesntExistException {
    List<Course> courseList = getCourses(
            SQLConstants.getCoursePrefix+" courseCatalogueId="
                + courseCatalogue.getId()
                + " and coursecode='"
                + coursecode
                + "'");
        if(courseList.size()>0) return courseList.get(0);
        
        throw new CourseDoesntExistException();
  }

  /**
   * Mark course to teach.
   *
   * @param cId the c id
   * @param pId the id
   * @return true, if successful
   */
  public static boolean markCourseToTeach(int cId, int pId) {
    Connection conn = DBUtil.getConnection();

    PreparedStatement stmt = null;
    String sql = SQLConstants.markCourseToTeach;

    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, pId);
      stmt.setInt(2, cId);

      stmt.executeUpdate();
    } catch (Exception e) {
    	logger.error(e);
    }

    return true;
  }
}
