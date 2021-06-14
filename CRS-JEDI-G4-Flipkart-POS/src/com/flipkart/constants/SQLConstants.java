package com.flipkart.constants;

public class SQLConstants {

    public static final String adminLogin = "Select * from admin where username=? and password=?";
    public static final String adminAdd= "INSERT INTO admin (name, email, username, password, empid) VALUES (?, ?,?,?,?)";
    public static final String adminList = "Select * from admin";

//    public static final String courseCatalogue
    public static final String courseCatalogueAdd = "INSERT INTO coursecatalogue (semester, year) VALUES (?,?)";
    public static final String courseCatalogueList = "SELECT * from courseCatalogue";
    public static final String getCourseIdfromCode = "Select id from course where courseCode=?";

    public static final String addCourse_check = "SELECT COUNT(*) as cnt from course where courseCode= ? and courseCatalogueId=?";
    public static final String addCourse = "INSERT INTO course (courseCode, department, description, preRequisites, courseCatalogueId,professorId) VALUES (?,?,?,?,?,?";
    public static final String removeCourse = "Delete from course where id=? ";
    public static final String getCoursePrefix = "select * from course where";
    public static final String markCourseToTeach = "UPDATE course SET professorId = ? where id = ?";

    public static final String makePayment_check = "SELECT COUNT(*) as cnt from payment where studentId= ? and semesterRegistrationId=?";
    public static final String makePayment = "INSERT INTO payment (mode, studentId , semesterRegistrationId ) VALUES (?,?,?)";

    public static final String professorLogin = "Select * from professor where username=? and password=?";
    public static final String addProfessor_check = "SELECT COUNT(*) as cnt from professor where empId= ?";
    public static final String addProfessor = "INSERT INTO professor (name, email, username, password,empId,department) VALUES (?, ?,?,?,?,?)";

    public static final String addRegisteredCourse_check = "SELECT COUNT(*) as cnt from registeredCourse where courseId= ? and studentId=?";
    public static final String addRegisteredCourse = "INSERT INTO registeredCourse (semesterRegistrationId, courseId, grade, studentId) VALUES (?, ?, ?, ?)";
    public static final String registerCoursePrefix = "select * from registeredcourse where ";
    public static final String deleteRegisteredCourse = "DELETE FROM registeredCourse where id = ?";
    public static final String getEnrolledStudent = "SELECT registeredCourse.studentId from registeredCourse, course where";
    public static final String getReportCard_GPA = "select avg(grade) as average from registeredcourse where semesterRegistrationId = ?";
    public static final String getRepoortCard = "select registeredcourse.courseId,registeredcourse.grade,course.courseCode from";
    public static final String setGradeStudent =
            "UPDATE registeredcourse SET grade = ? where  courseID = (select Id from course where"
                    + " courseCode=? and courseCatalogueId=?) and studentId = (select Id from student"
                    + " where rollno=?)";

    public static final String addSemesterRegistration = "INSERT INTO semesterregistration (semester, year, studentid) VALUES (?,?, ?)";
    public static final String getSemesterRegisrationsByStudentId = "select * from semesterregistration where studentid=";
    public static final String getSemesterRegistrations = "select * from semesterregistration";
    public static final String getCourseIdFromCode = "Select id from course where courseCode=?";

    public static final String studentLogin = "Select * from Student where username=? and password=?";
    public static final String addStudent_check = "SELECT COUNT(*) as cnt from student where username= ?";
    public static final String addStudent = "INSERT INTO student (name, email, username, password, rollno, department,isApproved) VALUES (?,"
            + " ?,?,?,?,?,?)";
    public static final String getStudentsFromId = "Select * from Student where id= ? ";
    public static final String getIdFromRollNo = "Select id from student where rollno=?";
    public static final String getStudentPendingApproval = "SELECT * FROM student where isApproved = ?";
    public static final String approveStudent_check = "select count(email)as count from student where isApproved = ? and email =?";
    public static final String approveStudent = "UPDATE student set isApproved = ? where email = ?";

}
