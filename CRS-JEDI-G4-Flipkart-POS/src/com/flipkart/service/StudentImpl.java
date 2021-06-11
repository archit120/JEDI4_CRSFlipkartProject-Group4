package com.flipkart.service;

import com.flipkart.bean.*;

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
	public ReportCard viewReportCard(String rollno) {
		// TODO Auto-generated method stub
		return null;
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

		//if(!rcInstance.checkAvailability(CourseToRegister))
			return false;
		

//		RegisteredCourse registeredCourse = new RegisteredCourse();
//		registeredCourse.setCourse(CourseToRegister);
//		registeredCourse.setStudent(studentInstance);
//		registeredCourse.setSemesterRegistration(semesterRegistration);

		//return rcInstance.addRegisteredCourse(registeredCourse);
		
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		
		// will veridy credentails from database over here
		
//		for(Student stud : students)
//			if(username.trim().equals(stud.getUsername()) && password.trim().equals(stud.getPassword())) {
//				studentInstance = stud;
//				return true;
//			}
		//TODO
		return true;
	}

	@Override
	public boolean addStudent(Student student) {
		return students.add(student);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		studentInstance = null;
	}
	
	
	
	

	

}
