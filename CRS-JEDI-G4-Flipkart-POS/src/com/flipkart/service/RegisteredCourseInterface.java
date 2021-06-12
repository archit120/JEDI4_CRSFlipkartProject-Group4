package com.flipkart.service;

import com.flipkart.bean.*;

import java.util.List;

public interface RegisteredCourseInterface {

	List<Student> viewEnrolledStudents(String courseCode);
	boolean checkAvailability(Course course);

	public boolean addRegisteredCourse(RegisteredCourse registeredCourse);
	public boolean dropRegisteredCourse(int sId , int cId); 

	public RegisteredCourse findRegisteredCourse(SemesterRegistration semesterRegistration, String courseID);
	public List<RegisteredCourse> findRegisteredCourses(SemesterRegistration semesterRegistration);

	public boolean markGrade(String courseID, CourseCatalogue courseCatalogue, String rollNo, Grade grade);

}
