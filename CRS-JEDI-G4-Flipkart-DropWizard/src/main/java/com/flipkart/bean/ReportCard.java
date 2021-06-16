package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/** The Class ReportCard. */
public class ReportCard {

  /** The sgpa. */
  private double sgpa;

  /** The course codes. */
  private List<String> courseCodes = new ArrayList<String>();

  /** The grades. */
  private List<Integer> grades = new ArrayList<Integer>();

  /** The course I ds. */
  private List<Integer> courseIDs = new ArrayList<Integer>();

  /**
   * Gets the sgpa.
   *
   * @return the sgpa
   */
  // private boolean approved;
  public double getSgpa() {
    return sgpa;
  }

  /**
   * Sets the sgpa.
   *
   * @param sgpa the new sgpa
   */
  public void setSgpa(double sgpa) {
    this.sgpa = sgpa;
  }

  /**
   * Gets the course codes.
   *
   * @return the course codes
   */
  public List<String> getCourseCodes() {
    return courseCodes;
  }

  /**
   * Sets the course codes.
   *
   * @param courseCodes the new course codes
   */
  public void setCourseCodes(List<String> courseCodes) {
    this.courseCodes = courseCodes;
  }

  /**
   * Gets the grades.
   *
   * @return the grades
   */
  public List<Integer> getGrades() {
    return grades;
  }

  /**
   * Sets the grades.
   *
   * @param grades the new grades
   */
  public void setGrades(List<Integer> grades) {
    this.grades = grades;
  }

  /**
   * Gets the course I ds.
   *
   * @return the course I ds
   */
  public List<Integer> getCourseIDs() {
    return courseIDs;
  }

  /**
   * Sets the course I ds.
   *
   * @param courseIDs the new course I ds
   */
  public void setCourseIDs(List<Integer> courseIDs) {
    this.courseIDs = courseIDs;
  }
}
