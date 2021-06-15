/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Shravya
 *
 */
public class StudentApprovalFailedException extends Exception{
    private String email;

    public StudentApprovalFailedException(String email) {
        this.email = email;
    }

    @Override
    public String getMessage() {
        return "Student with Email " + this.email + " couldn't be approved!";
    }
}