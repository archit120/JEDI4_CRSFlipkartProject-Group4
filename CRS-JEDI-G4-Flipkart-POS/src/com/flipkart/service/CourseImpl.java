package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public class CourseImpl implements CourseInterface{

    @Override
    public Boolean indicateProfessor(Course course, Professor professor) {
        if(course.getProfessor() != null)
            return false;
        course.setProfessor(professor);
        professor.setTeachesCourse(course);
        return true;
    }

    @Override
    public Boolean checkAvailability(Course course) {
        if(course.getCurrentEnrollment() > 10)
            return false;
        return true;
    }

    @Override
    public List<Student> viewEnrolledStudents(Course course) {
        return new RegisteredCourseImpl().viewEnrolledStudents(course);
    }
}
