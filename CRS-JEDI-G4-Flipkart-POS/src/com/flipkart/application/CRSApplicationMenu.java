package com.flipkart.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.flipkart.dao.AdminDao;
import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseNotRegisteredException;

import org.apache.log4j.BasicConfigurator;

import com.flipkart.exception.LoginFailedException;
import com.flipkart.exception.StudentApprovalFailedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.service.StudentImpl;

// TODO: Auto-generated Javadoc
/** The Class CRSApplicationMenu. */
public class CRSApplicationMenu {


    /** First menu. */
    public static void firstMenu() {
        System.out.println("-----------Welcome to CRS-----------");
        System.out.println("Press 1 - Login.");
        System.out.println("Press 2 - Register as a student.");
        System.out.println("Press 3 - Exit.");
        System.out.println("------------------------------------");
    }

    /** Login choices. */
    public static void loginChoices() {
    System.out.println("-----------LOG IN-----------");
    System.out.println("Press 1 - Student.");
    System.out.println("Press 2 - Professor.");
    System.out.println("Press 3 - Admin.");
    System.out.println("------------------------------------");
    }

    /**
    * The main method.
    *
    * @param args the arguments
     * @throws CourseNotRegisteredException 
    */
    public static void main(String[] args) throws CourseNotRegisteredException {
        BasicConfigurator.configure();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        while (true) {
            firstMenu();
            System.out.println("Your choice: ");
            
            try {
	            int response1 = sc.nextInt();
	
	            if (response1 == 1) {
	                loginChoices();
	                System.out.println("Your response: ");
	                int loginResponse = sc.nextInt();
	
	                switch (loginResponse) {
	                    case 1:
	                        // Student Interface
	                        CRSStudentMenu menu = new CRSStudentMenu();
	                        menu.StudentMenu();
	
	                        break;
	                    case 2:
	                        // Professor Interface
	                        CRSProfessorMenu.professorMenuHandler();
	                        break;
	                    case 3:
	                        // Admin Interface
	                        CRSAdminMenu.adminMenuHandler();
	                        break;
	                    default:
	                    	System.out.println("Please enter valid input");
	                }
	            } else if(response1 == 2){
	
	                System.out.println("Enter your name: ");
	                String name = sc.next();
	
	                System.out.println("Enter your email: ");
	                String email = sc.next();
	
	                System.out.println("Enter your username: ");
	                String username = sc.next();
	
	                System.out.println("Enter your password: ");
	                String password = sc.next();
	
	                System.out.println("Enter your Roll number: ");
	                String roll = sc.next();
	
	                System.out.println("Enter your department: ");
	                String dept = sc.next();
	
	                StudentImpl studImpl = new StudentImpl();
	                try {
	                    studImpl.addStudent(email, password, name,username,roll,dept);
	                    System.out.println("You have successfully been registered, waiting for admin approval !!");
	                } catch (Exception e) {
	               
	                	System.out.println(e.getMessage());
	                }
	
	            } else if(response1 == 3) {
	                System.out.println("Exiting from the website.");
	                break;
	            } else {
	                System.out.println("Invalid input");
	            }
            }catch(InputMismatchException e) {
            	sc.next();
            	System.out.println("Please enter valid input");
            }
        }
    }
}
