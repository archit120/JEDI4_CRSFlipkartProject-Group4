package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.CourseDao;
import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.StudentDao;
import com.flipkart.exception.CoursePreExistsException;
import com.flipkart.exception.ProfessorPreExistsException;
import com.flipkart.exception.StudentPreExistsException;

// TODO: Auto-generated Javadoc
/** The Class AdminImpl. */
public class AdminImpl implements AdminInterface {

  /** The admin instance. */
  private static Admin adminInstance;

  /** Instantiates a new admin impl. */
  public AdminImpl() {}

  /**
   * Adds the professor.
   *
   * @param professorToBeAdded the professor to be added
   * @return true, if successful
   */
  @Override
  	public boolean addProfessor(Professor professorToBeAdded) throws ProfessorPreExistsException {
  		
  		if (ProfessorDao.addProfessor(professorToBeAdded) == true) {
	    	
	    	return true;
	    } else {
	    	
	    	throw new ProfessorPreExistsException(professorToBeAdded.getEmpID());
	    }
  	}

  /**
   * Adds the student.
   *
   * @param student the student
   * @return true, if successful
   */
  @Override
  public boolean addStudent(Student student) throws StudentPreExistsException {
    
    if (StudentDao.addStudent(student) == true) {
    	
    	return true;
    } else {
    	
    	throw new StudentPreExistsException(student.getUsername());
    }
  }

  /**
   * Approve grade.
   *
   * @param rollNo the roll no
   * @return true, if successful
   */
  @Override
  public boolean approveGrade(String rollNo) {
    System.out.println("Approving grade todo");
    return false;
  }

  /**
   * Verify course reg.
   *
   * @param rollNo the roll no
   * @return true, if successful
   */
  @Override
  public boolean verifyCourseReg(String rollNo) {
    System.out.println("Approving course todo");
    return false;
  }

  /**
   * Login.
   *
   * @param userID the user ID
   * @param password the password
   * @return true, if successful
   */
  @Override
  public boolean login(String userID, String password) {

    Admin loginRes = AdminDao.login(userID, password);
    if (loginRes == null) return false;
    adminInstance = loginRes;
    return true;
  }
}
