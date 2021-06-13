
package com.flipkart.service;


import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDao;
public class PaymentImpl implements PaymentInterface{

	@Override
	public boolean makePayment(Payment payment) {

		return PaymentDao.makePayment(payment);
	}
}
