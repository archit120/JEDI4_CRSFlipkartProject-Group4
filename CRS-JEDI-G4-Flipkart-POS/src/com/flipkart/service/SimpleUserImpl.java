package com.flipkart.service;

import com.flipkart.bean.Course;

public class SimpleUserImpl implements UserInterface{
    @Override
    public Boolean login(int userID, String password) {
        return null;
    }

    @Override
    public Course[] viewCourse() {
        return new Course[0];
    }
}
