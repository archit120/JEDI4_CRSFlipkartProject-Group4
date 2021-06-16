package com.flipkart.exception;

public class CourseAlreadyFullException extends Exception{
    private String courseCode;

    public CourseAlreadyFullException(String string) {
        this.courseCode = string;
    }

    @Override
    public String getMessage() {
        return "The course " + this.courseCode + " is already full!";
    }
}
