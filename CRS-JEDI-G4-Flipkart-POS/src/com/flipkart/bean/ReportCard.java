package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class ReportCard {
	private double sgpa;
	private List<String> courseCodes =new ArrayList<String>();
	private List<Integer> grades=new ArrayList<Integer>();
	private List<Integer> courseIDs =new ArrayList<Integer>();
	//private boolean approved;
	public double getSgpa() {
		return sgpa;
	}
	public void setSgpa(double sgpa) {
		this.sgpa = sgpa;
	}
	public List<String> getCourseCodes() {
		return courseCodes;
	}
	public void setCourseCodes(List<String> courseCodes) {
		this.courseCodes = courseCodes;
	}
	public List<Integer> getGrades() {
		return grades;
	}
	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}
	public List<Integer> getCourseIDs() {
		return courseIDs;
	}
	public void setCourseIDs(List<Integer> courseIDs) {
		this.courseIDs = courseIDs;
	}
	
	
}
