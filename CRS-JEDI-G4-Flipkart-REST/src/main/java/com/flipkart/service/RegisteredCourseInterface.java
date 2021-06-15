package com.flipkart.service;

import com.flipkart.bean.*;
import java.util.List;

// TODO: Auto-generated Javadoc
/** The Interface RegisteredCourseInterface. */
public interface RegisteredCourseInterface {

  /**
   * View enrolled students.
   *
   * @param courseCatalogue the course catalogue
   * @param professor the professor
   * @return the list
   */
  public List<Student> viewEnrolledStudents(CourseCatalogue courseCatalogue, Professor professor);

  /**
   * View enrolled students.
   *
   * @param course the course
   * @return the list
   */
  public List<Student> viewEnrolledStudents(Course course);

  /**
   * Check availability.
   *
   * @param course the course
   * @return true, if successful
   */
  boolean checkAvailability(Course course);

  /**
   * Adds the registered course.
   *
   * @param registeredCourse the registered course
   * @return true, if successful
   */
  public boolean addRegisteredCourse(RegisteredCourse registeredCourse);

  /**
   * Drop registered course.
   *
   * @param registeredCourse the registered course
   * @return true, if successful
   */
  public boolean dropRegisteredCourse(RegisteredCourse registeredCourse);

  /**
   * Find registered course.
   *
   * @param semesterRegistration the semester registration
   * @param courseID the course ID
   * @return the registered course
   */
  public RegisteredCourse findRegisteredCourse(
      SemesterRegistration semesterRegistration, String courseID);

  /**
   * Find registered courses.
   *
   * @param semesterRegistration the semester registration
   * @return the list
   */
  public List<RegisteredCourse> findRegisteredCourses(SemesterRegistration semesterRegistration);

  /**
   * Mark grade.
   *
   * @param courseID the course ID
   * @param courseCatalogue the course catalogue
   * @param rollNo the roll no
   * @param grade the grade
   * @return true, if successful
   */
  public boolean markGrade(
      String courseID, CourseCatalogue courseCatalogue, String rollNo, Grade grade);
}
