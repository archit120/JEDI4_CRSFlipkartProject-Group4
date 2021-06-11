/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.bean.Student;

import java.util.List;

/**
 * @author anike
 *
 */
public interface SemesterRegistrationInterface {

	public List<Grade> viewGrades(SemesterRegistration semesterRegistration);
	public List<RegisteredCourse> viewGradesAndCourses(SemesterRegistration semesterRegistration);

	public List<SemesterRegistration> viewSemesterRegistrations(Student student);

	boolean addSemesterRegistration(SemesterRegistration semesterRegistration);

}
