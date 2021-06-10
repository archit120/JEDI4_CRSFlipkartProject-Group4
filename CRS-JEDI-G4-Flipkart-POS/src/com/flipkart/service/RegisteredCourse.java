package com.flipkart.service;

public interface RegisteredCourse {
	boolean dropCourse(Course courseID);
	boolean addGrade(int studentID,Grade gradeToBeAdded);
	Grade viewGrade(int studentID);
	
}
