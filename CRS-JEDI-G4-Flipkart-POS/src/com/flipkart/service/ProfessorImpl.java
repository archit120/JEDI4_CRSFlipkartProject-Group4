/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.CourseDao;
import com.flipkart.dao.ProfessorDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anike
 *
 */
public class ProfessorImpl implements ProfessorInterface{

//	private static ArrayList<Professor> professors;
	private static Professor professorInstance;

	public static Professor getProfessorInstance() {
		return professorInstance;
	}

	public ProfessorImpl() {
//		if(professors == null)
//			professors = new ArrayList<>();
	}

	@Override
	public boolean addGrade(RegisteredCourse registeredCourse, Grade grade) {
		if(CourseDao.getCourse(registeredCourse.getCourseId()).getProfessorId()!=professorInstance.getUserID())
			return false;
		registeredCourse.setGradeId(grade.getGrade());
		new RegisteredCourseImpl().markGrade(registeredCourse, grade);
		return true;
	}

	@Override
	public void logout() {
		professorInstance = null;
	}

	@Override
	public boolean chooseCourse(Course course) {
		return new CourseImpl().indicateProfessor(course, professorInstance);
	}

	@Override
	public List<Student> getEnrolledStudents(CourseCatalogue courseCatalogue) {
		return new RegisteredCourseImpl().viewEnrolledStudents(courseCatalogue, professorInstance);
	}

	@Override
	public boolean login(String userID, String password) {

		Professor loginRes = ProfessorDao.login(userID, password);
		if(loginRes == null)
			return false;
		professorInstance = loginRes;
		return true;
  }

}
