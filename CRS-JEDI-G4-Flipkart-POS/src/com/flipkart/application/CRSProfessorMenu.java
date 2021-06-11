package com.flipkart.application;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

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
			
			while(true) {
				
				CRSProfessorMenu.showProfessorMenu();
				
			    int option = sc.nextInt();
				
				System.out.println();
				
				switch(option) {
				
					case 1:
	
					case 2:
					
					case 3:
						
					case 4:
	
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