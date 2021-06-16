/** */
package com.flipkart.exception;

// TODO: Auto-generated Javadoc

public class StudentPreExistsException extends Exception {


  private String username;

 
  public StudentPreExistsException(String username) {
	  
    this.username = username;
  }

  /**
   * Gets the message.
   *
   * @return the message
   */
  @Override
  public String getMessage() {
    return "The student with username= " + this.username + " already exists!";
  }
}
