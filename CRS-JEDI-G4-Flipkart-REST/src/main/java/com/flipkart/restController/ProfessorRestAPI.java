package com.flipkart.restController;


import com.flipkart.bean.Student;
import com.flipkart.service.ProfessorImpl;

import javax.activation.MimeType;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/professorApi")
public class ProfessorRestAPI {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public  boolean login(){

    }

    @GET
    @Path("/getEnrolledStudents/{prof-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getEnrolledStudents(@PathParam("prof-id") String profId){
        ProfessorImpl profImpl = new ProfessorImpl();
        return  profImpl.getEnrolledStudents(1,profId);

    }
}
