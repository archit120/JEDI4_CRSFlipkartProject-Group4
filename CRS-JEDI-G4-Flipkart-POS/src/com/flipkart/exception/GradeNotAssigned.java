package com.flipkart.exception;

public class GradeNotAssigned extends Exception {
	
	private String message;
	
	public GradeNotAssigned() {};
	
	public GradeNotAssigned(String messag) {
		this.message = messag;
	}
	
	public String getMessage() {
		return message;
	}

}
