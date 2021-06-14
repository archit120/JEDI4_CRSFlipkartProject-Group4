package com.flipkart.service;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDao;
import java.util.List;

// TODO: Auto-generated Javadoc
/** The Class NotificationImpl. */
public class NotificationImpl implements NotificationInterface {

  /**
   * Show notification.
   *
   * @param message the message
   * @param rollno the student rollno
   * @return true, if successful
   */
  public boolean showNotification(String message, String rollno) {
    return new NotificationDao().addNotification(message, rollno);
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
