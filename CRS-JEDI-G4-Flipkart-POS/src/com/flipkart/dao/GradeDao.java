package com.flipkart.dao;

import com.flipkart.bean.Grade;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/** The Class GradeDao. **/
public class GradeDao implements GradeDaoInterface {
	
	private static Logger logger = Logger.getLogger(GradeDao.class);
	
	/**
	* Adds the grade.
	*
	* @param g the g
	* @return true, if successful
	*/
	
	public static boolean addGrade(Grade g) {
		BasicConfigurator.configure();

	    Connection conn = Connection1.getConnection();

	    PreparedStatement stmt = null;
	    
	    String sql = "INSERT INTO grade (grade) VALUES (?)";
	    
	    try {
	    	
	      stmt = conn.prepareStatement(sql);
	      stmt.setInt(1, g.getGrade());
	      stmt.executeUpdate();

	    } catch (Exception e) {

	    	logger.error(e);
	    }
	
	    return true;
	}
}
