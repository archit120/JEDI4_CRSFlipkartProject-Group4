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
	public List<Grade> viewGrades(SemesterRegistration semesterRegistration) {
		List<Grade> grades = new ArrayList<>();
		RegisteredCourseImpl registeredCourses = new RegisteredCourseImpl();
		for(RegisteredCourse temp : registeredCourses.findRegisteredCourses(semesterRegistration))
			grades.add(temp.getGrade());
		return grades;
	}

	@Override
	public List<SemesterRegistration> viewSemesterRegistrations(Student student) {
		return null;
	}

	@Override
	public List<RegisteredCourse> viewGradesAndCourses(SemesterRegistration semesterRegistration) {
		RegisteredCourseImpl registeredCourses = new RegisteredCourseImpl();
		return registeredCourses.findRegisteredCourses(semesterRegistration);
	}
}
