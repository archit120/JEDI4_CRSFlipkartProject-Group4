/**
 * 
 */
package com.flipkart.service;



import com.flipkart.bean.Student;

/**
 * @author anike
 *
 */
public interface ProfessorInterface {
	
	public boolean addGrade(int courseId,int studentId,String gradeAlloted);
	
	public boolean chooseCourse(int professorId, int courseId);
	
	public Student[] getEnrolledStudents(int courseId);

	public boolean login(String userID, String password);
}
