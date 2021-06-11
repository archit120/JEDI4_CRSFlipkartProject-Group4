/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anike
 *
 */
public class ProfessorImpl implements ProfessorInterface{

	private static ArrayList<Professor> professors;
	private static Professor professorInstance;

	public ProfessorImpl() {
		if(professors == null)
			professors = new ArrayList<>();
	}

	@Override
	public boolean addGrade(String courseid, String rollno, Grade gradeAllotted) {
		RegisteredCourseImpl regCourse= new RegisteredCourseImpl();
		regCourse.addGrade(rollno, gradeAllotted);
		return true;
	}

	@Override
	public boolean chooseCourse(String professorId, String courseId) {
		// TODO Auto-generated method stub
		CourseImpl couseObj=new CourseImpl();
		Course courseToTeach=new Course();
		courseToTeach.setCourseID(courseId);
		couseObj.indicateProfessor(courseToTeach, professorInstance);
		
		return true;
	}

	@Override
	public List<Student> getEnrolledStudents(String courseId) {
		// TODO Auto-generated method stub
		RegisteredCourseImpl regCourse=new RegisteredCourseImpl();
		CourseCatalogueImpl toFindCourse= new CourseCatalogueImpl();
		Course course=toFindCourse.findCourse(courseId);
		List<Student> studentList=regCourse.viewEnrolledStudents(course);
		return studentList;
	}

	@Override
	public boolean login(String userID, String password) {
		for(Professor prof : professors)
			if(userID.trim().equals(prof.getUserID()) && password.trim().equals(prof.getPassword())) {
				professorInstance = prof;
				return true;
			}
		return true;
		//return false;
	}
	public void logout()
	{
		professorInstance=null;
	}
}
