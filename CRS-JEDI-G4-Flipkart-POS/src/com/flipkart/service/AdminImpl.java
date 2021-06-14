package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.StudentDao;

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
  public boolean addProfessor(Professor professorToBeAdded) {
    return ProfessorDao.addProfessor(professorToBeAdded);
  }

  /**
   * Adds the student.
   *
   * @param student the student
   * @return true, if successful
   */
  @Override
  public boolean addStudent(Student student) {
    return StudentDao.addStudent(student);
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
