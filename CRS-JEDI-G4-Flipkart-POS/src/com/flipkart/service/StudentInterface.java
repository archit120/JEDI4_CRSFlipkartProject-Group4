package com.flipkart.service;

public interface StudentInterface {
	ReportCard viewReportCard(String rollno);
	boolean payFee(int rollno);
	boolean checkAvailability(Course courseToCheck);
	boolean registerForCourse(Course CourseToRegister);
}
