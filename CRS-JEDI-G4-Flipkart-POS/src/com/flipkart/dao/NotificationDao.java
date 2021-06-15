package com.flipkart.dao;

import com.flipkart.bean.Notification;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/** The Class NotificationDao. */
public class NotificationDao implements NotificationDaoInterface{
	
	private static Logger logger = Logger.getLogger(NotificationDao.class);

	public  boolean addNotification(String message, String rollno) {
		Connection conn = DBUtil.getConnection();

		PreparedStatement stmt = null;
		try {

			String sql = "INSERT INTO notification (studentId, message) VALUES ((select id from student where rollno = ?), ?)";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, rollno); // This would set age
			stmt.setString(2, message);
			stmt.executeUpdate();

			stmt.close();
			conn.close();
		} catch (Exception e) {

			logger.error(e);
			return false;
		}

		return true;

	}


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
	    	
	    	String sql = "SELECT* FROM notification where studentId=?";

	    	stmt = conn.prepareStatement(sql);
	    	stmt.setInt(1, studentId);
	    	ResultSet rs = stmt.executeQuery();

	    	while (rs.next()) {

	    		Notification temp = new Notification();
	    		temp.setId(rs.getInt("id"));
				temp.setMessage(rs.getString("message"));
				temp.setStudentId(rs.getInt("studentId"));
	    		
	    		notificationList.add(temp);
	    	}

//	    	Optional:delete viewed notifcation
//			sql = "DELETE FROM notification where studentId=?";
//			stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, studentId);
//			stmt.executeQuery();

			stmt.close();
	    	conn.close();
	    } catch (Exception e) {
	    	
	    	logger.error(e);
	    }
	    
	    return notificationList;
	}
}
