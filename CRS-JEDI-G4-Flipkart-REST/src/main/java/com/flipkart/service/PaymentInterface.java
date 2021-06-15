/** */
package com.flipkart.service;

import com.flipkart.bean.Payment;
import com.flipkart.exception.PaymentAlreadyDone;

// TODO: Auto-generated Javadoc
/**
 * The Interface PaymentInterface.
 *
 * @author anike
 */
public interface PaymentInterface {

  /**
   * Make payment.
   *
   * @param payment the payment
   * @return true, if successful
   */
  //	public boolean getDetails(int studentId,int billId, int amount,Date date);
  public boolean makePayment(Payment payment) throws PaymentAlreadyDone;
}
