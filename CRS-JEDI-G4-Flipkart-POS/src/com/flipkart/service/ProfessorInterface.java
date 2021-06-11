/**
 * 
 */
package com.flipkart.service;



import com.flipkart.bean.*;

import java.util.List;

/**
 * @author anike
 *
 */
public interface ProfessorInterface {
	
	public boolean addGrade(RegisteredCourse registeredCourse, Grade grade);
	
	public boolean chooseCourse(Course course);
	
	public List<Student> getEnrolledStudents();

	public boolean login(String username, String password);

	public void logout();

	public void addProfessor(Professor professor);
}
