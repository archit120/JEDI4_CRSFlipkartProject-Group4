package com.flipkart.application;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.*;

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
		CourseCatalogue chosen = new CourseCatalogueImpl().getCourseCatalogues().get(0);
		try {
			ProfessorImpl prof = new ProfessorImpl();
			CourseImpl courseImpl = new CourseImpl();
			RegisteredCourseImpl regImpl = new RegisteredCourseImpl();
			CourseCatalogueImpl courseCatalogue = new CourseCatalogueImpl();
			while(true) {
				System.out.print("Enter prof username: ");
				String username = sc.next();
				System.out.print("Enter prof password: ");
				String password = sc.next();
				if(prof.login(username, password))
					break;
				System.out.println("Invalid login. Please retry.");
			}

			while(true) {
				
				CRSProfessorMenu.showProfessorMenu();
				
			    int option = sc.nextInt();
				
				System.out.println();
				
				switch(option) {
				
					case 1:
						System.out.print("Enter Course ID of Course to list students: ");
						Course registerCourse = courseImpl.findCourse(chosen, sc.next());
						List<Student> students = regImpl.viewEnrolledStudents(registerCourse);
						System.out.println("Total " + students.size() +" students");
						for(Student s:students)
							System.out.println("Name: " + s.getName() + " Rollno: " + s.getRollNo());
						break;
					case 2:
						System.out.print("Enter Course ID of Course to mark student: ");
						String courseId = sc.next();
						System.out.print("Enter rollno of student to mark student: ");
						String rollno = sc.next();
						System.out.print("Enter Grade as a single char (A,..,F): ");
						String g = sc.next();
						Grade gr = new Grade();
						gr.setLetterGrade(g);
						regImpl.markGrade(courseId, chosen, rollno, gr);
						break;
					case 3:
						List<Course> courses = courseImpl.findCourses(chosen);
						System.out.println("Total " + courses.size() +" courses found");
						for(Course course : courses) {
							System.out.println("\nCourse Details");
							System.out.println("CourseID: " + course.getCourseID());
							System.out.println("Course Description: " + course.getDescriptions());
							System.out.println("Course Department: " + course.getDepartment());
							System.out.println("Course Pre Requisites : " + course.getPreRequisites());
							if(course.getProfessor() == null)
								System.out.println("This course is free to be taught by you!");
						}
						break;
					case 4:
						System.out.print("Enter Course ID of Course to teach: ");
						registerCourse = courseImpl.findCourse(chosen, sc.next());
						if(registerCourse == null)
							System.out.println("Course not found!");
						else {
							if(courseImpl.indicateProfessor(registerCourse, ProfessorImpl.getProfessorInstance()))
								System.out.println("Course marked successfully!");
							else
								System.out.println("Unknown error while marking course!");
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
			
		}
	}
}