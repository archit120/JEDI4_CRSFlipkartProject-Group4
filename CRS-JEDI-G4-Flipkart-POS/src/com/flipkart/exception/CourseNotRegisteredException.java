package com.flipkart.exception;

public class CourseNotRegisteredException extends Exception{
  
    public CourseNotRegisteredException() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public String getMessage() {
    	
        return "This course is not present in your registered courses list!";
    }
}
