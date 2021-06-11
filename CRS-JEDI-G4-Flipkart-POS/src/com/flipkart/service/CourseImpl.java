package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseImpl implements CourseInterface{

    private  static  List<Course> courses;
    public CourseImpl() {
        if(courses==null)
            courses = new ArrayList<>();
    }

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
        RegisteredCourseImpl registeredCourse = new RegisteredCourseImpl();
        return registeredCourse.checkAvailability(course);
    }

    @Override
    public List<Course> findCourses(CourseCatalogue courseCatalogue) {
        List<Course> coursesRet = new ArrayList<>();
        for(Course c: courses)
            if(c.getCourseCatalogue() == courseCatalogue)
                coursesRet.add(c);
        return coursesRet;
    }

    @Override
    public Course findCourse(CourseCatalogue courseCatalogue, String courseID) {
        Course course = null;
        for(Course c: courses)
            if(c.getCourseCatalogue() == courseCatalogue && c.getCourseID().equals(courseID))
                course = c;
        return course;
    }

    @Override
    public List<Student> viewEnrolledStudents(Course course) {
        return new RegisteredCourseImpl().viewEnrolledStudents(course);
    }
}
