package com.flipkart.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
public class Student extends User {
    
    /** The department. */
    private String department;
    
    /** The roll no. */
    private String rollNo;

    /**
     * Gets the department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department.
     *
     * @param department the new department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the roll no.
     *
     * @return the roll no
     */
    public String getRollNo() {
        return rollNo;
    }

    /**
     * Sets the roll no.
     *
     * @param rollNo the new roll no
     */
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
