package com.flipkart.exception;

public class CourseDoesntExistException extends Exception{
  
    public CourseDoesntExistException() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public String getMessage() {
    	
        return "This course doesn't exist";
    }
}

