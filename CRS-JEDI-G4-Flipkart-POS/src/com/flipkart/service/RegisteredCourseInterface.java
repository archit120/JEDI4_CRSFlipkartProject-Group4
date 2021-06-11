package com.flipkart.service;

import com.flipkart.bean.Course;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;

import java.util.List;

public interface RegisteredCourseInterface {

	List<Student>viewEnrolledStudents(Course course);
//	public boolean dropCourse(Course courseToBeDropped);
	public boolean addGrade(RegisteredCourse registeredCourse, Grade gradeVal);
	public boolean checkAvailability(Course course);
	
}
