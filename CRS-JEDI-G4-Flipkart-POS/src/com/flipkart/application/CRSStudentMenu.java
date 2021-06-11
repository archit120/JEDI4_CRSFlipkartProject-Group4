package com.flipkart.application;

import java.util.Scanner;

public class CRSStudentMenu {
	
	
	public void printMenu(){
		System.out.println("*****Welcome to the Student Menu**********");
		System.out.println("1. View Course Catalogue");
		System.out.println("2. ADD COURSE ");
		System.out.println("3. DROP COURSE ");
		System.out.println("4. PAY FEE");
		System.out.println("5. VIEW REGISTERED COURSES");
		System.out.println("6. View REPORT CARD");
		System.out.println("7. VIEW NOTOFICATIONS");
		System.out.println("8. LOGOUT");
	}
	
	public void StudentMenu(){
		
		
		printMenu();
		
		
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		while(true){
			
			if(option == 1){
				
				System.out.println("\n\n **********ALL THE AVAILABLE COURSES ARE********* \n\n");
				
				System.out.println("All avaialbe couses will be fetched here");
				
				
				
			}else if(option == 2){
				
				System.out.println("Enetr course id to be added");
				
				int cId = sc.nextInt();
				
				
			}else if(option == 3){
				

				System.out.println("Enetr course id to be dropped");
				
				int cId = sc.nextInt();
				
				
			}else if(option == 4){
				
				System.out.println("Enetr Fee method");
				
				int cId = sc.nextInt();
				
				
			}else if(option == 5){
				
				System.out.println("Registered Courses are");
				
				
				
			}else if(option == 6){
				
				System.out.println("Report Card");
				
				
			}else if(option == 7){
				
				System.out.println("All Notification are");
				
				
			}else if(option == 8){
				
				break;
			}
			
			else{
				System.out.println(" Enter valid Inputs ");
			}
			
			System.out.println("\n\n ENTER YOUR CHOICE \n\n");
			
			option = sc.nextInt();
			
		}
		
		
		
		
		
		
		
	}

}
