/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.CourseDao;
import com.flipkart.dao.ProfessorDao;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfessorImpl.
 *
 * @author anike
 */
public class ProfessorImpl implements ProfessorInterface{

/** The professor instance. */
//	private static ArrayList<Professor> professors;
	private static Professor professorInstance;

	/**
	 * Gets the professor instance.
	 *
	 * @return the professor instance
	 */
	public static Professor getProfessorInstance() {
		return professorInstance;
	}

	/**
	 * Instantiates a new professor impl.
	 */
	public ProfessorImpl() {
//		if(professors == null)
//			professors = new ArrayList<>();
	}

	/**
	 * Adds the grade.
	 *
	 * @param registeredCourse the registered course
	 * @param grade the grade
	 * @return true, if successful
	 */
	@Override
	public boolean addGrade(RegisteredCourse registeredCourse, Grade grade) {
		if(CourseDao.getCourse(registeredCourse.getCourseId()).getProfessorId()!=professorInstance.getUserID())
			return false;
		registeredCourse.setGradeId(grade.getGrade());
		new RegisteredCourseImpl().markGrade(registeredCourse, grade);
		return true;
	}

	/**
	 * Logout.
	 */
	@Override
	public void logout() {
		professorInstance = null;
	}

	/**
	 * Choose course.
	 *
	 * @param course the course
	 * @return true, if successful
	 */
	@Override
	public boolean chooseCourse(Course course) {
		return new CourseImpl().indicateProfessor(course, professorInstance);
	}

	/**
	 * Gets the enrolled students.
	 *
	 * @param courseCatalogue the course catalogue
	 * @return the enrolled students
	 */
	@Override
	public List<Student> getEnrolledStudents(CourseCatalogue courseCatalogue) {
		return new RegisteredCourseImpl().viewEnrolledStudents(courseCatalogue, professorInstance);
	}

	/**
	 * Login.
	 *
	 * @param userID the user ID
	 * @param password the password
	 * @return true, if successful
	 */
	@Override
	public boolean login(String userID, String password) {

		Professor loginRes = ProfessorDao.login(userID, password);
		if(loginRes == null)
			return false;
		professorInstance = loginRes;
		return true;
  }

}
