package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Notification;

public interface NotificationInterface {
	
	public List<Notification> getNotification(int studentId);
}

