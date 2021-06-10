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
public interface ProfessorInterface {
	
	public boolean addGrade(int courseId,int studentId,String gradeAlloted);
	
	public boolean chooseCourse(int professorId, int courseId);
	
	public ArrayList<Student> getEnrolledStudents(int courseId);
	
}
