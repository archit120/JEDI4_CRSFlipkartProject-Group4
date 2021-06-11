package com.flipkart.application;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.service.CourseCatalogueImpl;
import com.flipkart.service.ProfessorImpl;

public class CRSProfessorMenu {

	public static void showProfessorMenu() {

		System.out.println("# Professor Menu");

		System.out.println("Press 1 - List the enrolled students");

		System.out.println("Press 2 - Mark student's grade");

		System.out.println("Press 3 - List of courses to teach");

		System.out.println("Press 4 - Register for course to teach");

		System.out.println("Press 5 - Logout");
	}

	public static void professorMenuHandler() {
		
		Scanner sc = new Scanner(System. in);
		while(true) {
			ProfessorImpl toLogin=new ProfessorImpl();
			System.out.print("Enter Professor username: ");
			String username = sc.next();
			System.out.print("Enter Professor password: ");
			String password = sc.next();
			if(toLogin.login(username, password))
				break;
			System.out.println("Invalid login. Please retry.");
		}
		
		try {
			
			while(true) {
				
				CRSProfessorMenu.showProfessorMenu();
				
			    int option = sc.nextInt();
				
				System.out.println();
				
				switch(option) {
				
					case 1:
						ProfessorImpl prof= new ProfessorImpl();
						System.out.println("Enter Course ID");
						String courseID=sc.next();
						List<Student> studentList=prof.getEnrolledStudents(courseID);
						System.out.println(studentList);
						break;
	
					case 2:
						System.out.println("Enter Roll number");
						String roll=sc.next();
						System.out.println("Enter course ID");
						String courseid=sc.next();
						System.out.println("Enter grade allotted");
						String gradeGiven=sc.next();
						Grade gradeAllotted =new Grade();
						gradeAllotted.setApproved(false);
						gradeAllotted.setLetterGrade(gradeGiven);
						System.out.println("Enter pointer allotted (int)");
						int pointer=sc.nextInt();
						gradeAllotted.setIntGrade(pointer);
						ProfessorImpl profObj= new ProfessorImpl();
						profObj.addGrade(courseid, roll, gradeAllotted);
						break;
					
					case 3:
						CourseCatalogueImpl courseCatalog=new CourseCatalogueImpl();
						List<Course> catalog=courseCatalog.getCourses();
						System.out.println(catalog);
						break;
						
					case 4:
						System.out.println("Enter your EmpID");
						String empId=sc.next();
						System.out.println("Enter Course ID you want to teach");
						String courseToTeach=sc.next();
						ProfessorImpl profObject= new ProfessorImpl();
						profObject.chooseCourse(empId,courseToTeach);
						break;
					case 5:
						System.out.println("Successfully logged out");
						ProfessorImpl profLogout= new ProfessorImpl();
						profLogout.logout();
						return;
					default:
						System.out.println("Invalid choice");
						break;
				}
			}
		} catch (Exception e) {
			
		}
	}
}