package com.flipkart.bean;

public class ReportCard {
	private double sgpa;
	private double cgpa;
	private String courses[];
	private String grades[];
	private boolean approved;
	
	public double getSgpa() {
		return sgpa;
	}
	public void setSgpa(double sgpa) {
		this.sgpa = sgpa;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	public String[] getGrades() {
		return grades;
	}
	public void setGrades(String[] grades) {
		this.grades = grades;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
}
