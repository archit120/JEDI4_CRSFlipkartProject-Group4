/** */
package com.flipkart.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class CoursePreExistsException.
 *
 * @author anike
 */
public class ProfessorPreExistsException extends Exception {

  /** The Professor empId. */
  private String empId;

  /**
   * Instantiates a new course pre exists exception.
   *
   * @param courseCode the course code
   */
  public ProfessorPreExistsException(String empId) {
	  
    this.empId = empId;
  }

  /**
   * Gets the message.
   *
   * @return the message
   */
  @Override
  public String getMessage() {
    return "The professor with empId = " + this.empId + " already exists!";
  }
}
