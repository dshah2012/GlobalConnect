package com.ge.tps.entities;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;



// TODO: Auto-generated Javadoc
/**
 * The Class Patent.
 */
@Entity
public class Patent {

	/** The patent id. */
	@Id
	@GeneratedValue
	private long patentId;

	/** The patent office. */
	private String patentOffice;

	/** The patent application number. */
	private long patentApplicationNo;

	/** The patent status issued. */
	private boolean patentStatusIssued;

	/** The title. */
	private String title;

	/** The date of issue. */
	private Date dateOfIssue;

	/** The patent url. */
	private String patentUrl;

	
	/** The description. */
	private String description;

	/**
	 * Instantiates a new patent.
	 */
	public Patent() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new patent.
	 *
	 * @param patentOffice
	 *            the patent office
	 * @param patentApplicationNo
	 *            the patent application no
	 * @param patentStatusIssued
	 *            the patent status issued
	 * @param title
	 *            the title
	 * @param dateOfIssue
	 *            the date of issue
	 * @param patentUrl
	 *            the patent url
	 * @param inventors
	 *            the inventors
	 * @param description
	 *            the description
	 */
	public Patent(String patentOffice, long patentApplicationNo, boolean patentStatusIssued, String title,
			Date dateOfIssue, String patentUrl,  String description) {
		super();
		this.patentOffice = patentOffice;
		this.patentApplicationNo = patentApplicationNo;
		this.patentStatusIssued = patentStatusIssued;
		this.title = title;
		this.dateOfIssue = dateOfIssue;
		this.patentUrl = patentUrl;
		
		this.description = description;
	}

	/**
	 * Gets the patent id.
	 *
	 * @return the patent id
	 */
	public long getPatentId() {
		return patentId;
	}

	/**
	 * Sets the patent id.
	 *
	 * @param patentId
	 *            the new patent id
	 */
	public void setPatentId(long patentId) {
		this.patentId = patentId;
	}

	/**
	 * Gets the patent office.
	 *
	 * @return the patent office
	 */
	public String getPatentOffice() {
		return patentOffice;
	}

	/**
	 * Sets the patent office.
	 *
	 * @param patentOffice
	 *            the new patent office
	 */
	public void setPatentOffice(String patentOffice) {
		this.patentOffice = patentOffice;
	}

	/**
	 * Checks if is patent status issued.
	 *
	 * @return true, if is patent status issued
	 */
	public boolean isPatentStatusIssued() {
		return patentStatusIssued;
	}

	/**
	 * Sets the patent status issued.
	 *
	 * @param patentStatusIssued
	 *            the new patent status issued
	 */
	public void setPatentStatusIssued(boolean patentStatusIssued) {
		this.patentStatusIssued = patentStatusIssued;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param dateOfIssue
	 *            the new date of issue
	 */
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	/**
	 * Gets the patent url.
	 *
	 * @return the patent url
	 */
	public String getPatentUrl() {
		return patentUrl;
	}

	/**
	 * Sets the patent url.
	 *
	 * @param patentUrl
	 *            the new patent url
	 */
	public void setPatentUrl(String patentUrl) {
		this.patentUrl = patentUrl;
	}

	/**
	 * Gets the patent application no.
	 *
	 * @return the patent application no
	 */
	public long getPatentApplicationNo() {
		return patentApplicationNo;
	}

	/**
	 * Sets the patent application no.
	 *
	 * @param patentApplicationNo
	 *            the new patent application no
	 */
	public void setPatentApplicationNo(long patentApplicationNo) {
		this.patentApplicationNo = patentApplicationNo;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
