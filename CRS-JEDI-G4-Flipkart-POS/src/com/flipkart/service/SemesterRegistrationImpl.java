/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.SemesterRegistrationDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anike
 *
 */
public class SemesterRegistrationImpl implements SemesterRegistrationInterface{


	public SemesterRegistrationImpl() {
//		if(semesterRegistrations == null){
//			semesterRegistrations = new ArrayList<>();
//		}
	}

	@Override
	public boolean addSemesterRegistration(SemesterRegistration semesterRegistration) {
		return SemesterRegistrationDao.addSemesterRegistration(semesterRegistration);
	}

	@Override
	public List<Grade> viewGrades(SemesterRegistration semesterRegistration) {

		List<Grade> grades = new ArrayList<>();
		RegisteredCourseImpl registeredCourses = new RegisteredCourseImpl();
		for(RegisteredCourse temp : registeredCourses.findRegisteredCourses(semesterRegistration))
		{
			Grade t2 = new Grade();
			t2.setGrade(temp.getGradeId());
			grades.add(t2);
		}
		return grades;
	}

	@Override
	public List<SemesterRegistration> viewSemesterRegistrations(int student) {
		return SemesterRegistrationDao.getSemesterRegistrationsByStudentId(student);
	}

	@Override
	public List<RegisteredCourse> viewGradesAndCourses(SemesterRegistration semesterRegistration) {
		RegisteredCourseImpl registeredCourses = new RegisteredCourseImpl();
		return registeredCourses.findRegisteredCourses(semesterRegistration);
	}
}
