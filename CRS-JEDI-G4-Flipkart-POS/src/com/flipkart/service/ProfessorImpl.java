/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.ProfessorDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anike
 *
 */
public class ProfessorImpl implements ProfessorInterface{

	private static ArrayList<Professor> professors;
	private static Professor professorInstance;

	public static Professor getProfessorInstance() {
		return professorInstance;
	}

	public ProfessorImpl() {
		if(professors == null)
			professors = new ArrayList<>();
	}

	@Override
	public boolean addGrade(RegisteredCourse registeredCourse, Grade grade) {
//		if(registeredCourse.getCourse().getcId()!=(professorInstance.getTeachesCourse().getcId()))
//			return false;
//		registeredCourse.setGrade(grade);
		return true;
	}

	@Override
	public void logout() {
		professorInstance = null;
	}

	@Override
	public boolean chooseCourse(Course course) {
		return new CourseImpl().indicateProfessor(course, professorInstance);
	}

//	@Override
//	public List<Student> getEnrolledStudents() {
//		return new RegisteredCourseImpl().viewEnrolledStudents(professorInstance.getTeachesCourse());
//	}

	@Override
	public boolean login(String userID, String password) {
		//CHECK******************

		Professor loginRes = ProfessorDao.login(userID, password);
		
		if(loginRes == null)
			return false;
		professorInstance = loginRes;
		return true;

	}


	@Override
	public void addProfessor(Professor professor) {
		professors.add(professor);
	}

	@Override
	public List<Student> getEnrolledStudents() {
		// TODO Auto-generated method stub
		return null;
	}
}
