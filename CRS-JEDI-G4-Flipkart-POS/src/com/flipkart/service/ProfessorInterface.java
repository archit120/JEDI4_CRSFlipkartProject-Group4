/**
 * 
 */
package com.flipkart.service;



import java.util.List;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

/**
 * @author anike
 *
 */
public interface ProfessorInterface {
	
	public boolean addGrade(String courseId,String rollno,Grade gradeAlloted);
	
	public boolean chooseCourse(String professorId,String courseId);
	
	public List<Student> getEnrolledStudents(String courseId);

	public boolean login(String userID, String password);
	public void logout();
}
