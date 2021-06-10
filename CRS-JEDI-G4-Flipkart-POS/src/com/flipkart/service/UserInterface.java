package com.flipkart.service;

import com.flipkart.bean.Course;

public interface UserInterface {
    public Boolean login(int userID, String password);
    public Course[] viewCourse();
}
