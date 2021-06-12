package com.flipkart.bean;

public class RegisteredCourse {
    private int studentId;
    private int courseId;
    private int gradeId;
    private int semesterRegistrationId;
    private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RegisteredCourse(int studentId, int courseId, int gradeId, int semesterRegistrationId) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.gradeId = gradeId;
		this.semesterRegistrationId = semesterRegistrationId;
	}
    public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getSemesterRegistrationId() {
		return semesterRegistrationId;
	}

	public void setSemesterRegistrationId(int semesterRegistrationId) {
		this.semesterRegistrationId = semesterRegistrationId;
	}

	
	
}