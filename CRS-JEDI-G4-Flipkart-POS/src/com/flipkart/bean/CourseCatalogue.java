package com.flipkart.bean;

import java.util.ArrayList;

public class CourseCatalogue {
	private String year;
	private int sem;
	private ArrayList<Course> courses;

	public CourseCatalogue() {
		courses = new ArrayList<>();
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
}
