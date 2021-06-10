/**
 * 
 */
package com.flipkart.service;
import java.util.Date;

/**
 * @author anike
 *
 */
public interface PaymentInterface {
	
	public boolean getDetails(int studentId,int billId, int amount,Date date);

}
