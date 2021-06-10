package com.flipkart.bean;

public class SemesterRegistration {
    private RegisteredCourse[] registeredCourses;
    private int semester;
    private int year;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public RegisteredCourse[] getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(RegisteredCourse[] registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
