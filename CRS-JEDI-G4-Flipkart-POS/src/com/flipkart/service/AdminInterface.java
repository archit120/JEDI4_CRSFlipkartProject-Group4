package com.flipkart.service;

public interface AdminInterface {
	public boolean addCourse(Course courseToBeAdded );

	public boolean removeCourse(Course courseToBeRemoved );

	public boolean addProfessor(Professor professorToBeAdded);

	public boolean appoveStudent(int StudentID);
	
	public boolean approveGrade(int StudentID);
	
	public boolean verifyCourseReg(int studentID);

}
