package com.flipkart.service;

import com.flipkart.bean.Course;

// TODO: Auto-generated Javadoc
/**
 * The Class UserImpl.
 */
public class UserImpl implements UserInterface{
    
    /**
     * Login.
     *
     * @param userID the user ID
     * @param password the password
     * @return the boolean
     */
    @Override
    public Boolean login(int userID, String password) {
        return null;
    }

    /**
     * View course.
     *
     * @return the course[]
     */
    @Override
    public Course[] viewCourse() {
        return new Course[0];
    }
}
