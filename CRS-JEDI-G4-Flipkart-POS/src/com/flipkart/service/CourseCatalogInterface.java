package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;

public interface CourseCatalogInterface {
	boolean addCourse(Course courseToBeAdded);
	//getCourses();
	boolean removeCourses(Course courseToBeRemoved);
	
	CourseCatalogue getCourses();
	
	
}
