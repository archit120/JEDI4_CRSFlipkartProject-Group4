package com.flipkart.restController;
import com.flipkart.bean.*;
import com.flipkart.exception.LoginFailedException;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.CourseImpl;
import com.flipkart.service.StudentImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author amrit
 *
 */
@Path("/adminApi")
public class AdminRestAPI {

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("username") String username, @QueryParam("password") String password) throws LoginFailedException {

        try {
            return Response.status(200).entity((new AdminImpl()).login(username, password)).build();
        }
        catch (LoginFailedException e) {
            return Response.status(403).entity(e).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e).build();
        }
    }

    @POST
    @Path("/addCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(Course newCourse)
    {
        try {
            (new CourseImpl()).addCourse(newCourse);

            return Response.status(200).entity(newCourse.getId()).build();
        }
        catch (Exception e) {
            return Response.status(400).entity(e).build();
        }
    }

    @DELETE
    @Path("/removeCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeCourse(@QueryParam("courseCatalogueID") int courseCatalogueID, @QueryParam("courseCode") String courseCode) {

        // service query to perform the delete operation
        // implementation

        try {
            CourseCatalogue current = new CourseCatalogue();
            current.setId(courseCatalogueID);

            return Response.status(200).entity((new CourseImpl().removeCourse(current, courseCode))).build();
        } catch (Exception e) {

            return Response.status(400).entity(e).build();
        }
    }

    @POST
    @Path("/addProfessor")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfessor(Professor newProfessor) {


        try {
            new AdminImpl().addProfessor(newProfessor);
            return Response.status(200).entity(newProfessor.getUserID()).build();
        }
        catch (Exception e) {
            return Response.status(400).entity(e).build();
        }
    }

    @GET
    @Path("/getStudentListWaitingForApproval")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentListWaitingForApproval() {

        try {
            return Response.status(200).entity(new StudentImpl().getStudentsWaitingApprocal()).build();
        }
        catch (Exception e) {
            return Response.status(400).entity(e).build();
        }
    }
}