/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.SemesterRegistration;

import java.util.List;

/**
 * @author anike
 *
 */
public interface SemesterRegistrationInterface {

	public boolean dropCourse(SemesterRegistration semesterRegistration, RegisteredCourse registeredCourse);
	public List<Grade> viewGrades(SemesterRegistration semesterRegistration);
	public List<RegisteredCourse> viewGradesAndCourses(SemesterRegistration semesterRegistration);


}
