/**
 * 
 */
package com.flipkart.application;

//import com.flipkart.restController.AdminRestAPI;
//import com.flipkart.restController.CommonRestAPI;
//import com.flipkart.restController.ProfessorRestAPI;
import com.flipkart.restController.StudentRestAPI;
import org.apache.log4j.BasicConfigurator;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
	
	public ApplicationConfig() {
		// Register all the services over here.
		BasicConfigurator.configure();

//		register(AdminRestAPI.class);
//		register(CommonRestAPI.class);
//		register(ProfessorRestAPI.class);
		register(StudentRestAPI.class);
	}
}
