package com.flipkart.bean;

public class RegisteredCourse {
    private int sId;
    private int cId;
    private int gId;
    private int semId;
    
	public RegisteredCourse(int sId, int cId, int gId, int semId) {
		super();
		this.sId = sId;
		this.cId = cId;
		this.gId = gId;
		this.semId = semId;
	}
    public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public int getSemId() {
		return semId;
	}

	public void setSemId(int semId) {
		this.semId = semId;
	}

	
	
}