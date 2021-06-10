/**
 * 
 */
package com.flipkart.service;

/**
 * @author anike
 *
 */
public interface SemesterRegistrationInterface {
	
	public boolean addGrade(int studentId, String grade);
	
	public boolean dropCourse(int studentId, int courseId);
	
	public int viewGrade(int courseId, String grade);
		
}
