package com.ge.tps.entities;


import java.util.Date;
import javax.persistence.*;
// TODO: Auto-generated Javadoc

import com.ge.tps.enums.ExperienceType;



/**
 * The Class RealTimeExperience.
 *
 * @author Nikhil
 * @version 
 * @since 26-Feb-2016
 * @description 
 */
@Entity
public class RealTimeExperience extends WorkExperience {
	
	/** The role name. */
	//Instance Variables
	private String roleName;
	
	/** The project title. */
	private String projectTitle;
	
	/** The project overview. */
	private String projectOverview;
	
	/** The project url. */
	private String projectUrl;
	
	/** The company name. */
	private String companyName;
	
	/**
	 * Instantiates a new real time experience.
	 */
	//Default Constructor
	public RealTimeExperience() {
		super();
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	
	
	/**
	 * Instantiates a new real time experience.
	 *
	 * @param roleName the role name
	 * @param projectTitle the project title
	 * @param projectOverview the project overview
	 * @param projectUrl the project url
	 * @param companyName the company name
	 */
	public RealTimeExperience(Date startDate, Date endDate, int totalMonths, String pocName,
			String pocContactNo, String description, boolean current, ExperienceType experienceType, Client client,
			String roleName, String projectTitle, String projectOverview, String projectUrl,
			String companyName) {
		super(startDate, endDate, totalMonths, pocName, pocContactNo, description,
				current, experienceType, client);
		this.roleName = roleName;
		this.projectTitle = projectTitle;
		this.projectOverview = projectOverview;
		this.projectUrl = projectUrl;
		this.companyName = companyName;
	}
	
	//Getters and setters
		@Column
		public String getRoleName() {
			return roleName;
		}
	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	/**
	 * Gets the project title.
	 *
	 * @return the project title
	 */
	@Column
	public String getProjectTitle() {
		return projectTitle;
	}
	
	/**
	 * Sets the project title.
	 *
	 * @param projectTitle the new project title
	 */
	@Column
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	
	/**
	 * Gets the project overview.
	 *
	 * @return the project overview
	 */
	@Column
	public String getProjectOverview() {
		return projectOverview;
	}
	
	/**
	 * Sets the project overview.
	 *
	 * @param projectOverview the new project overview
	 */
	public void setProjectOverview(String projectOverview) {
		this.projectOverview = projectOverview;
	}
	
	/**
	 * Gets the project url.
	 *
	 * @return the project url
	 */
	@Column
	public String getProjectUrl() {
		return projectUrl;
	}

	/**
	 * Sets the project url.
	 *
	 * @param projectUrl the new project url
	 */
	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}
	
	/**
	 * Gets the company name.
	 *
	 * @return the company name
	 */
	@Column
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Sets the company name.
	 *
	 * @param companyName the new company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
	

}
