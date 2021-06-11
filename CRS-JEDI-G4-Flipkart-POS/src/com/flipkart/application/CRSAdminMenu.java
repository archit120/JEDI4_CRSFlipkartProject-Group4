package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

public class CRSAdminMenu {
	
	public static void showAdminMenu() {
		
		System.out.println("# Admin Menu");
		
		System.out.println("Press 1 - Add course");

		System.out.println("Press 2 - Remove course");

		System.out.println("Press 3 - Add Professor");

		System.out.println("Press 4 - Approve Student");

		System.out.println("Press 5 - Logout");
	}

	public static void adminMenuHandler() {
		
		try {
			
			while(true) {
				
				CRSAdminMenu.showAdminMenu();
				
				Scanner sc = new Scanner(System. in);
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
					    newCourse.setDescriptions(takeInput);

						System.out.print("Enter Course professor:");
					    takeInput = sc.next();
					    newCourse.setDescriptions(takeInput);
					    
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
						System.out.println("Logged out\n");
						return;
						
					default:
						System.out.println("Invalid choice");
				}
			}
		} catch(Exception e) {
			
		}
	}
}
