package com.flipkart.exception;

public class PaymentAlreadyDone extends Exception {
	
	private String message;
	
	public PaymentAlreadyDone() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentAlreadyDone(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	

}
