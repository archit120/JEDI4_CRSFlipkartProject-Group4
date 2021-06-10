package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public class CourseImpl implements CourseInterface{

    @Override
    public Boolean indicateProfessor(Professor professor) {
        return null;
    }

    @Override
    public Boolean checkAvailibility() {
        return null;
    }

    @Override
    public Student[] viewEnrolledStudents() {
        return new Student[0];
    }
}
