package com.flipkart.service;

import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDao;
// TODO: Auto-generated Javadoc
import com.flipkart.exception.PaymentAlreadyDone;

/** The Class PaymentImpl. */
public class PaymentImpl implements PaymentInterface {

  /**
   * Make payment.
   *
   * @param payment the payment
   * @return true, if successful
   */
  @Override
  public boolean makePayment(Payment payment) throws PaymentAlreadyDone{

    boolean temp =  PaymentDao.makePayment(payment);
    
    if(temp == false) {
    	throw new PaymentAlreadyDone("Payment has already been done !!");
    }
    return true;
  
  }
}
