/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Student;

/**
 * @author anike
 *
 */
public class ProfessorOperation implements ProfessorInterface{

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
	public ArrayList<Student> getEnrolledStudents(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
