package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.bean.Course;

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
					
					case 4:
					
					case 5:
						
					default;
				}
			}
		} catch(Exception e) {
			
		}
	}
}
