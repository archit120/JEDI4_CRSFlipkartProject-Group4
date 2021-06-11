/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author anike
 *
 */
public class SemesterRegistrationImpl implements SemesterRegistrationInterface{

	private static List<SemesterRegistration> semesterRegistrations;

	public SemesterRegistrationImpl() {
		if(semesterRegistrations == null){
			semesterRegistrations = new ArrayList<>();
		}
	}

	@Override
	public boolean dropCourse(SemesterRegistration semesterRegistration, RegisteredCourse registeredCourse) {
//		semesterRegistration.
		return false;
	}

	@Override
	public List<Grade> viewGrades(SemesterRegistration semesterRegistration) {
		return null;
	}

	@Override
	public List<RegisteredCourse> viewGradesAndCourses(SemesterRegistration semesterRegistration) {
		return null;
	}
}
