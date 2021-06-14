package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalogue;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.dao.CourseDao;
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
    System.out.println("2. ADD COURSE ");
    System.out.println("3. DROP COURSE ");
    System.out.println("4. PAY FEE");
    System.out.println("5. VIEW REGISTERED COURSES");
    System.out.println("6. View REPORT CARD");
    System.out.println("7. VIEW NOTIFICATIONS");
    System.out.println("8. LOGOUT");
    System.out.println("----------------------------------------------------");
  }

  /** Student menu. */
  public void StudentMenu() {

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
      if (stud.login(username, password)) break;
      System.out.println("Invalid login. Please retry.");
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
        for (Course course : courses) {
          System.out.println("\nCourse Details");
          System.out.println("Course code: " + course.getCourseCode());
          System.out.println("Course Description: " + course.getDescriptions());
          System.out.println("Course Department: " + course.getDepartment());
          System.out.println("Course Pre Requisites : " + course.getPreRequisites());
          //					if(course.getProfessor() != null)
          //						System.out.println("Course Professor : " + course.getProfessor().getName());
        }
      } else if (option == 2) {
        System.out.println("Enter course id code be added");
        Course c = courseImpl.findCourse(chosen, sc.next());
        stud.registerForCourse(chosenSem, c);

        System.out.println("Course registered");

      } else if (option == 3) {

        System.out.println("Enter course code to be dropped");
        regImpl.dropRegisteredCourse(regImpl.findRegisteredCourse(chosenSem, sc.next()));
        System.out.println("Course dropped");

      } else if (option == 4) {

        System.out.println("Payment options:-");

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

        paymentImpl.makePayment(p);

        System.out.println("Payment Done!");

        break;

      } else if (option == 5) {

        System.out.println("Registered Courses are");
        List<RegisteredCourse> registeredCourses = regImpl.findRegisteredCourses(chosenSem);
        System.out.println("Total " + registeredCourses.size() + " courses are registered for!");
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

        System.out.println("All Notification are");

        //         System.out.println("Payment options:-");

        //         System.out.println();

        //         System.out.println("Press 1 - Pay Online");

        //         System.out.println("Press 2 - Pay Offline");

        //         int option2 = sc.nextInt();

        //         String mode = "Online";

        //         if (option2 == 2) {

        //           mode = "Offline";
        //         }

        System.out.println("Enter your semseter registration id");

        int semesterRegisrationId = sc.nextInt();

        StudentImpl temp = new StudentImpl();

        int studentId = temp.getStudentInstance().getUserID();

        NotificationImpl paymentImpl = new NotificationImpl();

        List<Notification> notificationList = new ArrayList<Notification>();

        notificationList = paymentImpl.getNotification(studentId);

        for (Notification n : notificationList) {

          System.out.println(n.message);
        }

        break;

      } else if (option == 8) {
        stud.logout();
        break;
      } else {
        System.out.println(" Enter valid Inputs ");
      }
      printMenu();
      System.out.println("\n\n ENTER YOUR CHOICE \n\n");

      option = sc.nextInt();
    }
  }
}
