package com.flipkart.service;

import com.flipkart.bean.Grade;
import com.flipkart.dao.GradeDao;
import com.flipkart.dao.RegisteredCourseDao;

// TODO: Auto-generated Javadoc
/**
 * The Class GradeImpl.
 */
public class GradeImpl {
	
	/**
	 * Adds the grade.
	 *
	 * @param cId the c id
	 * @param sId the s id
	 * @param g the g
	 * @return true, if successful
	 */
	public boolean addGrade(int cId,int sId,String g) {
		
		Grade grade = new Grade();
		
//		grade.setGrade(g);
		
		return true;
	}

}
