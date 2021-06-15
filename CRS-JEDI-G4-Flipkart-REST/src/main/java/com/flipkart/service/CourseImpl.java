package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDao;
import com.flipkart.exception.CourseNotAvailable;
import com.flipkart.exception.CoursePreExistsException;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/** The Class CourseImpl. */
public class CourseImpl implements CourseInterface {

  /** The courses. */
  private static List<Course> courses;

  /** Instantiates a new course impl. */
  public CourseImpl() {
    if (courses == null) courses = new ArrayList<>();
  }

  /**
   * Indicate professor.
   *
   * @param course the course
   * @param professor the professor
   * @return the boolean
   */
  @Override
  public Boolean indicateProfessor(Course course, Professor professor) throws CourseNotAvailable {
	 
    if (course.getProfessorId() != 0) throw new CourseNotAvailable(course.getCourseCode());
    course.setProfessorId(professor.getUserID());
    return CourseDao.markCourseToTeach(course.getId(), professor.getUserID());
  }

  /**
   * Adds the course.
   *
   * @param course the course
   * @return true, if successful
   * @throws CoursePreExistsException the course pre exists exception
   */
  @Override
  public boolean addCourse(Course course) throws CoursePreExistsException {
    boolean check = CourseDao.addCourse(course);
    if (check == true) return check;
    else throw new CoursePreExistsException(course.getCourseCode());
  }

  /**
   * Check availability.
   *
   * @param course the course
   * @return the boolean
   */
  @Override
  public Boolean checkAvailability(Course course) {
    RegisteredCourseImpl registeredCourse = new RegisteredCourseImpl();
    return registeredCourse.checkAvailability(course);
  }

  /**
   * Removes the course.
   *
   * @param courseCatalogue the course catalogue
   * @param courseCode the course code
   * @return true, if successful
   */
  @Override
  public boolean removeCourse(CourseCatalogue courseCatalogue, String courseCode) {
    return CourseDao.removeCourse(findCourse(courseCatalogue, courseCode).getId());
  }

  /**
   * Find courses.
   *
   * @param courseCatalogue the course catalogue
   * @return the list
   */
  @Override
  public List<Course> findCourses(CourseCatalogue courseCatalogue) {
    return CourseDao.findCourses(courseCatalogue);
  }

  /**
   * Find course.
   *
   * @param courseCatalogue the course catalogue
   * @param courseID the course ID
   * @return the course
   */
  @Override
  public Course findCourse(CourseCatalogue courseCatalogue, String courseID) {
    return CourseDao.findCourse(courseCatalogue, courseID);
  }

  /**
   * View enrolled students.
   *
   * @param course the course
   * @return the list
   */
  @Override
  public List<Student> viewEnrolledStudents(Course course) {
    return new RegisteredCourseImpl().viewEnrolledStudents(course);
  }
}
