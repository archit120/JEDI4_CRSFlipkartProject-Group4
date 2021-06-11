/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author anike
 *
 */
public class SemesterRegistrationImpl implements SemesterRegistrationInterface{

	private static List<SemesterRegistration> semesterRegistrations;

	public SemesterRegistrationImpl() {
		if(semesterRegistrations == null){
			semesterRegistrations = new ArrayList<>();
		}
	}

	@Override
	public boolean addGrade(int studentId, String grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dropCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int viewGrade(int courseId, String grade) {
		// TODO Auto-generated method stub
		return 0;
	}

}
