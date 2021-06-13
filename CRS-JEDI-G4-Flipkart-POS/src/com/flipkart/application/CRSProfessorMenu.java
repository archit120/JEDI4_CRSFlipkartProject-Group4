package com.flipkart.application;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.*;

public class CRSProfessorMenu {
	
	public static void showProfessorMenu() {
		
		System.out.println("-----------Professor Menu-----------");
		
		System.out.println("Press 1 - List the enrolled students");

		System.out.println("Press 2 - Mark student's grade");

		System.out.println("Press 3 - List of courses to teach");

		System.out.println("Press 4 - Register for course to teach");

		System.out.println("Press 5 - Logout");
		
		System.out.println("--------------------------------------");
	}


	public static void professorMenuHandler() {
		
		Scanner sc = new Scanner(System. in);
		CourseCatalogue chosen = new CourseCatalogueImpl().getCourseCatalogues().get(0);
//		CourseCatalogue chosen = new CourseCatalogue();
		
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
						List<Student> students = prof.getEnrolledStudents(chosen);
						System.out.println("Total " + students.size() +" students");
						for(Student s:students)
							System.out.println("Name: " + s.getName() + " Rollno: " + s.getRollNo());
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
						System.out.println("Total " + courses.size() +" courses found");
						for(Course course : courses) {
							System.out.println("\nCourse Details");
							System.out.println("CourseID: " + course.getCourseCode());
							System.out.println("Course Description: " + course.getDescriptions());
							System.out.println("Course Department: " + course.getDepartment());
							System.out.println("Course Pre Requisites : " + course.getPreRequisites());
							if(course.getProfessorId() == 0)
								System.out.println("This course is free to be taught by you!");
						}
						break;
					case 4:
						System.out.print("Enter Course ID of Course to teach: ");
						Course registerCourse = courseImpl.findCourse(chosen, sc.next());
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
			System.out.println(e);
		}
	}
}