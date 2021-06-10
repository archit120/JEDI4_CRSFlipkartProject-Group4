package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface CourseInterface {

    public Boolean indicateProfessor(Professor professor);

    public Boolean checkAvailibility();

    public Student[] viewEnrolledStudents();

}
