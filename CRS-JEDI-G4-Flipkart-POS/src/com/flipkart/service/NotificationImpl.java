package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDao;

public class NotificationImpl implements NotificationInterface{

	public boolean showNotification(String message, int studentId) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static List<Notification> getNotification(int studentId) {

		return NotificationDao.getNotification(studentId);
	}
}
