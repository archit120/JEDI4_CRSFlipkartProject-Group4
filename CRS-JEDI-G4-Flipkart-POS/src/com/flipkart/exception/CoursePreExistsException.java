/**
 * 
 */
package com.flipkart.exception;

/**
 * @author anike
 *
 */
public class CoursePreExistsException extends Exception{
		
		private String courseCode;
	
	    public CoursePreExistsException(String courseCode) {
	    	this.courseCode=courseCode;
	    }

	    @Override
	    public String getMessage() {
	        return "The course with code = " + this.courseCode + " already exists!";
	    }
	
}
