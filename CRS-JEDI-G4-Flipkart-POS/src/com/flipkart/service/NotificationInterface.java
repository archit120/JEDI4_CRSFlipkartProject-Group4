package com.flipkart.service;

import com.flipkart.bean.Notification;
import java.util.List;

// TODO: Auto-generated Javadoc
/** The Interface NotificationInterface. */
public interface NotificationInterface {

  /**
   * Gets the notification.
   *
   * @param studentId the student id
   * @return the notification
   */
  public List<Notification> getNotification(int studentId);
}
