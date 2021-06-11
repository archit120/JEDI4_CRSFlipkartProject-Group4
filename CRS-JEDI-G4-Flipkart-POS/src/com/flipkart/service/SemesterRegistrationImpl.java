/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.SemesterRegistration;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author anike
 *
 */
public class SemesterRegistrationImpl implements SemesterRegistrationInterface{

	private static Hashtable<Student, ArrayList<SemesterRegistration>> studentSemesterRegistrations;

	public SemesterRegistrationImpl() {
		if(studentSemesterRegistrations == null)
			studentSemesterRegistrations = new Hashtable<>();
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
