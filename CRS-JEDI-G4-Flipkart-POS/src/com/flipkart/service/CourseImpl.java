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
//        if(course.getProfessor() != null)
//            return false;
//        course.setProfessor(professor);
//        professor.setTeachesCourse(course);
        return true;
    }

    @Override
    public boolean addCourse(Course course) {
    	return CourseDao.addCourse(course);
        //return courses.add(course);
    }

    @Override
    public Boolean checkAvailability(Course course) {
        RegisteredCourseImpl registeredCourse = new RegisteredCourseImpl();
        return registeredCourse.checkAvailability(course);
    }

    @Override
    public boolean removeCourse(String courseID) {
//        Course c = findCourse(courseCatalogue, courseID);
        return CourseDao.removeCourse(courseID);
    }

    @Override
    public List<Course> findCourses(CourseCatalogue courseCatalogue) {
//        List<Course> coursesRet = new ArrayList<>();
        //for(Course c: courses)
           // if(c.getCourseCatalogue() == courseCatalogue)
             //   coursesRet.add(c);
        return CourseDao.findCourses(courseCatalogue);
    }

    @Override
    public Course findCourse(CourseCatalogue courseCatalogue, String courseID) {
        return CourseDao.findCourse(courseCatalogue, courseID);
    }

	public  boolean addCouseToTeach(String courseCode,int pId) {
		int cId=CourseDao.getCourseIdfromCode(courseCode);
		return CourseDao.addCouseToTeach(cId, pId);
	}

//    @
//    public List<Student> viewEnrolledStudents(Course course) {
//        return new RegisteredCourseImpl().viewEnrolledStudents(course);
//    }
}
