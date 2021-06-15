/** */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.exception.LoginFailedException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProfessorInterface.
 *
 * @author anike
 */
public interface ProfessorInterface {

  /**
   * Adds the grade.
   *
   * @param registeredCourse the registered course
   * @param grade the grade
   * @return true, if successful
   */
  public boolean addGrade(RegisteredCourse registeredCourse, Grade grade);

  /**
   * Choose course.
   *
   * @param course the course
   * @return true, if successful
   */
//  public boolean chooseCourse(Course course);

  /**
   * Gets the enrolled students.
   *
   * @param courseCatalogue the course catalogue
   * @return the enrolled students
   */
  public List<Student> getEnrolledStudents(int courseCatalogue,String professorId);

  /**
   * Login.
   *
   * @param username the username
   * @param password the password
   * @return true, if successful
 * @throws LoginFailedException 
   */
  public boolean login(String username, String password) throws LoginFailedException;

  /** Logout. */
  public void logout();
}
