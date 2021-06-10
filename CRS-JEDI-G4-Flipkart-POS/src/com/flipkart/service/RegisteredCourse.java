package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

public interface RegisteredCourse {
	boolean dropCourse(Course courseToBeDropped);
	boolean addGrade(String rollNo,Grade gradeToBeAdded);
	Grade viewGrade(String rollNo);
	
}
