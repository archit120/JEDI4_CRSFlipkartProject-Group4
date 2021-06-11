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

	@Override
	public boolean dropCourse(Course courseToBeDropped) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGrade(String rollNo, Grade gradeToBeAdded) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Grade viewGrade(String rollNo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
