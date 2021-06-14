/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.SemesterRegistration;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SemesterRegistrationInterface.
 *
 * @author anike
 */
public interface SemesterRegistrationInterface {

	/**
	 * View grades.
	 *
	 * @param semesterRegistration the semester registration
	 * @return the list
	 */
	public List<Grade> viewGrades(SemesterRegistration semesterRegistration);
	
	/**
	 * View grades and courses.
	 *
	 * @param semesterRegistration the semester registration
	 * @return the list
	 */
	public List<RegisteredCourse> viewGradesAndCourses(SemesterRegistration semesterRegistration);

	/**
	 * View semester registrations.
	 *
	 * @param student the student
	 * @return the list
	 */
	public List<SemesterRegistration> viewSemesterRegistrations(int student);

	/**
	 * Adds the semester registration.
	 *
	 * @param semesterRegistration the semester registration
	 * @return true, if successful
	 */
	boolean addSemesterRegistration(SemesterRegistration semesterRegistration);

}
