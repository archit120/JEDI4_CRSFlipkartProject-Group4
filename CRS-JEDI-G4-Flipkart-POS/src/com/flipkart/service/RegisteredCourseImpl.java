package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.CourseDao;
import com.flipkart.dao.RegisteredCourseDao;
import com.flipkart.dao.StudentDao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RegisteredCourseImpl implements RegisteredCourseInterface {

	private static List<RegisteredCourse> registeredCourses;
	public static int maximumEnrollment = 10;

	public RegisteredCourseImpl() {
		if(registeredCourses == null){
			registeredCourses = new ArrayList<>();
		}
	}

	@Override
	public boolean addRegisteredCourse(RegisteredCourse registeredCourse) {
		return RegisteredCourseDao.addRegisteredCourse(registeredCourse);
		//return registeredCourses.add(registeredCourse);
	}

	@Override
	public boolean dropRegisteredCourse(int sId , int cId) {
		return RegisteredCourseDao.deleteRegisteredCourse(sId, cId);
	}

	@Override
	public List<RegisteredCourse> findRegisteredCourses(SemesterRegistration semesterRegistration) {
		List<RegisteredCourse> ret = new ArrayList<>();
//		for(RegisteredCourse r:registeredCourses)
//			if(r.getSemesterRegistration() == semesterRegistration)
//				ret.add(r);
		return ret;
	}

//	@Override
//	public boolean checkAvailability(Course course) {
//		return viewEnrolledStudents(course).size() <= maximumEnrollment;
//	}

	@Override
	public RegisteredCourse findRegisteredCourse(SemesterRegistration semesterRegistration, String courseID) {
		RegisteredCourse ret = null;
//		for(RegisteredCourse r:registeredCourses)
//			if(r.getSemesterRegistration() == semesterRegistration && r.getCourse().getCourseCode().equals(courseID))
//				ret =  r;
		return ret;
	}

	@Override
	public boolean markGrade(String courseID, CourseCatalogue courseCatalogue, String rollNo, Grade grade) {
		RegisteredCourse ret = null;
//		for(RegisteredCourse r:registeredCourses)
//			if(r.getStudent().getRollNo().equals(rollNo) && r.getCourse().getCourseCode().equals(courseID) && r.getSemesterRegistration().getSemester() == courseCatalogue.getSem())
//				ret =  r;
//		ret.setGrade(grade);
		return true;
	}

	@Override
	public List<Student> viewEnrolledStudents(String courseCode) {
		List<Student> students = new ArrayList<Student>();
		
		int cId=CourseDao.getCourseIdfromCode(courseCode);
		System.out.println(cId);
		
		List<Integer>enrolledStudentsId=RegisteredCourseDao.getEnrolledStudents(cId);
		System.out.println(enrolledStudentsId);
		
		students=StudentDao.getStudentsfromId(enrolledStudentsId);
		
//		for(RegisteredCourse r : registeredCourses)
//			if(r.getCourse()==course)
//				students.add(r.getStudent());
		return students;
	}

	@Override
	public boolean checkAvailability(Course course) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean setGradeStudent(int sId,int grade,int cId) {
		
		return RegisteredCourseDao.setGradeStudent(sId, grade, cId);
	}


}
