package com.flipkart.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class Professor.
 */
public class Professor extends User{
	
	/** The emp ID. */
	private String empID;
	
	/** The dept. */
	private String dept;
	
	/**
	 * Gets the emp ID.
	 *
	 * @return the emp ID
	 */
	public String getEmpID() {
		return empID;
	}
	
	/**
	 * Sets the emp ID.
	 *
	 * @param empID the new emp ID
	 */
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	
	/**
	 * Gets the dept.
	 *
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	
	/**
	 * Sets the dept.
	 *
	 * @param dept the new dept
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
}
