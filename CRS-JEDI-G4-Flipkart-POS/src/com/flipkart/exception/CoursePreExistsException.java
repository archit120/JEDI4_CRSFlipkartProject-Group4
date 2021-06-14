/**
 * 
 */
package com.flipkart.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class CoursePreExistsException.
 *
 * @author anike
 */
public class CoursePreExistsException extends Exception{
		
		/** The course code. */
		private String courseCode;
	
	    /**
    	 * Instantiates a new course pre exists exception.
    	 *
    	 * @param courseCode the course code
    	 */
    	public CoursePreExistsException(String courseCode) {
	    	this.courseCode=courseCode;
	    }

	    /**
    	 * Gets the message.
    	 *
    	 * @return the message
    	 */
    	@Override
	    public String getMessage() {
	        return "The course with code = " + this.courseCode + " already exists!";
	    }
	
}
