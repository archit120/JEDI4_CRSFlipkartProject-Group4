package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.exception.CourseDoesntExistException;

import java.util.List;

// TODO: Auto-generated Javadoc
/** The Interface CourseCatalogueInterface. */
public interface CourseCatalogueInterface {

  /**
   * Adds the course catalogue.
   *
   * @param courseToBeAdded the course to be added
   * @return true, if successful
   */
  boolean addCourseCatalogue(CourseCatalogue courseToBeAdded);

  /**
   * Removes the course catalogue.
   *
   * @param courseCatalogue the course catalogue
   * @return true, if successful
   */
  boolean removeCourseCatalogue(CourseCatalogue courseCatalogue);

  /**
   * Find course.
   *
   * @param catalogue the catalogue
   * @param courseID the course ID
   * @return the course
 * @throws CourseDoesntExistException 
   */
  Course findCourse(CourseCatalogue catalogue, String courseID) throws CourseDoesntExistException;

  /**
   * Gets the courses.
   *
   * @param catalogue the catalogue
   * @return the courses
   */
  List<Course> getCourses(CourseCatalogue catalogue);

  /**
   * Gets the course catalogues.
   *
   * @return the course catalogues
   */
  List<CourseCatalogue> getCourseCatalogues();
}
