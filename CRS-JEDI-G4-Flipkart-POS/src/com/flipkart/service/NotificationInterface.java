package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Notification;

// TODO: Auto-generated Javadoc
/**
 * The Interface NotificationInterface.
 */
public interface NotificationInterface {
	
	/**
	 * Gets the notification.
	 *
	 * @param studentId the student id
	 * @return the notification
	 */
	public List<Notification> getNotification(int studentId);
}

