/**
 *
 */
package com.flipkart.restController;

import com.flipkart.bean.*;
import com.flipkart.dao.CourseDao;
import com.flipkart.dao.StudentDao;
import com.flipkart.exception.LoginFailedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anike
 *
 */
@Path("/studentApi")
public class StudentRestAPI {
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("username") String username, @QueryParam("password") String password) {
		try {
			return Response.status(200).entity((new StudentImpl()).login(username, password)).build();
		}
		catch (LoginFailedException e) {
			return Response.status(403).entity(e).build();
		}
		catch (StudentNotApprovedException e) {
			return Response.status(403).entity(e).build();
		}
		catch(Exception e) {
			return  Response.status(500).entity(e).build();
		}
	}

	// GET (Fetch) Implementation.
	@GET
	@Path("/getCourseCatalogues/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CourseCatalogue> getCourseCatalogues() {
		return (new CourseCatalogueImpl()).getCourseCatalogues();
	}

	@GET
	@Path("/viewSemesterRegistrations/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SemesterRegistration> viewSemesterRegistrations(@PathParam("id") int id) {
		return new SemesterRegistrationImpl().viewSemesterRegistrations(id);
	}

	@PUT
	@Path("/addSemesterRegistration")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public int updateCustomer(SemesterRegistration semesterRegistration){
		new SemesterRegistrationImpl().addSemesterRegistration(semesterRegistration);
		return semesterRegistration.getId();
	}

	@GET
	@Path("/findCourses/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> findCourses(@PathParam("id") int id) {
		CourseCatalogue temp = new CourseCatalogue();
		temp.setId(id);
		return new CourseImpl().findCourses(temp);
	}

	@GET
	@Path("/findCourse/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Course findCourse(@PathParam("id") int id, @QueryParam("coursecode") String coursecode) {
		CourseCatalogue temp = new CourseCatalogue();
		temp.setId(id);
		return new CourseImpl().findCourse(temp, coursecode);
	}

	@POST
	@Path("/registerForCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerForCourse(@QueryParam("studentid") int studentId,@QueryParam("semesterId") int semesterId, @QueryParam("courseid") int courseid) {
		SemesterRegistration temp = new SemesterRegistration();
		temp.setId(semesterId);
		Course cr = new Course();
		cr.setId(courseid);
		try {
			Boolean res = new StudentImpl().registerForCourse(studentId, temp, cr);
			return Response.status(200).entity(res).build();
		}
		catch (Exception e) {
			return Response.status(400).entity(e).build();
		}
	}

	@GET
	@Path("/findRegisteredCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findRegisteredCourse(@QueryParam("semesterRegistrationId") int semesterRegistrationId,@QueryParam("courseCode") String courseCode) {
		SemesterRegistration temp = new SemesterRegistration();
		temp.setId(semesterRegistrationId);
		try {
			RegisteredCourse res = new RegisteredCourseImpl().findRegisteredCourse(temp, courseCode);
			return Response.status(200).entity(res).build();
		}
		catch (Exception e) {
			return Response.status(400).entity(e).build();
		}
	}

	@GET
	@Path("/findRegisteredCourses")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findRegisteredCourses(@QueryParam("semesterRegistrationId") int semesterRegistrationId) {
		SemesterRegistration temp = new SemesterRegistration();
		temp.setId(semesterRegistrationId);
		try {
			return Response.status(200).entity(new RegisteredCourseImpl().findRegisteredCourses(temp)).build();
		}
		catch (Exception e) {
			return Response.status(400).entity(e).build();
		}
	}

	@DELETE
	@Path("/dropRegisteredCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropRegisteredCourse(@QueryParam("registeredCourseId") int registeredCourseId) {
		RegisteredCourse temp = new RegisteredCourse();
		temp.setId(registeredCourseId);
		try {
			Boolean res = new RegisteredCourseImpl().dropRegisteredCourse(temp);
			return Response.status(200).entity(res).build();
		}
		catch (Exception e) {
			return Response.status(400).entity(e).build();
		}
	}

	@PUT
	@Path("/makePayment")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response makePayment(Payment p) {
		try {
			Boolean res = new PaymentImpl().makePayment(p);
			return Response.status(200).entity(res).build();
		}
		catch (Exception e) {
			return Response.status(400).entity(e).build();
		}
	}

	@PUT
	@Path("/showNotification")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showNotification(@QueryParam("message") String message, @QueryParam("rollno") String rollno) {
		try {
			Boolean res = new NotificationImpl().showNotification(message, rollno);
			return Response.status(200).entity(res).build();
		}
		catch (Exception e) {
			return Response.status(400).entity(e).build();
		}
	}

	@GET
	@Path("/getCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourse(@QueryParam("id") int id) {
		try {
			return Response.status(200).entity(CourseDao.getCourse(id)).build();
		}
		catch (Exception e) {
			return Response.status(400).entity(e).build();
		}
	}

	@GET
	@Path("/getNotification")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotification(@QueryParam("id") int id) {
		try {
			return Response.status(200).entity(new NotificationImpl().getNotification(id)).build();
		}
		catch (Exception e) {
			return Response.status(400).entity(e).build();
		}
	}





//	@DELETE
//	@Path("/delete/{customerId}")
//	public Response deleteCustomer(@PathParam("customerId") int customerId)
//	throws URIReferenceException{
//
//		// service query to perfomr the delete operation
//
//		// implementation
//		return Response.status(200).entity("Track id " +customerId +
//				"successfully deleted").build();
//
//
//	}


}
