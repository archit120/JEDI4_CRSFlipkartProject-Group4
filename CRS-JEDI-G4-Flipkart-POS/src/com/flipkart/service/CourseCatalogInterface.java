package com.flipkart.service;

public interface CourseCatalogInterface {
	boolean addCourse(Course courseToBeAdded);
	//getCourses();
	boolean removeCourses(Course courseToBeRemoved);
	
	CourseCatalog getCourses();
	
	
}
