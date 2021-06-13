package com.flipkart.bean;

public class Payment {

	private int id;
	private String mode;
	private int studentId;
	private int semesterRegistrationId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSemesterRegistrationId() {
		return semesterRegistrationId;
	}
	public void setSemesterRegisrationId(int semesterRegistrationId) {
		this.semesterRegistrationId = semesterRegistrationId;
	}

	
}
