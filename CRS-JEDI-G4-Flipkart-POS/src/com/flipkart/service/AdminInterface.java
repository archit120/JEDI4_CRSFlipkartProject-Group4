package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

public interface AdminInterface {
	public boolean addCourse(Course courseToBeAdded );

	public boolean removeCourse(Course courseToBeRemoved );

	public boolean addProfessor(Professor professorToBeAdded);

	public boolean approveStudent(String rollNo);
	
	public boolean approveGrade(String rollNo);
	
	public boolean verifyCourseReg(String rollNo);

	public boolean login(String userID, String password);

}
