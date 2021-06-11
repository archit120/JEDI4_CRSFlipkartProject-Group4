package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogInterface {
	boolean addCourse(Course courseToBeAdded);
	//getCourses();
	boolean removeCourses(Course courseToBeRemoved);
	List<Course> getCourses();
	
	
}
