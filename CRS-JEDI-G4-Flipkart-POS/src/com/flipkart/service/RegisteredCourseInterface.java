package com.flipkart.service;

import com.flipkart.bean.*;

import java.util.List;

public interface RegisteredCourseInterface {

	List<Student> viewEnrolledStudents(Course course);
	boolean checkAvailability(Course course);

	public boolean addRegisteredCourse(RegisteredCourse registeredCourse);
	public boolean dropRegisteredCourse(RegisteredCourse registeredCourse);

	public RegisteredCourse findRegisteredCourse(SemesterRegistration semesterRegistration, String courseID);
	public List<RegisteredCourse> findRegisteredCourses(SemesterRegistration semesterRegistration);

}
