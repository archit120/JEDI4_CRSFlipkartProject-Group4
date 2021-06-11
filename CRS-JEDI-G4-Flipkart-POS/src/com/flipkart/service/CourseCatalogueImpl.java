package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;

import java.util.List;

public class CourseCatalogueImpl implements CourseCatalogueInterface {

	private static CourseCatalogue catalogue;

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
		// TODO Auto-generated method stub
		return catalogue.getCourses();
	}
	
	
	
}
