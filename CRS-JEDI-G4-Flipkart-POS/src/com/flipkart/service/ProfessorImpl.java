/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;

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
		if(!registeredCourse.getCourse().getCourseID().equals(professorInstance.getTeachesCourse().getCourseID()))
			return false;
		registeredCourse.setGrade(grade);
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

	@Override
	public List<Student> getEnrolledStudents() {
		return new RegisteredCourseImpl().viewEnrolledStudents(professorInstance.getTeachesCourse());
	}

	@Override
	public boolean login(String userID, String password) {
		for(Professor prof : professors)
			if(userID.trim().equals(prof.getUsername()) && password.trim().equals(prof.getPassword())) {
				professorInstance = prof;
				return true;
			}
		return false;
	}

	@Override
	public void addProfessor(Professor professor) {
		professors.add(professor);
	}
}
