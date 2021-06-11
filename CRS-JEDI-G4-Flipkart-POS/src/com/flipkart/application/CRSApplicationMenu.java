package com.flipkart.application;

import com.flipkart.bean.CourseCatalogue;

import java.util.Scanner;

public class CRSApplicationMenu {
	public static void firstMenu() {
		System.out.println("-----------Welcome to CRS-----------");
		System.out.println("Press 1 to login.");
		System.out.println("Press 2 to change password.");
		System.out.println("Press 3 to exit.");
		System.out.println("------------------------------------");
	}
	
	public static void loginChoices() {
		System.out.println("-----------LOG IN-----------");
		System.out.println("Press 1 if you are a student.");
		System.out.println("Press 2 if you are a professor.");
		System.out.println("Press 3 if you are admin.");
		System.out.println("------------------------------------");
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while(true) {
			firstMenu();
			System.out.println("Your choice:");
			int response1 = sc.nextInt();
			
			if(response1 == 1) {
				loginChoices();
				System.out.println("Your response:");
				int loginResponse = sc.nextInt();
				
				switch(loginResponse) {
				case 1:
					//StudentIntefrace
					
					CRSStudentMenu menu = new CRSStudentMenu();
					menu.StudentMenu();
					
					break;
				case 2:
					CRSProfessorMenu.professorMenuHandler();
					break;
				case 3:
					CRSAdminMenu.adminMenuHandler();;
					break;
				default:
					System.out.println("Invalid input.");	
				}
			}
			else if(response1 == 2) {
				//updatePasswordUser
			}
			else {
				System.out.println("Exiting from the website.");
				break;
			}
		}
	}

}
