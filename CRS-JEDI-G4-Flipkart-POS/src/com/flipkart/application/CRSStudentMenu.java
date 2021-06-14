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
import com.flipkart.exception.LoginFailedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.PaymentAlreadyDone;
import com.flipkart.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/** The Class CRSStudentMenu. */
public class CRSStudentMenu {

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
 * @throws CourseAlreadyFullException 
 * @throws LoginFailedException 
 * @throws StudentNotApprovedException 
 */
  public void StudentMenu() throws LoginFailedException, StudentNotApprovedException, CourseAlreadyFullException, CourseAlreadyRegisteredException {

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
      }
      catch(LoginFailedException e){
    	  System.out.println(e.getMessage());
    	  
      }
      catch(StudentNotApprovedException e1){
    	  System.out.println(e1.getMessage());
    	  
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
    } else
      chosenSem = semImpl.viewSemesterRegistrations(stud.getStudentInstance().getUserID()).get(0);

    while (true) {

      if (option == 1) {

        System.out.println("\n\n **********ALL THE AVAILABLE COURSES ARE********* \n\n");

        List<Course> courses = courseImpl.findCourses(chosen);
        System.out.println("Total " + courses.size() + " courses found");
        
        System.out.format("%25s%25s%25s%25s%n", "Course Code", "Course Description", "Course Department", "Course Prerequisites" );
        
        for (Course course : courses) {    
          System.out.format("%25s%25s%25s%25s%n",course.getCourseCode(), course.getDescriptions(), course.getDepartment(), course.getPreRequisites());         
        }
        
      } else if (option == 2) {
        System.out.println("Enter the course code you want to add");
        try {
        Course c = courseImpl.findCourse(chosen, sc.next());
        stud.registerForCourse(chosenSem, c);
        System.out.println("Course registered");
        }catch(CourseAlreadyRegisteredException e) {
        	System.out.println(e.getMessage());
        }
        	

      } else if (option == 3) {

        System.out.println("Enter course code to be dropped: ");
        regImpl.dropRegisteredCourse(regImpl.findRegisteredCourse(chosenSem, sc.next()));
        System.out.println("Course dropped");

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
        	 System.out.println("Payment Done!");
        }catch(PaymentAlreadyDone e){
        	System.out.println(e.getMessage());
        }
        

       

        break;

      } else if (option == 5) {

        System.out.println("Registered Courses are");
        List<RegisteredCourse> registeredCourses = regImpl.findRegisteredCourses(chosenSem);
        System.out.println("You have registered for a total of " + registeredCourses.size() + " courses.");
        for (RegisteredCourse registeredCourse : registeredCourses)
          System.out.println(CourseDao.getCourse(registeredCourse.getCourseId()).getCourseCode());

      } else if (option == 6) {

        System.out.println("Report Card");
        ReportCard report = stud.viewReportCard(chosenSem);

        for (int i = 0; i < report.getCourseCodes().size(); i++) {
      
          System.out.println(report.getCourseCodes().get(i) + "\t" + report.getGrades().get(i));
        
        }
        System.out.println("GPA: " + report.getSgpa());

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
      System.out.println("\n\n ENTER YOUR CHOICE \n\n");

      option = sc.nextInt();
    }    
  }
}
