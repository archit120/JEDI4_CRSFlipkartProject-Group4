package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.RegisteredCourseDao;
import java.util.List;

// TODO: Auto-generated Javadoc
/** The Class RegisteredCourseImpl. */
public class RegisteredCourseImpl implements RegisteredCourseInterface {

  /** The maximum enrollment. */
  //	private static List<RegisteredCourse> registeredCourses;
  public static int maximumEnrollment = 10;

  /** Instantiates a new registered course impl. */
  public RegisteredCourseImpl() {
    //		if(registeredCourses == null){
    //			registeredCourses = new ArrayList<>();
    //		}
  }

  /**
   * Find registered course.
   *
   * @param semesterRegistration the semester registration
   * @param courseCode the course code
   * @return the registered course
   */
  @Override
  public RegisteredCourse findRegisteredCourse(
      SemesterRegistration semesterRegistration, String courseCode) {
    return RegisteredCourseDao.getRegisteredCourseBySemesterRegistrationIdAndCourseCode(
        semesterRegistration.getId(), courseCode);
  }

  /**
   * Adds the registered course.
   *
   * @param registeredCourse the registered course
   * @return true, if successful
   */
  @Override
  public boolean addRegisteredCourse(RegisteredCourse registeredCourse) {
    return RegisteredCourseDao.addRegisteredCourse(registeredCourse);
  }

  /**
   * Drop registered course.
   *
   * @param registeredCourse the registered course
   * @return true, if successful
   */
  @Override
  public boolean dropRegisteredCourse(RegisteredCourse registeredCourse) {
    return RegisteredCourseDao.deleteRegisteredCourse(registeredCourse);
  }

  /**
   * Find registered courses.
   *
   * @param semesterRegistration the semester registration
   * @return the list
   */
  @Override
  public List<RegisteredCourse> findRegisteredCourses(SemesterRegistration semesterRegistration) {
    return RegisteredCourseDao.getRegisteredCourseBySemesterRegistrationIdAndCourseCode(
        semesterRegistration.getId());
  }

  /**
   * Check availability.
   *
   * @param course the course
   * @return true, if successful
   */
  @Override
  public boolean checkAvailability(Course course) {
    return viewEnrolledStudents(course).size() <= maximumEnrollment;
  }

  /**
   * Mark grade.
   *
   * @param courseCode the course code
   * @param courseCatalogue the course catalogue
   * @param rollNo the roll no
   * @param grade the grade
   * @return true, if successful
   */
  @Override
  public boolean markGrade(
      String courseCode, CourseCatalogue courseCatalogue, String rollNo, Grade grade) {
    return RegisteredCourseDao.setGradeStudent(
        courseCode, courseCatalogue.getId(), rollNo, grade.getGrade());
  }

  /**
   * Mark grade.
   *
   * @param registeredCourse the registered course
   * @param grade the grade
   * @return true, if successful
   */
  public boolean markGrade(RegisteredCourse registeredCourse, Grade grade) {
    return RegisteredCourseDao.setGradeStudent(registeredCourse.getId(), grade.getGrade());
  }

  /**
   * View enrolled students.
   *
   * @param course the course
   * @return the list
   */
  @Override
  public List<Student> viewEnrolledStudents(Course course) {
    return RegisteredCourseDao.getEnrolledStudents(course.getId());
  }

  /**
   * View enrolled students.
   *
   * @param courseCatalogue the course catalogue
   * @param professor the professor
   * @return the list
   */
  @Override
  public List<Student> viewEnrolledStudents(CourseCatalogue courseCatalogue, Professor professor) {
    return RegisteredCourseDao.getEnrolledStudents(courseCatalogue.getId(), professor.getUserID());
  }
}
