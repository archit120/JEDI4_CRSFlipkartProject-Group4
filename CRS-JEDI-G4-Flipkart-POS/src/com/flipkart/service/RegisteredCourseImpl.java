package com.flipkart.service;

import com.flipkart.bean.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RegisteredCourseImpl implements RegisteredCourseInterface {

	private static List<RegisteredCourse> registeredCourses;

	public RegisteredCourseImpl() {
		if(registeredCourses == null){
			registeredCourses = new ArrayList<>();
		}
	}

	@Override
	public List<Student> viewEnrolledStudents(Course course) {
		ArrayList<Student> students = new ArrayList<>();
		for(RegisteredCourse r : registeredCourses)
			if(r.getCourse()==course)
				students.add(r.getStudent());
		return students;
	}

//	@Override
//	public boolean dropCourse(Course courseToBeDropped) {
//		// TODO Auto-generated method stub
//		SemesterRegistrationImpl Inst= new SemesterRegistrationImpl();
//		Inst.dropCourse(,courseToBeDropped);
//		return true;
//	}

	@Override
	public boolean addGrade(RegisteredCourse registeredCourse, Grade gradeVal) {
		registeredCourse.setGrade(gradeVal);
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean checkAvailability(Course course) {
		
		int sz=viewEnrolledStudents(course).size();
		
		if(sz<10 && sz>=3) 
			return true;
		else
			return false;
		
		
		
	}

//	@Override
//	public Grade viewGrade(String rollNo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}
