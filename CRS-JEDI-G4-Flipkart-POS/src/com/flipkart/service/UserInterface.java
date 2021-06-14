package com.flipkart.service;

import com.flipkart.bean.Course;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserInterface.
 */
public interface UserInterface {
    
    /**
     * Login.
     *
     * @param userID the user ID
     * @param password the password
     * @return the boolean
     */
    public Boolean login(int userID, String password);
    
    /**
     * View course.
     *
     * @return the course[]
     */
    public Course[] viewCourse();
}
