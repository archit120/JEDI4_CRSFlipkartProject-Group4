package com.flipkart.service;

import com.flipkart.bean.Grade;
import com.flipkart.dao.GradeDao;
import com.flipkart.dao.RegisteredCourseDao;

public class GradeImpl {
	
	public boolean addGrade(int cId,int sId,String g) {
		
		Grade grade = new Grade();
		
//		grade.setGrade(g);
		
		return true;
	}

}
