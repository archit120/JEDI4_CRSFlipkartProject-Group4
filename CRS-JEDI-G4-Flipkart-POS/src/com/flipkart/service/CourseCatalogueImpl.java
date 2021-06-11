package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalogueImpl implements CourseCatalogueInterface {

	private static List<CourseCatalogue> catalogues;

	@Override
	public Course findCourse(CourseCatalogue catalogue, String courseID) {
		CourseImpl courseImpl = new CourseImpl();
		return courseImpl.findCourse(catalogue, courseID);
	}

	public CourseCatalogueImpl() {
		if(catalogues == null)
			this.catalogues = new ArrayList<>();
	}

	@Override
	public boolean addCourseCatalogue(CourseCatalogue courseToBeAdded) {
		return catalogues.add(courseToBeAdded);
	}

	@Override
	public boolean removeCourseCatalogue(CourseCatalogue courseCatalogue) {
		return catalogues.remove(courseCatalogue);
	}

	@Override
	public List<CourseCatalogue> getCourseCatalogues() {
		return catalogues;
	}

	@Override
	public List<Course> getCourses(CourseCatalogue catalogue) {
		CourseImpl courseImpl = new CourseImpl();
		return courseImpl.findCourses(catalogue);
	}
	
}
