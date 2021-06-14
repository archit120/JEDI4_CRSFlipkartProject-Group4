/** */
package com.flipkart.exception;

// TODO: Auto-generated Javadoc

public class ProfessorPreExistsException extends Exception {


  private String empId;

 
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
