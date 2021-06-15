package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.dao.CourseDao;
import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseDoesntExistException;
import com.flipkart.exception.CourseNotRegisteredException;
import com.flipkart.exception.LoginFailedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.PaymentAlreadyDone;
import com.flipkart.service.*;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/** The Class CRSStudentMenu. */
public class CRSStudentMenu {

  private static Logger logger = Logger.getLogger(CRSStudentMenu.class);

  /** Prints the menu. */
  public void printMenu() {
    System.out.println("-----------Welcome to the Student Menu-----------");
    System.out.println("1. View Course Catalogue");
    System.out.println("2. Add Course ");
    System.out.println("3. Drop Course ");
    System.out.println("4. Pay Fee");
    System.out.println("5. View Registered Courses");
    System.out.println("6. View Report Card");
    System.out.println("7. View Notifications");
    System.out.println("8. Logout");
    System.out.println("----------------------------------------------------");
  }

  /** Student menu. 
 * @throws CourseNotRegisteredException 
 * @throws CourseAlreadyFullException 
 * @throws LoginFailedException 
 * @throws StudentNotApprovedException 
 */
  public void StudentMenu() throws CourseNotRegisteredException {

    Scanner sc = new Scanner(System.in);
    CourseCatalogue chosen = new CourseCatalogueImpl().getCourseCatalogues().get(0);
    StudentImpl stud = new StudentImpl();
    CourseImpl courseImpl = new CourseImpl();
    RegisteredCourseImpl regImpl = new RegisteredCourseImpl();
    CourseCatalogueImpl courseCatalogue = new CourseCatalogueImpl();
    SemesterRegistrationImpl semImpl = new SemesterRegistrationImpl();

    while (true) {

      System.out.print("Enter student username: ");
      String username = sc.next();
      System.out.print("Enter student password: ");
      String password = sc.next();

      try {

        if (stud.login(username, password)) break;
      } catch(LoginFailedException e){

        logger.error(e.getMessage());
      } catch(StudentNotApprovedException e1){

        logger.error(e1.getMessage());
      }
      //System.out.println("Invalid login. Please retry.");
    }
    printMenu();

    int option = sc.nextInt();

    SemesterRegistration chosenSem = null;

    if (semImpl.viewSemesterRegistrations(stud.getStudentInstance().getUserID()).size() == 0) {

      chosenSem = new SemesterRegistration();
      chosenSem.setStudentId(stud.getStudentInstance().getUserID());
      chosenSem.setSemester(chosen.getSem());
      chosenSem.setYear(chosen.getYear());
      semImpl.addSemesterRegistration(chosenSem);
    } else {

      chosenSem = semImpl.viewSemesterRegistrations(stud.getStudentInstance().getUserID()).get(0);
    }

    while (true) {

      if (option == 1) {

        System.out.println("\n\n **********ALL THE AVAILABLE COURSES ARE********* \n\n");

        List<Course> courses = courseImpl.findCourses(chosen);
        System.out.println("Total " + courses.size() + " courses found");
        
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.format("%25s%25s%25s%25s%n", "Course Code", "Course Description", "Course Department", "Course Prerequisites" );
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        
        for (Course course : courses) {

          System.out.format("%25s%25s%25s%25s%n",course.getCourseCode(), course.getDescriptions(), course.getDepartment(), course.getPreRequisites());         
        }
        
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        
      } else if (option == 2) {

        System.out.println("Enter the course code you want to add");

        try {
          Course c = courseImpl.findCourse(chosen, sc.next());
          stud.registerForCourse(chosenSem, c);
          logger.info("Course registered");
        }catch(CourseAlreadyRegisteredException e) {
          logger.error(e.getMessage());
        }
        catch (CourseAlreadyFullException e) {
          logger.error(e.getMessage());
        }catch(CourseDoesntExistException e) {
        	logger.error(e.getMessage());
        }
      } else if (option == 3) {

        System.out.println("Enter course code to be dropped: ");
        try {
        	regImpl.dropRegisteredCourse(regImpl.findRegisteredCourse(chosenSem, sc.next()));
        	System.out.println("Course dropped");
        }catch(Exception e) {
        	logger.error(e.getMessage());
        }

      } else if (option == 4) {

        System.out.println("Payment options: ");

        System.out.println();

        System.out.println("Press 1 - Pay Online");

        System.out.println("Press 2 - Pay Offline");

        int option2 = sc.nextInt();

        String mode = "Online";

        if (option2 == 2) {

          mode = "Offline";
        }

        Payment p = new Payment();

        p.setMode(mode);
        p.setStudentId(stud.getStudentInstance().getUserID());
        p.setSemesterRegisrationId(chosenSem.getId());

        PaymentImpl paymentImpl = new PaymentImpl();

        try {

          paymentImpl.makePayment(p);
          logger.info("Payment Done!");
          new NotificationImpl().showNotification("Payment done at " + LocalDateTime.now(), stud.getStudentInstance().getRollNo());
        } catch(PaymentAlreadyDone e) {
          logger.error(e.getMessage());
        }

      } else if (option == 5) {

        System.out.println("Registered Courses are");
        List<RegisteredCourse> registeredCourses = regImpl.findRegisteredCourses(chosenSem);
        System.out.println("You have registered for a total of " + registeredCourses.size() + " courses.");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.format("%25s%n","Course Code");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        for (RegisteredCourse registeredCourse : registeredCourses) {

          System.out.format("%25s%n" , CourseDao.getCourse(registeredCourse.getCourseId()).getCourseCode());
        }

      } else if (option == 6) {
  
        try {
        	
	        ReportCard report = stud.viewReportCard(chosenSem);
	        System.out.println("Report Card:");
	        System.out.println("--------------------------------------------------------");
	        System.out.format("%25s%25s%n", "Course Code", "Grade");
	        System.out.println("--------------------------------------------------------");
	        for (int i = 0; i < report.getCourseCodes().size(); i++) {
	        	
	          System.out.format("%25s%25s%n", report.getCourseCodes().get(i), report.getGrades().get(i));
	        
	        }
	        System.out.println("--------------------------------------------------------");
	        System.out.println("GPA: " + report.getSgpa());
	        System.out.println("--------------------------------------------------------");
        }catch(Exception e) {
        	
        }

      } else if (option == 7) {

        System.out.println("All Notifications are");

        int studentId = stud.getStudentInstance().getUserID();

        NotificationImpl notificationImp = new NotificationImpl();

        List<Notification> notificationList = new ArrayList<Notification>();

        notificationList = notificationImp.getNotification(studentId);

        for (Notification n : notificationList) {

          System.out.println(n.getMessage());
        }

      } else if (option == 8) {

        stud.logout();
        break;
      } else {

        System.out.println("Enter valid Inputs");
      }

      printMenu();
      System.out.println("Your choice:");
      option = sc.nextInt();
    }    
  }
}
