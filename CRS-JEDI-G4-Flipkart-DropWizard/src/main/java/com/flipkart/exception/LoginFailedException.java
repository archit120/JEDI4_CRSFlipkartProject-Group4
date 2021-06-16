/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Shravya
 *
 */

public class LoginFailedException extends Exception{
	private String username;
	  public LoginFailedException(String username) {
	    this.username = username;
	  }
	 @Override
	  public String getMessage() {
	    return "Incorrect userID or password for the username: "+ this.username;
	  }

}
