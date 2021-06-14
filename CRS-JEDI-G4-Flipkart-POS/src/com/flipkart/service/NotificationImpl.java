package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDao;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationImpl.
 */
public class NotificationImpl implements NotificationInterface{

	/**
	 * Show notification.
	 *
	 * @param message the message
	 * @param studentId the student id
	 * @return true, if successful
	 */
	public boolean showNotification(String message, int studentId) {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * Gets the notification.
	 *
	 * @param studentId the student id
	 * @return the notification
	 */
	public List<Notification> getNotification(int studentId) {

		return new NotificationDao().getNotification(studentId);
	}
}
