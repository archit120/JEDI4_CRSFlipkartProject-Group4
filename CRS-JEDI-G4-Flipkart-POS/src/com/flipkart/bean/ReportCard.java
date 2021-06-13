package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class ReportCard {
	private double sgpa;
	private List<String> courseCode=new ArrayList<String>();
	private List<Integer> grades=new ArrayList<Integer>();
	private List<Integer> courseID=new ArrayList<Integer>();
	//private boolean approved;
	public double getSgpa() {
		return sgpa;
	}
	public void setSgpa(double sgpa) {
		this.sgpa = sgpa;
	}
	public List<String> getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(List<String> courseCode) {
		this.courseCode = courseCode;
	}
	public List<Integer> getGrades() {
		return grades;
	}
	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}
	public List<Integer> getCourseID() {
		return courseID;
	}
	public void setCourseID(List<Integer> courseID) {
		this.courseID = courseID;
	}
	
	
}
