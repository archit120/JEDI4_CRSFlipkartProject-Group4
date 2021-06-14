package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.dao.CourseCatalogueDao;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CourseCatalogueImpl.
 */
public class CourseCatalogueImpl implements CourseCatalogueInterface {

//	private static List<CourseCatalogue> catalogues;

	/**
 * Find course.
 *
 * @param catalogue the catalogue
 * @param courseID the course ID
 * @return the course
 */
@Override
	public Course findCourse(CourseCatalogue catalogue, String courseID) {
		CourseImpl courseImpl = new CourseImpl();
		return courseImpl.findCourse(catalogue, courseID);
	}

	/**
	 * Instantiates a new course catalogue impl.
	 */
	public CourseCatalogueImpl() {
//		if(catalogues == null)
//			this.catalogues = new ArrayList<>();
	}

	/**
	 * Adds the course catalogue.
	 *
	 * @param courseToBeAdded the course to be added
	 * @return true, if successful
	 */
	@Override
	public boolean addCourseCatalogue(CourseCatalogue courseToBeAdded) {
		return CourseCatalogueDao.addCourseCatalogue(courseToBeAdded);
	}

	/**
	 * Removes the course catalogue.
	 *
	 * @param courseCatalogue the course catalogue
	 * @return true, if successful
	 */
	@Override
	public boolean removeCourseCatalogue(CourseCatalogue courseCatalogue) {
//		return catalogues.remove(courseCatalogue);
		return false;
	}

	/**
	 * Gets the course catalogues.
	 *
	 * @return the course catalogues
	 */
	@Override
	public List<CourseCatalogue> getCourseCatalogues() {
		return CourseCatalogueDao.getCourseCatalogues();
	}

	/**
	 * Gets the courses.
	 *
	 * @param catalogue the catalogue
	 * @return the courses
	 */
	@Override
	public List<Course> getCourses(CourseCatalogue catalogue) {
		CourseImpl courseImpl = new CourseImpl();
		return courseImpl.findCourses(catalogue);
	}
	
}
