/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.ArrayList;

/**
 * @author anike
 *
 */
public class ProfessorImpl implements ProfessorInterface{

	private static ArrayList<Professor> professors;
	private static Professor professorInstance;

	public ProfessorImpl() {
		if(professors == null)
			professors = new ArrayList<>();
	}

	@Override
	public boolean addGrade(int courseId, int studentId, String gradeAlloted) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean chooseCourse(int professorId, int courseId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Student[] getEnrolledStudents(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String userID, String password) {
		for(Professor prof : professors)
			if(userID.trim().equals(prof.getUserID()) && password.trim().equals(prof.getPassword())) {
				professorInstance = prof;
				return true;
			}
		return false;
	}
}
