package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.List;

public interface RegisteredCourseInterface {

	List<Student> viewEnrolledStudents(Course course);
	boolean dropCourse(Course courseToBeDropped);
	boolean addGrade(String rollNo,Grade gradeToBeAdded);
	Grade viewGrade(String rollNo);
	
}
