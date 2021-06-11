package com.flipkart.application;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.CourseCatalogueImpl;

public class CRSAdminMenu {
	
	public static void showAdminMenu() {
		
		System.out.println("# Admin Menu");
		
		System.out.println("Press 1 - Add course");

		System.out.println("Press 2 - Remove course");

		System.out.println("Press 3 - Add Professor");

		System.out.println("Press 4 - Approve Student");

		System.out.println("Press 5 - List Courses");

		System.out.println("Press 6 - Logout");
	}

	public static void adminMenuHandler() {
		
		try {

			// first login as an admin
			Scanner sc = new Scanner(System. in);
			AdminImpl admin = new AdminImpl();
			CourseCatalogueImpl courseCatalogue = new CourseCatalogueImpl();
			while(true) {
				System.out.print("Enter admin username: ");
				String username = sc.next();
				System.out.print("Enter admin password: ");
				String password = sc.next();
				if(admin.login(username, password))
					break;
				System.out.println("Invalid login. Please retry.");
			}

			while(true) {
				
				CRSAdminMenu.showAdminMenu();
				
			    int option = sc.nextInt();
				
				System.out.println();
				
				switch(option) {
				
					case 1:
						
						Course newCourse = new Course();
						
						String takeInput;
						
						System.out.print("Enter Course Id:");
					    takeInput = sc.next();
					    newCourse.setCourseID(takeInput);

						System.out.print("Enter Course Department:");
					    takeInput = sc.next();
					    newCourse.setDepartment(takeInput);

						System.out.print("Enter Course Description:");
					    takeInput = sc.next();
					    newCourse.setDescriptions(takeInput);

						System.out.print("Enter Course preRequisites:");
					    takeInput = sc.next();
					    newCourse.setPreRequisites(takeInput);

						admin.addCourse(newCourse);

					    break;

					case 2:
					
					case 3:
						Professor newProfessor = new Professor();
						
						String takeInput2;
						
						System.out.print("Enter Professor Id:");
					    int ID = sc.nextInt();
					    newProfessor.setUserID(ID);

						System.out.print("Enter Professor Name:");
					    takeInput2 = sc.next();
					    newProfessor.setName(takeInput2);

						System.out.print("Enter Professor Email:");
					    takeInput2 = sc.next();
					    newProfessor.setEmail(takeInput2);

						System.out.print("Enter Professor Password:");
					    takeInput2 = sc.next();
					    newProfessor.setPassword(takeInput2);

						System.out.print("Enter Professor EmployeeID:");
					    takeInput2 = sc.next();
					    newProfessor.setEmpID(takeInput2);
					    
					    System.out.print("Enter Professor Department:");
					    takeInput2 = sc.next();
					    newProfessor.setDept(takeInput2);
						
					case 4:
						
						
					case 5:
						List<Course> courses = courseCatalogue.getCourses();
						System.out.println("Total " + courses.size() +" courses found");
						for(Course course : courses) {
							System.out.println("\n Course Details");
							System.out.println("CourseID: " + course.getCourseID());
							System.out.println("Course Description: " + course.getDescriptions());
							System.out.println("Course Department: " + course.getDepartment());
							System.out.println("Course Pre Requisites : " + course.getPreRequisites());
						}
						break;
					case 6:
						System.out.println("Successfully logged out");
						return;
					default:
            System.out.println("Invalid choice");
						break;
				}
			}
		} catch(Exception e) {

		}
	}
}
