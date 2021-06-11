package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;

import java.util.ArrayList;

public class StudentImpl implements StudentInterface {

	private static ArrayList<Student> students;
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
		
		int currentEnrolled = courseToCheck.getCurrentEnrollment();
		
		if(currentEnrolled >= 10) return false;
		
		return true;
	}

	@Override
	public boolean registerForCourse(Course CourseToRegister) {
		// TODO Auto-generated method stub
		
		boolean temp = checkAvailability(CourseToRegister);
		
		if(temp == false) return false;
		
		RegisteredCourseImpl rcInstance = new RegisteredCourseImpl();
		
		rcInstance.addCourse(CourseToRegister);
		
		
		return true;
		
		
	}

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		
		// will veridy credentails from database over here
		
		Student st = new Student();
		st.setEmail(email);
		st.setPassword(password);
		
		studentInstance = st;
		
		return true;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		studentInstance = null;
	}
	
	
	
	

	

}
