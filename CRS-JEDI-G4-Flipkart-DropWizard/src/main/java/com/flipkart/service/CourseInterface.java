package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotAvailable;
import com.flipkart.exception.CoursePreExistsException;
import java.util.List;

// TODO: Auto-generated Javadoc
/** The Interface CourseInterface. */
public interface CourseInterface {

  /**
   * Indicate professor.
   *
   * @param course the course
   * @param professor the professor
   * @return the boolean
 * @throws CourseNotAvailable 
   */
  public Boolean indicateProfessor (Course course, Professor professor) throws CourseNotAvailable;

  /**
   * Check availability.
   *
   * @param course the course
   * @return the boolean
   */
  public Boolean checkAvailability(Course course);

  /**
   * Find courses.
   *
   * @param courseCatalogue the course catalogue
   * @return the list
   */
  public List<Course> findCourses(CourseCatalogue courseCatalogue);

  /**
   * Find course.
   *
   * @param courseCatalogue the course catalogue
   * @param courseID the course ID
   * @return the course
   */
  public Course findCourse(CourseCatalogue courseCatalogue, String courseID);

  /**
   * Removes the course.
   *
   * @param courseCatalogue the course catalogue
   * @param courseID the course ID
   * @return true, if successful
   */
  public boolean removeCourse(CourseCatalogue courseCatalogue, String courseID);

  /**
   * View enrolled students.
   *
   * @param course the course
   * @return the list
   */
  public List<Student> viewEnrolledStudents(Course course);

  /**
   * Adds the course.
   *
   * @param course the course
   * @return true, if successful
   * @throws CoursePreExistsException the course pre exists exception
   */
  public boolean addCourse(Course course) throws CoursePreExistsException;
}
