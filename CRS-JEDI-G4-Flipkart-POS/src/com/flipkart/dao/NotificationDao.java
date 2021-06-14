package com.flipkart.dao;

import com.flipkart.bean.Notification;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/** The Class NotificationDao. */
public class NotificationDao {
	
	private static Logger logger = Logger.getLogger(NotificationDao.class);


	/**
    * Gets the notification.
    *
    * @param studentId the student id
    * @return the notification
    */
	
	public List<Notification> getNotification(int studentId) {
		
		 Connection conn = DBUtil.getConnection();

	    PreparedStatement stmt = null;
	    
	    List<Notification> notificationList = new ArrayList<Notification>();
	    
	    try {
	    	
	    	String sql = "SELECT* FROM course";

	    	stmt = conn.prepareStatement(sql);
	    	ResultSet rs = stmt.executeQuery(sql);

	    	while (rs.next()) {

	    		Notification temp = new Notification();
	    		temp.setId(rs.getInt("id"));
	    		temp.setMessage(rs.getString("message"));
	    		temp.setStudentId(studentId);
	    		
	    		notificationList.add(temp);
	    	}
	    	
	    	stmt.close();
	    	conn.close();
	    } catch (Exception e) {
	    	
	    	logger.error(e);
	    }
	    
	    return notificationList;
	}
}
