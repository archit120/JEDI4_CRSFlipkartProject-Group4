package com.flipkart.bean;

// TODO: Auto-generated Javadoc
/** The Class OnlinePaymentMethod. */
public class OnlinePaymentMethod extends Payment {

  /** The bank name. */
  private String bankName;

  /** The acc no. */
  private int accNo;

  /**
   * Gets the bank name.
   *
   * @return the bank name
   */
  public String getBankName() {
    return bankName;
  }

  /**
   * Sets the bank name.
   *
   * @param bankName the new bank name
   */
  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  /**
   * Gets the acc no.
   *
   * @return the acc no
   */
  public int getAccNo() {
    return accNo;
  }

  /**
   * Sets the acc no.
   *
   * @param accNo the new acc no
   */
  public void setAccNo(int accNo) {
    this.accNo = accNo;
  }
}
