package com.flipkart.application;

import com.flipkart.bean.*;
import com.flipkart.exception.LoginFailedException;
import com.flipkart.service.*;
import java.util.List;
import java.util.Scanner;


// TODO: Auto-generated Javadoc
/** The Class CRSProfessorMenu. */
public class CRSProfessorMenu {

  /** Show professor menu. */
  public static void showProfessorMenu() {

    System.out.println("-----------Professor Menu-----------");

    System.out.println("Press 1 - List the enrolled students");

    System.out.println("Press 2 - Mark student's grade");

    System.out.println("Press 3 - List of courses to teach");

    System.out.println("Press 4 - Register for course to teach");

    System.out.println("Press 5 - Logout");

    System.out.println("--------------------------------------");
  }

  /** Professor menu handler. */
  public static void professorMenuHandler() throws LoginFailedException {

    Scanner sc = new Scanner(System.in);
    CourseCatalogue chosen = new CourseCatalogueImpl().getCourseCatalogues().get(0);
    //		CourseCatalogue chosen = new CourseCatalogue();

    try {
      ProfessorImpl prof = new ProfessorImpl();
      CourseImpl courseImpl = new CourseImpl();
      RegisteredCourseImpl regImpl = new RegisteredCourseImpl();
      CourseCatalogueImpl courseCatalogue = new CourseCatalogueImpl();
      while (true) {
        System.out.print("Enter prof username: ");
        String username = sc.next();
        System.out.print("Enter prof password: ");
        String password = sc.next();
        try {
        if (prof.login(username, password)) break;
        }
        catch(LoginFailedException e){
        	System.out.println(e.getMessage());
        }
        //throw new LoginFailedException(username);
        
        //System.out.println("Invalid login. Please retry.");
      }

      while (true) {

        CRSProfessorMenu.showProfessorMenu();

        int option = sc.nextInt();

        System.out.println();

        switch (option) {
          case 1:
            List<Student> students = prof.getEnrolledStudents(chosen);
            System.out.println("Total " + students.size() + " students");
            
            System.out.format("%25s%25s%n", "Name", "Roll Number");
            
            for (Student s : students)
            	System.out.format("%25s%25s%n", s.getName(), s.getRollNo());
            break;
          case 2:
            System.out.print("Enter Course code of Course to mark student: ");
            String courseCode = sc.next();
            System.out.print("Enter  student ID to mark student: ");
            String rollno = sc.next();
            System.out.print("Enter Grade as a single int (0-10): ");
            int g = sc.nextInt();
            Grade grade = new Grade();
            grade.setGrade(g);
            regImpl.markGrade(courseCode, chosen, rollno, grade);
            break;
          case 3:
            List<Course> courses = courseImpl.findCourses(chosen);
            System.out.println("Total " + courses.size() + " courses found");
            
            System.out.format("%25s%25s%25s%25s%25s%n", "Course Code", "Course Description", "Course Department", "Course Prerequisites", "Availability" );
            
            for (Course course : courses) {
            	System.out.format("%25s%25s%25s%25s%25s%n",course.getCourseCode(), course.getDescriptions(), course.getDepartment(), course.getPreRequisites(),(course.getProfessorId()==0) ? "Available" : "Not Available");
            }
            break;
          case 4:
            System.out.print("Enter Course code of Course to teach: ");
            Course registerCourse = courseImpl.findCourse(chosen, sc.next());
            if (registerCourse == null) System.out.println("Course not found!");
            else {
            	try {
            		courseImpl.indicateProfessor(registerCourse, ProfessorImpl.getProfessorInstance());
            	}catch (Exception e) {
            		System.out.println(e);
            	}
            }
            break;
          case 5:
            System.out.println("Successfully logged out");
            prof.logout();
            return;
          default:
            System.out.println("Invalid choice");
            break;
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
