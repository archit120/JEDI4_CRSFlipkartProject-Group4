package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;

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
    System.out.println("Press 1 to login.");
    System.out.println("Press 2 to change password.");
    System.out.println("Press 3 to Register as a student.");
    System.out.println("Press 4 to exit.");
    System.out.println("------------------------------------");
  }
  /** Login choices. */
  public static void loginChoices() {
    System.out.println("-----------LOG IN-----------");
    System.out.println("Press 1 if you are a student.");
    System.out.println("Press 2 if you are a professor.");
    System.out.println("Press 3 if you are an admin.");
    System.out.println("------------------------------------");
  }

  /**
   * The main method.
   *
   * @param args the arguments

 * @throws CourseAlreadyFullException 
 * @throws CourseAlreadyRegisteredException 
 * @throws StudentApprovalFailedException 
 * @throws LoginFailedException 
 * @throws StudentNotApprovedException 
 * @throws StudentRegistrationFailedException 
 * @throws StudentAlreadyApprovedException 
 * @throws LoginException 
   */
  public static void main(String[] args) throws LoginFailedException, StudentNotApprovedException,StudentApprovalFailedException,CourseAlreadyFullException, CourseAlreadyRegisteredException {
	  BasicConfigurator.configure();
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);

    while (true) {
      firstMenu();
      System.out.println("Your choice:");
      int response1 = sc.nextInt();

      if (response1 == 1) {
        loginChoices();
        System.out.println("Your response:");
        int loginResponse = sc.nextInt();

        switch (loginResponse) {
          case 1:
            // StudentIntefrace

            CRSStudentMenu menu = new CRSStudentMenu();
            menu.StudentMenu();

            break;
          case 2:
            CRSProfessorMenu.professorMenuHandler();
            break;
          case 3:
				CRSAdminMenu.adminMenuHandler();
            break;
          default:
            System.out.println("Invalid input.");
        }
      } else if (response1 == 2) {
        // updatePasswordUser
      } else if(response1 == 4) {
        System.out.println("Exiting from the website.");
        break;
      }else if(response1 ==3){
    	  
    	  System.out.println("Enter your name");
    	  String name = sc.next();
    	  
    	  System.out.println("Enter your email");
    	  String email = sc.next();
    	  
    	  System.out.println("Enter your username");
    	  String username = sc.next();
    	  
    	  System.out.println("Enter your password");
    	  String password = sc.next();
    	  
    	  System.out.println("Enter your Roll number");
    	  String roll = sc.next();
    	  
    	  System.out.println("Enter your department");
    	  String dept = sc.next();
    	  
    	  StudentImpl studImpl = new StudentImpl();
    	  boolean done = studImpl.addStudent(email, password, name,username,roll,dept);
    	  if(done) {
    		  System.out.println("You have sucessfully been registered , waiting for admin approval !!");
    	  }
    	  
      }else {
    	  System.out.println("INVALID !!!!");
      }
    }
  }
}
