package com.flipkart.bean;

public class Course {

	private String courseCode;
	private String department;
	private String descriptions;
	private String preRequisites;
	private int professorId;
	private int Id;
	private int courseCatalogueId;	//catalog ID
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public int getCourseCatalogueId() {
		return courseCatalogueId;
	}
	public void setCourseCatalogueId(int courseCatalogueId) {
		this.courseCatalogueId = courseCatalogueId;
	}

}
