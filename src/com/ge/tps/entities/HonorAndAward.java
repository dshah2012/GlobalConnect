package com.ge.tps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class HonorAndAward.
 */

@Entity
public class HonorAndAward {
	
	/** The honor and award id. */
	@Id
	@GeneratedValue
	private long honorAndAwardId;
	
	/** The honor and award title. */
	private String honorAndAwardTitle;
	
	/** The issuer. */
	private String issuer;
	
	/** The occupation. */
	private String occupation;
	
	/** The date of issue. */
	private Date dateOfIssue;
	
	/**
	 * Instantiates a new honor and award.
	 */
	public HonorAndAward() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new honor and award.
	 *
	 * @param honorAndAwardTitle the honor and award title
	 * @param issuer the issuer
	 * @param occupation the occupation
	 * @param dateOfIssue the date of issue
	 */
	public HonorAndAward(String honorAndAwardTitle, String issuer, String occupation,
			Date dateOfIssue) {
		super();
		this.honorAndAwardTitle = honorAndAwardTitle;
		this.issuer = issuer;
		this.occupation = occupation;
		this.dateOfIssue = dateOfIssue;
	}


	/**
	 * Gets the honor and award id.
	 *
	 * @return the honor and award id
	 */
	public long getHonorAndAwardId() {
		return honorAndAwardId;
	}
	
	/**
	 * Sets the honor and award id.
	 *
	 * @param honorAndAwardId the new honor and award id
	 */
	public void setHonorAndAwardId(long honorAndAwardId) {
		this.honorAndAwardId = honorAndAwardId;
	}
	
	/**
	 * Gets the honor and award title.
	 *
	 * @return the honor and award title
	 */
	public String getHonorAndAwardTitle() {
		return honorAndAwardTitle;
	}
	
	/**
	 * Sets the honor and award title.
	 *
	 * @param honorAndAwardTitle the new honor and award title
	 */
	public void setHonorAndAwardTitle(String honorAndAwardTitle) {
		this.honorAndAwardTitle = honorAndAwardTitle;
	}
	
	/**
	 * Gets the issuer.
	 *
	 * @return the issuer
	 */
	public String getIssuer() {
		return issuer;
	}
	
	/**
	 * Sets the issuer.
	 *
	 * @param issuer the new issuer
	 */
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	
	/**
	 * Gets the occupation.
	 *
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	
	/**
	 * Sets the occupation.
	 *
	 * @param occupation the new occupation
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	/**
	 * Gets the date of issue.
	 *
	 * @return the date of issue
	 */
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	
	/**
	 * Sets the date of issue.
	 *
	 * @param dateOfIssue the new date of issue
	 */
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	
	
}
