package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDao;

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
        if(course.getProfessorId() != 0)
            return false;
        course.setProfessorId(professor.getUserID());
        return CourseDao.markCourseToTeach(course.getId(), professor.getUserID());
    }

    @Override
    public boolean addCourse(Course course) {
    	return CourseDao.addCourse(course);
    }

    @Override
    public Boolean checkAvailability(Course course) {
        RegisteredCourseImpl registeredCourse = new RegisteredCourseImpl();
        return registeredCourse.checkAvailability(course);
    }

    @Override
    public boolean removeCourse(CourseCatalogue courseCatalogue, String courseCode) {
        return CourseDao.removeCourse(findCourse(courseCatalogue, courseCode).getId());
    }

    @Override
    public List<Course> findCourses(CourseCatalogue courseCatalogue) {
        return CourseDao.findCourses(courseCatalogue);
    }

    @Override
    public Course findCourse(CourseCatalogue courseCatalogue, String courseID) {
        return CourseDao.findCourse(courseCatalogue, courseID);
    }


    @Override
    public List<Student> viewEnrolledStudents(Course course) {
        return new RegisteredCourseImpl().viewEnrolledStudents(course);
    }
}
