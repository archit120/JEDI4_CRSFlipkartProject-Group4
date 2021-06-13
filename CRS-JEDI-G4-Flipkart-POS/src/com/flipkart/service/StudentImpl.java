package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.CourseDao;
import com.flipkart.dao.RegisteredCourseDao;
import com.flipkart.dao.StudentDao;

import java.util.ArrayList;

public class StudentImpl implements StudentInterface {

	private static ArrayList<Student> students;

	public Student getStudentInstance() {
		return studentInstance;
	}

	private static Student studentInstance;

	public StudentImpl() {
		if(students == null)
			students = new ArrayList<>();
	}

	@Override
	public ReportCard viewReportCard(int studentId) {
		
		ReportCard report=new ReportCard();
		report=RegisteredCourseDao.getReportCard(studentId, 1);
		report=CourseDao.getCourseCodefromId(report);
		return report;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean payFee(String rollNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkAvailability(Course courseToCheck) {
		// TODO Auto-generated method stub

		RegisteredCourseImpl rcInstance = new RegisteredCourseImpl();
		return rcInstance.checkAvailability(courseToCheck);
	}

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

	@Override
	public boolean login(String username, String password) {
		Student loginRes = StudentDao.login(username, password);
		if(loginRes == null)
			return false;
		studentInstance = loginRes;
		return true;

	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		studentInstance = null;
	}
	
	
	
	

	

}
