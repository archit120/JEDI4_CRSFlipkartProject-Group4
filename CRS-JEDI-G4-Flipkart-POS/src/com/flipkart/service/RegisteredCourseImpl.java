package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RegisteredCourseImpl implements RegisteredCourseInterface {

	private static Hashtable<Course, ArrayList<Student>> courseStudentHashtable;
	private static Hashtable<Student, ArrayList<RegisteredCourse>> studentCourseHashtable;

	public RegisteredCourseImpl() {
		if(courseStudentHashtable == null){
			courseStudentHashtable = new Hashtable<>();
			studentCourseHashtable = new Hashtable<>();
		}
	}

	@Override
	public List<Student> viewEnrolledStudents(Course course) {
		return courseStudentHashtable.get(course);
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
