package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AdminImpl implements AdminInterface {

	private static Logger logger = Logger.getLogger(AdminImpl.class);
	private static Admin adminInstance;

	public AdminImpl() {
	}

	@Override
	public boolean addProfessor(Professor professorToBeAdded) {
		return ProfessorDao.addProfessor(professorToBeAdded);
	}

	@Override
	public boolean addStudent(Student student) {
		return StudentDao.addStudent(student);
	}

	@Override
	public boolean approveGrade(String rollNo) {
		logger.info("Approving grade todo");
		return false;
	}

	
	@Override
	public boolean verifyCourseReg(String rollNo) {
		logger.info("Approving course todo");
		return false;
	}

	@Override
	public boolean login(String userID, String password) {
		
		Admin loginRes = AdminDao.login(userID, password);
		if(loginRes == null)
				return false;
		adminInstance = loginRes;
		return true;
	}


}
