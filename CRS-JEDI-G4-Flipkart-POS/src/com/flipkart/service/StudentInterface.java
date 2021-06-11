package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;

public interface StudentInterface {
	
	public void logout();
	ReportCard viewReportCard(String rollno);
	boolean payFee(String rollNo);
	boolean checkAvailability(Course courseToCheck);
	boolean registerForCourse(Course CourseToRegister);
	boolean login(String id,String password);
}
