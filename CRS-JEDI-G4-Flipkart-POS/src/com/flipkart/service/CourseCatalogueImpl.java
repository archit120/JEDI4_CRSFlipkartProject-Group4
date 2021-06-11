package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;

import java.util.List;

public class CourseCatalogueImpl implements CourseCatalogueInterface {

	private static CourseCatalogue catalogue;

	@Override
	public Course findCourse(String courseID) {
		for(Course c : catalogue.getCourses())
			if(c.getCourseID().equals(courseID))
				return c;
		return null;
	}

	public CourseCatalogueImpl() {
		if(catalogue == null)
			this.catalogue = new CourseCatalogue();
	}

	@Override
	public boolean addCourse(Course courseToBeAdded) {
		catalogue.getCourses().add(courseToBeAdded);
		return true;
	}

	@Override
	public boolean removeCourse(Course courseToBeRemoved) {
		if(!catalogue.getCourses().contains(courseToBeRemoved))
			return false;
		catalogue.getCourses().remove(courseToBeRemoved);
		return false;
	}

	@Override
	public List<Course> getCourses() {
		return catalogue.getCourses();
	}
	
	
	
}
