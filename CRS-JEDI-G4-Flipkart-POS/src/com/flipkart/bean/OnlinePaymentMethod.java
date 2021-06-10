package com.flipkart.bean;

public class OnlinePaymentMethod extends Payment{
	private String bankName;
	private int accNo;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
}
