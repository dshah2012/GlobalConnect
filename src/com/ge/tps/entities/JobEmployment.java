package com.ge.tps.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class JobEmployment.
 *
 * @author Kunal
 * @version 
 * @since 26-Feb-2016
 */
@Entity
public class JobEmployment {

	/** The job employment id. */
	@Id
	@GeneratedValue
	private long jobEmploymentId;
	
	/** The organization name. */
	private String organizationName;
	
	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;
	
	/** The salary package. */
	private int salaryPackage;
	
	/** The designation. */
	private String designation;
	
	/** The current. */
	@Type(type = "yes_no")
	private boolean current;
	
	/**
	 * Gets the employment id.
	 *
	 * @return the employmentId
	 */

	public long getEmploymentId() {
		return jobEmploymentId;
	}

	/**
	 * Sets the employment id.
	 *
	 * @param employmentId            the employmentId to set
	 */
	public void setEmploymentId(long employmentId) {
		this.jobEmploymentId = employmentId;
	}

	/**
	 * Gets the organization name.
	 *
	 * @return the organizationName
	 */

	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * Sets the organization name.
	 *
	 * @param organizationName            the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the startDate
	 */


	/**
	 * Gets the salary package.
	 *
	 * @return the salaryPackage
	 */

	public int getSalaryPackage() {
		return salaryPackage;
	}

	/**
	 * Sets the salary package.
	 *
	 * @param salaryPackage            the salaryPackage to set
	 */
	public void setSalaryPackage(int salaryPackage) {
		this.salaryPackage = salaryPackage;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */

	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Checks if is current.
	 *
	 * @return the isCurrent
	 */

	public boolean isCurrent() {
		return current;
	}

	/**
	 * Sets the current.
	 *
	 * @param current the new current
	 */
	public void setCurrent(boolean current) {
		this.current = current;
	}

	public long getJobEmploymentId() {
		return jobEmploymentId;
	}

	public void setJobEmploymentId(long jobEmploymentId) {
		this.jobEmploymentId = jobEmploymentId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

}
