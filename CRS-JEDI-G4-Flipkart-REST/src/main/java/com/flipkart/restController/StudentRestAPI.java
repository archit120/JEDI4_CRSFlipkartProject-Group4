///**
// *
// */
//package com.flipkart.restController;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.xml.crypto.URIReferenceException;
//
///**
// * @author anike
// *
// */
//@Path("/customerApi")
//public class StudentRestAPI {
//
//	// GET (Fetch) Implementation.
//	@GET
//	@Path("/customer")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Customer getCustomerDetails() {
//
//		//  We have to call all the services in the Rest layer with the respective methods.
//		//  client --- service ---- dao ----> SQL
//
//		Customer customer=new Customer();
//		customer.setCustomerId(101);
//		customer.setCustomerName("ABC");
//		customer.setCustomerAddress("Delhi");
//
//	   return customer;
//
//	}
//
//	@POST
//	@Path("/post")
//	@Consumes("application/json")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response createTrackInJSON(Customer customer) {
//        System.out.println("hit post service");
//
//        System.out.println("value of cid from UI " +customer.getCustomerId());
//        System.out.println("value of cname form UI" +customer.getCustomerName());
//
//        // Put customer details in service call
//        String result = "customer saved : " + customer;
//
//
//		return Response.status(201).entity(result).build();
//
//	}
//
//
//
//	@PUT
//	@Path("/update")
//	@Consumes("application/json")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Customer updateCustomer(Customer customer){
//
//		// rest of impl write here in code
//
//		customer.setCustomerName(customer.getCustomerName() +"updated");
//		return customer;
//
//	}
//
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
//
//
//}
