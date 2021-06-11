package com.flipkart.application;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.CourseCatalogueImpl;
import com.flipkart.service.CourseImpl;
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
		
		try {
			ProfessorImpl prof = new ProfessorImpl();
			CourseCatalogueImpl courseCatalogue = new CourseCatalogueImpl();
			while(true) {
				System.out.print("Enter prof username: ");
				String username = sc.next();
				System.out.print("Enter prof password: ");
				String password = sc.next();
				if(prof.login(username, password))
					break;
				System.out.println("Invalid login. Please retry.");
			}

			while(true) {
				
				CRSProfessorMenu.showProfessorMenu();
				
			    int option = sc.nextInt();
				
				System.out.println();
				
				switch(option) {
				
					case 1:
	
					case 2:
					
					case 3:
						List<Course> courses = courseCatalogue.getCourses();
						System.out.println("Total " + courses.size() +" courses found");
						for(Course course : courses) {
							System.out.println("\nCourse Details");
							System.out.println("CourseID: " + course.getCourseID());
							System.out.println("Course Description: " + course.getDescriptions());
							System.out.println("Course Department: " + course.getDepartment());
							System.out.println("Course Pre Requisites : " + course.getPreRequisites());
							if(course.getProfessor() == null)
								System.out.println("This course is free to be taught by you!");
						}
						break;
					case 4:
						System.out.print("Enter Course ID of Course to teach: ");
						Course registerCourse = courseCatalogue.findCourse(sc.next());
						if(registerCourse == null)
							System.out.println("Course not found!");
						else {
							if(new CourseImpl().indicateProfessor(registerCourse, ProfessorImpl.getProfessorInstance()))
								System.out.println("Course marked successfully!");
							else
								System.out.println("Unknown error while marking course!");
						}
						break;
					case 5:
						System.out.println("Successfully logged out");
						
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