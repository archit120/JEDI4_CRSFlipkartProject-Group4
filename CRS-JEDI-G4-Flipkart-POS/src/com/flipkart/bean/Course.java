package com.flipkart.bean;

public class Course {
	private String courseID;
	private String department;
	private String descriptions;
	private String preRequisites;
	private String professor;
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getPreRequisites() {
		return preRequisites;
	}
	public void setPreRequisites(String preRequisites) {
		this.preRequisites = preRequisites;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
}
