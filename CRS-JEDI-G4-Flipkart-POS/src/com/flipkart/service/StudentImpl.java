package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.RegisteredCourseDao;
import com.flipkart.dao.StudentDao;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentImpl.
 */
public class StudentImpl implements StudentInterface {

	/** The students. */
	private static ArrayList<Student> students;

	/**
	 * Gets the student instance.
	 *
	 * @return the student instance
	 */
	public Student getStudentInstance() {
		return studentInstance;
	}

	/** The student instance. */
	private static Student studentInstance;

	/**
	 * Instantiates a new student impl.
	 */
	public StudentImpl() {
		if(students == null)
			students = new ArrayList<>();
	}

	/**
	 * View report card.
	 *
	 * @param semesterRegistration the semester registration
	 * @return the report card
	 */
	@Override
	public ReportCard viewReportCard(SemesterRegistration semesterRegistration) {
		
		ReportCard report=new ReportCard();
		report=RegisteredCourseDao.getReportCard(semesterRegistration.getId());
		return report;

	}

	/**
	 * Pay fee.
	 *
	 * @param rollNo the roll no
	 * @return true, if successful
	 */
	@Override
	public boolean payFee(String rollNo) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Check availability.
	 *
	 * @param courseToCheck the course to check
	 * @return true, if successful
	 */
	@Override
	public boolean checkAvailability(Course courseToCheck) {
		// TODO Auto-generated method stub

		RegisteredCourseImpl rcInstance = new RegisteredCourseImpl();
		return rcInstance.checkAvailability(courseToCheck);
	}

	/**
	 * Register for course.
	 *
	 * @param semesterRegistration the semester registration
	 * @param CourseToRegister the course to register
	 * @return true, if successful
	 */
	@Override
	public boolean registerForCourse(SemesterRegistration semesterRegistration, Course CourseToRegister) {
		// TODO Auto-generated method stub

		RegisteredCourseImpl rcInstance = new RegisteredCourseImpl();

		if (!rcInstance.checkAvailability(CourseToRegister))
			return false;


		RegisteredCourse registeredCourse = new RegisteredCourse();
		registeredCourse.setCourseId(CourseToRegister.getId());
		registeredCourse.setStudentId(studentInstance.getUserID());
		registeredCourse.setSemesterRegistrationId(semesterRegistration.getId());
		registeredCourse.setGradeId(-1);

		return rcInstance.addRegisteredCourse(registeredCourse);

	}

	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 */
	@Override
	public boolean login(String username, String password) {
		Student loginRes = StudentDao.login(username, password);
		if(loginRes == null)
			return false;
		studentInstance = loginRes;
		return true;

	}

	/**
	 * Logout.
	 */
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		studentInstance = null;
	}
	
	
	
	

	

}
