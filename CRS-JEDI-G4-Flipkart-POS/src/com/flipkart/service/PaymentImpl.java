package com.flipkart.service;

import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDao;
// TODO: Auto-generated Javadoc

/** The Class PaymentImpl. */
public class PaymentImpl implements PaymentInterface {

  /**
   * Make payment.
   *
   * @param payment the payment
   * @return true, if successful
   */
  @Override
  public boolean makePayment(Payment payment) {

    return PaymentDao.makePayment(payment);
  }
}
