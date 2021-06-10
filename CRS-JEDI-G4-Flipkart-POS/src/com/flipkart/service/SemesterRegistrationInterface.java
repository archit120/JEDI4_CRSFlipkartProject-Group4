/**
 * 
 */
package com.flipkart.service;

/**
 * @author anike
 *
 */
public interface SemesterRegistrationInterface {
	
	public boolean addGrade(int studentId, string grade);
	
	public boolean dropCourse(int studentId, int courseId);
	
	public int viewGrade(int courseId, string grade);
		
}
