package com.flipkart.bean;

public class CourseCatalogue {
	private int year;
	private int sem;
	private  int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CourseCatalogue() {
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
}
