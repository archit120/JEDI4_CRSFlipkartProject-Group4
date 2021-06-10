package com.flipkart.bean;

public class Professor extends User{
	private String empID;
	private String dept;
	private Course teachesCourse;
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Course getTeachesCourse() {
		return teachesCourse;
	}
	public void setTeachesCourse(Course teachesCourse) {
		this.teachesCourse = teachesCourse;
	}
}
