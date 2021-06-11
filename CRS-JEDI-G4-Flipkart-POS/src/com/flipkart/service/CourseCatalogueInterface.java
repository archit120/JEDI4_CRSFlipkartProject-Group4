package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;

import java.util.List;

public interface CourseCatalogueInterface {
	boolean addCourseCatalogue(CourseCatalogue courseToBeAdded);
	boolean removeCourseCatalogue(CourseCatalogue courseCatalogue);
	Course findCourse(CourseCatalogue catalogue, String courseID);
	List<Course> getCourses(CourseCatalogue catalogue);
	
	
}
