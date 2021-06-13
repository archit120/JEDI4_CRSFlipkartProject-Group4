package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.RegisteredCourseDao;

import java.util.List;

public class RegisteredCourseImpl implements RegisteredCourseInterface {

//	private static List<RegisteredCourse> registeredCourses;
	public static int maximumEnrollment = 10;

	public RegisteredCourseImpl() {
//		if(registeredCourses == null){
//			registeredCourses = new ArrayList<>();
//		}
	}

	@Override
	public RegisteredCourse findRegisteredCourse(SemesterRegistration semesterRegistration, String courseCode) {
		return RegisteredCourseDao.getRegisteredCourseBySemesterRegistrationIdAndCourseCode(semesterRegistration.getId(), courseCode);
	}

	@Override
	public boolean addRegisteredCourse(RegisteredCourse registeredCourse) {
		return RegisteredCourseDao.addRegisteredCourse(registeredCourse);
	}

	@Override
	public boolean dropRegisteredCourse(RegisteredCourse registeredCourse) {
		return RegisteredCourseDao.deleteRegisteredCourse(registeredCourse);
	}

	@Override
	public List<RegisteredCourse> findRegisteredCourses(SemesterRegistration semesterRegistration) {
		return RegisteredCourseDao.getRegisteredCourseBySemesterRegistrationIdAndCourseCode(semesterRegistration.getId());
	}

	@Override
	public boolean checkAvailability(Course course) {
		return viewEnrolledStudents(course).size() <= maximumEnrollment;
	}

	@Override
	public boolean markGrade(String courseCode, CourseCatalogue courseCatalogue, String rollNo, Grade grade) {
		return RegisteredCourseDao.setGradeStudent(courseCode, courseCatalogue.getId(), rollNo, grade.getGrade());
	}

	public boolean markGrade(RegisteredCourse registeredCourse, Grade grade) {
		return RegisteredCourseDao.setGradeStudent(registeredCourse.getId(), grade.getGrade());
	}

	@Override
	public List<Student> viewEnrolledStudents(Course course) {
		return RegisteredCourseDao.getEnrolledStudents(course.getId());
	}
	@Override
	public List<Student> viewEnrolledStudents(CourseCatalogue courseCatalogue, Professor professor) {
		return RegisteredCourseDao.getEnrolledStudents(courseCatalogue.getId(), professor.getUserID());
	}

}
