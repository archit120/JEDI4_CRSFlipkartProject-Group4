package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.RegisteredCourseDao;
import com.flipkart.dao.StudentDao;
import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/** The Class StudentImpl. */
public class StudentImpl implements StudentInterface {

  /** The students. */
  private static ArrayList<Student> students;

  /**
   * Gets the student instance.
   *
   * @return the student instance
   */
  public Student getStudentInstance() {
    return studentInstance;
  }

  /** The student instance. */
  private static Student studentInstance;

  /** Instantiates a new student impl. */
  public StudentImpl() {
    if (students == null) students = new ArrayList<>();
  }

  /**
   * View report card.
   *
   * @param semesterRegistration the semester registration
   * @return the report card
   */
  @Override
  public ReportCard viewReportCard(SemesterRegistration semesterRegistration) {

    ReportCard report = new ReportCard();
    report = RegisteredCourseDao.getReportCard(semesterRegistration.getId());
    return report;
  }

  /**
   * Pay fee.
   *
   * @param rollNo the roll no
   * @return true, if successful
   */
  @Override
  public boolean payFee(String rollNo) {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   * Check availability.
   *
   * @param courseToCheck the course to check
   * @return true, if successful
   */
  @Override
  public boolean checkAvailability(Course courseToCheck) {
    // TODO Auto-generated method stub

    RegisteredCourseImpl rcInstance = new RegisteredCourseImpl();
    return rcInstance.checkAvailability(courseToCheck);
  }

  /**
   * Register for course.
   *
   * @param semesterRegistration the semester registration
   * @param CourseToRegister the course to register
   * @return true, if successful
 * @throws CourseAlreadyFullException 
 * @throws CourseAlreadyRegisteredException 
   */
  @Override
  public boolean registerForCourse(
      SemesterRegistration semesterRegistration, Course CourseToRegister) throws CourseAlreadyFullException, CourseAlreadyRegisteredException {
    // TODO Auto-generated method stub

    RegisteredCourseImpl rcInstance = new RegisteredCourseImpl();

    if (!rcInstance.checkAvailability(CourseToRegister)) { 
    	throw new CourseAlreadyFullException(CourseToRegister.getCourseCode());
    	}
    
    RegisteredCourse registeredCourse = new RegisteredCourse();
    registeredCourse.setCourseId(CourseToRegister.getId());
    registeredCourse.setStudentId(studentInstance.getUserID());
    registeredCourse.setSemesterRegistrationId(semesterRegistration.getId());
    registeredCourse.setGradeId(-1);

    if(!rcInstance.addRegisteredCourse(registeredCourse)) {
    	throw new CourseAlreadyRegisteredException("Hello1");
    }else {
    	return true;
    }
  }

  /**
   * Login.
   *
   * @param username the username
   * @param password the password
   * @return true, if successful
   */
  @Override
  public boolean login(String username, String password) {
    Student loginRes = StudentDao.login(username, password);
    if (loginRes == null) return false;
    if(loginRes.getIsApproved() == false) return false;
    studentInstance = loginRes;
    return true;
  }

  /** Logout. */
  @Override
  public void logout() {
    // TODO Auto-generated method stub
    studentInstance = null;
  }

@Override
public List<Student> getStudentsWaitingApprocal() {
	// TODO Auto-generated method stub
	return StudentDao.getStudentsPendingApproval();
}

@Override
public boolean approveStudent() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean approveStudent(String email) {
	// TODO Auto-generated method stub
	return StudentDao.approveStudent(email);
}

public boolean addStudent(String email,String password,String name,String username,String roll,String dept) {
	Student s = new Student();
	s.setEmail(email);
	s.setName(name);
	s.setPassword(password);
	s.setUsername(username);
	s.setRollNo(roll);
	s.setDepartment(dept);
	s.setApproved(false);
	
	return StudentDao.addStudent(s);
}

}
