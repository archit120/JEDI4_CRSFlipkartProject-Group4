package com.flipkart.exception;

public class CourseAlreadyRegisteredException extends Exception{
    private String msg;
	
	public CourseAlreadyRegisteredException(String msg) {
		this.msg=msg;
	}
	
    @Override
    public String getMessage() {
    	return msg;
//        return "You have already registered for this course!";
    }
}
