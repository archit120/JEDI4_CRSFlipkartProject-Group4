package com.flipkart.exception;

public class StudentNotApprovedException extends Exception{
	private String username;

    public StudentNotApprovedException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "Student with username " + this.username + " not approved!";
    }
}
