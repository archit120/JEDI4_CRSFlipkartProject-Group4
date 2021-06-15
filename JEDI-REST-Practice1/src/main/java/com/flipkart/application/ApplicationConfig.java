/**
 * 
 */
package com.flipkart.application;

import org.glassfish.jersey.server.ResourceConfig;

import com.flipkart.restController.CustomerRestAPI;

public class ApplicationConfig extends ResourceConfig {
	
	public ApplicationConfig() {
		// Register all the services over here.
		
		register(CustomerRestAPI.class);
	}
}
