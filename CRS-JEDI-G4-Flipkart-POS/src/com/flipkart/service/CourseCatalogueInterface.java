package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogueInterface {
	boolean addCourse(Course courseToBeAdded);
	boolean removeCourse(Course courseToBeRemoved);
	List<Course> getCourses();
	
	
}
