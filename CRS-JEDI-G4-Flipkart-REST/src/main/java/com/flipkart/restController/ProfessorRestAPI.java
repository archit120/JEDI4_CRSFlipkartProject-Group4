package com.flipkart.restController;


import com.flipkart.bean.*;
import com.flipkart.exception.LoginFailedException;
import com.flipkart.service.CourseImpl;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.RegisteredCourseImpl;

import javax.activation.MimeType;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/professorApi")
public class ProfessorRestAPI {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response login(@FormParam("email") String username , @FormParam("password") String password){

        try{
            ProfessorImpl profImpl = new ProfessorImpl();

            boolean valid = profImpl.login(username,password);
            return Response.status(200).entity(valid).build();
        }catch (LoginFailedException e){
            return Response.status(403).entity(e.getMessage()).build();
        }catch (Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }

    }

    @GET
    @Path("/getEnrolledStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getEnrolledStudents(@QueryParam("profId") int profId,@QueryParam("courseCatalogueId") int courseCatalogueId){
        Professor prof = new Professor();
        prof.setUserID(profId);
        CourseCatalogue courseCatalogue = new CourseCatalogue();
        courseCatalogue.setId(courseCatalogueId);
        ProfessorImpl profImpl = new ProfessorImpl();

        return profImpl.getEnrolledStudents(courseCatalogue, prof);

    }

    @POST
    @Path("/markGrade")
    @Produces(MediaType.APPLICATION_JSON)
    public Response markGrade(@QueryParam("rollNumber") String rollNumber , @QueryParam("courseCode") String courseCode , @QueryParam("grade") int g, @QueryParam("courseCatalogueId") int courseCatalogueId){

        RegisteredCourseImpl regImpl = new RegisteredCourseImpl();
        CourseCatalogue catalog = new CourseCatalogue();
        catalog.setId(courseCatalogueId);
        Grade grade = new Grade();
        grade.setGrade(g);
        boolean marked = regImpl.markGrade(courseCode, catalog,rollNumber, grade);

        return Response.status(200).entity(marked).build();
    }

    @GET
    @Path("/availableCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAvailableCourses(@QueryParam("courseCatalogueId") int courseCatalogueId){
        CourseImpl courseImpl = new CourseImpl();
        CourseCatalogue catalogue = new CourseCatalogue();
        catalogue.setId(courseCatalogueId);
        return courseImpl.findCourses(catalogue);
    }

    @POST
    @Path("/teach")
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUpForCourse(@FormParam("profId") int profId , @FormParam("courseCode") int courseId){

        try {
            CourseImpl courseImpl = new CourseImpl();
            Professor p = new Professor();
            p.setUserID(profId);
            Course c = new Course();
            c.setId(courseId);
            boolean done = courseImpl.indicateProfessor(c,p);

            return Response.status(200).entity(done).build();
        } catch (Exception e) {

            //logger.error(e.getMessage());
            return Response.status(500).entity("something went wrong !").build();
        }
    }

    @GET
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(){

        ProfessorImpl profImpl = new ProfessorImpl();
        profImpl.logout();

        return  Response.status(200).entity("done").build();
    }


}
