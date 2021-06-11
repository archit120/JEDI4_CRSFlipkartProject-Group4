package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
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
		return false;
	}

	@Override
	public boolean registerForCourse(Course CourseToRegister) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
