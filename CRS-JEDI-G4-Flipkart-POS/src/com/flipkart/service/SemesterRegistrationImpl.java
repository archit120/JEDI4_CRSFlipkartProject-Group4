/** */
package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.SemesterRegistrationDao;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class SemesterRegistrationImpl.
 *
 * @author anike
 */
public class SemesterRegistrationImpl implements SemesterRegistrationInterface {

  private static Logger logger = Logger.getLogger(StudentImpl.class);

  /** Instantiates a new semester registration impl. */
  public SemesterRegistrationImpl() {
//    if(semesterRegistrations == null){
//
//        semesterRegistrations = new ArrayList<>();
//    }
  }

  /**
   * Adds the semester registration.
   *
   * @param semesterRegistration the semester registration
   * @return true, if successful
   */
  @Override
  public boolean addSemesterRegistration(SemesterRegistration semesterRegistration) {

    return SemesterRegistrationDao.addSemesterRegistration(semesterRegistration);
  }

  /**
   * View grades.
   *
   * @param semesterRegistration the semester registration
   * @return the list
   */
  @Override
  public List<Grade> viewGrades(SemesterRegistration semesterRegistration) {

    List<Grade> grades = new ArrayList<>();
    RegisteredCourseImpl registeredCourses = new RegisteredCourseImpl();

    for (RegisteredCourse temp : registeredCourses.findRegisteredCourses(semesterRegistration)) {

      Grade t2 = new Grade();
      t2.setGrade(temp.getGradeId());
      grades.add(t2);
    }

    return grades;
  }

  /**
   * View semester registrations.
   *
   * @param student the student
   * @return the list
   */
  @Override
  public List<SemesterRegistration> viewSemesterRegistrations(int student) {

    return SemesterRegistrationDao.getSemesterRegistrationsByStudentId(student);
  }

  /**
   * View grades and courses.
   *
   * @param semesterRegistration the semester registration
   * @return the list
   */
  @Override
  public List<RegisteredCourse> viewGradesAndCourses(SemesterRegistration semesterRegistration) {

    RegisteredCourseImpl registeredCourses = new RegisteredCourseImpl();

    return registeredCourses.findRegisteredCourses(semesterRegistration);
  }
}