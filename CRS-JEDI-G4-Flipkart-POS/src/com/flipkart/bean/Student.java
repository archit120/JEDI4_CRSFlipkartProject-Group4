package com.flipkart.bean;

public class Student extends User {
    private String department;
    private String rollNo;
    private SemesterRegistration[] semesterRegistrations;

    public SemesterRegistration[] getSemesterRegistrations() {
        return semesterRegistrations;
    }

    public void setSemesterRegistrations(SemesterRegistration[] semesterRegistrations) {
        this.semesterRegistrations = semesterRegistrations;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
