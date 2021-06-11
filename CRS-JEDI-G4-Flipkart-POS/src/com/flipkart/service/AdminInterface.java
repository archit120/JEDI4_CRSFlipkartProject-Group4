package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface AdminInterface {

	public boolean addProfessor(Professor professorToBeAdded);

	public boolean addStudent(Student student);
	
	public boolean approveGrade(String rollNo);
	
	public boolean verifyCourseReg(String rollNo);

	public boolean login(String userID, String password);

}
