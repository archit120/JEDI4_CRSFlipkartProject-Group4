package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

import java.util.ArrayList;
import java.util.List;

public class AdminImpl implements AdminInterface {

	private static List<Admin> admins;
	private static Admin adminInstance;

	public AdminImpl() {
		if(admins == null)
			admins = new ArrayList<>();
	}

	@Override
	public boolean addCourse(Course courseToBeAdded) {
		return new CourseCatalogueImpl().addCourse(courseToBeAdded);
	}

	@Override
	public boolean removeCourse(Course courseToBeRemoved) {
		return new CourseCatalogueImpl().removeCourse(courseToBeRemoved);
	}

	@Override
	public boolean addProfessor(Professor professorToBeAdded) {
		new ProfessorImpl().addProfessor(professorToBeAdded);
		System.out.println("\nProfessor added\n");
		return true;
	}

	@Override
	public boolean approveStudent(String rollNo ) {
		System.out.println("Approving student todo");

		return false;
	}

	@Override
	public boolean approveGrade(String rollNo) {
		System.out.println("Approving grade todo");
		return false;
	}

	
	@Override
	public boolean verifyCourseReg(String rollNo) {
		System.out.println("Approving course todo");
		return false;
	}

	@Override
	public boolean login(String userID, String password) {
		if(userID.trim().equals("test") && password.trim().equals("test")) {
			AdminImpl.adminInstance = new Admin();
			return true;
		}
		return false;
	}
}
