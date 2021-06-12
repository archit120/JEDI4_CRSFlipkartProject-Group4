package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.bean.Student;

public interface StudentInterface {

	public void logout();

	ReportCard viewReportCard(int studentId);

	boolean payFee(String rollNo);

	boolean checkAvailability(Course courseToCheck);

	boolean registerForCourse(SemesterRegistration semesterRegistration, Course CourseToRegister);

	boolean login(String username, String password);

	public Student getStudentInstance();
}
