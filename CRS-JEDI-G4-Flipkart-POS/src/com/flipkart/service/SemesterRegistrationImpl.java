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
	public boolean addSemesterRegistration(SemesterRegistration semesterRegistration) {
		return semesterRegistrations.add(semesterRegistration);
	}

	@Override
	public List<Grade> viewGrades(SemesterRegistration semesterRegistration) {
		List<Grade> grades = new ArrayList<>();
		RegisteredCourseImpl registeredCourses = new RegisteredCourseImpl();
//		for(RegisteredCourse temp : registeredCourses.findRegisteredCourses(semesterRegistration))
//			grades.add(temp.getGrade());
		return grades;
	}

	@Override
	public List<SemesterRegistration> viewSemesterRegistrations(Student student) {
		List<SemesterRegistration> ret = new ArrayList<>();
		for(SemesterRegistration s:semesterRegistrations)
			if(s.getStudent().getRollNo().equals(student.getRollNo()))
				ret.add(s);
		return ret;
	}

	@Override
	public List<RegisteredCourse> viewGradesAndCourses(SemesterRegistration semesterRegistration) {
		RegisteredCourseImpl registeredCourses = new RegisteredCourseImpl();
		return registeredCourses.findRegisteredCourses(semesterRegistration);
	}
}
