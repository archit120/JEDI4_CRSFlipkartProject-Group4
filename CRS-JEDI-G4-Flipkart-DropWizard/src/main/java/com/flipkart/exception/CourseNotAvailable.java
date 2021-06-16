package com.flipkart.exception;

public class CourseNotAvailable extends Exception {
	
	 /** The course code. */
	  private String courseCode;

	  /**
	   * Instantiates a new course pre exists exception.
	   *
	   * @param courseCode the course code
	   */
	  public CourseNotAvailable(String courseCode) {
	    this.courseCode = courseCode;
	  }

	  /**
	   * Gets the message.
	   *
	   * @return the message
	   */
	  public String getMessage() {
	    return "The course with code = " + this.courseCode + " is not available to teach!";
	  }

}
