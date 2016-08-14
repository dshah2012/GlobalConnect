package com.ge.tps.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.ge.tps.enums.ExperienceType;


// TODO: Auto-generated Javadoc
/**
 * The Class WorkExperience.
 *
 * @author Nikhil
 * @version The Class WorkExperience.
 * @since 26-Feb-2016
 * @description
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WorkExperience {

	/** The experience id. */
	// Instance variables
	@Id
	@GeneratedValue
	private long workExperienceId;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/** The total months. */
	private int totalMonths;

	/** The poc name. */
	private String pocName;

	/** The poc contact no. */
	private String pocContactNo;

	/** The description. */
	private String description;

	/** The current. */
	private boolean current;

	/** The experience type. */
	private ExperienceType experienceType;

	/** The client. */
	@OneToOne(cascade = CascadeType.ALL)
	private Client client;

	/** The skill set. */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "workExperienceId")
	private Set<WorkExperienceSkill> workExperienceSkills = new HashSet<WorkExperienceSkill>();

	/**
	 * Instantiates a new work experience.
	 */
	// Default Constructor
	public WorkExperience() {

	}

	/**
	 * Instantiates a new work experience.
	 *
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @param totalMonths
	 *            the total months
	 * @param pocName
	 *            the poc name
	 * @param pocContactNo
	 *            the poc contact no
	 * @param description
	 *            the description
	 * @param current
	 *            the current
	 * @param experienceType
	 *            the experience type
	 * @param client
	 *            the client
	 */
	public WorkExperience(Date startDate, Date endDate, int totalMonths, String pocName, String pocContactNo,
			String description, boolean current, ExperienceType experienceType, Client client) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalMonths = totalMonths;
		this.pocName = pocName;
		this.pocContactNo = pocContactNo;
		this.description = description;
		this.current = current;
		this.experienceType = experienceType;
		this.client = client;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	@Column
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate
	 *            the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	@Column
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate
	 *            the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the total months.
	 *
	 * @return the total months
	 */
	@Column
	public int getTotalMonths() {
		return totalMonths;
	}

	/**
	 * Sets the total months.
	 *
	 * @param totalMonths
	 *            the new total months
	 */
	public void setTotalMonths(int totalMonths) {
		this.totalMonths = totalMonths;
	}

	/**
	 * Gets the poc name.
	 *
	 * @return the poc name
	 */
	@Column
	public String getPocName() {
		return pocName;
	}

	/**
	 * Sets the poc name.
	 *
	 * @param pocName
	 *            the new poc name
	 */
	public void setPocName(String pocName) {
		this.pocName = pocName;
	}

	/**
	 * Gets the poc contact no.
	 *
	 * @return the poc contact no
	 */
	@Column
	public String getPocContactNo() {
		return pocContactNo;
	}

	/**
	 * Sets the poc contact no.
	 *
	 * @param pocContactNo
	 *            the new poc contact no
	 */
	@Column
	public void setPocContactNo(String pocContactNo) {
		this.pocContactNo = pocContactNo;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@Column
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

	/**
	 * Checks if is current.
	 *
	 * @return true, if is current
	 */
	@Column(name = "isCurrent", columnDefinition = "tinyint default false")
	public boolean isCurrent() {
		return current;
	}

	/**
	 * Sets the current.
	 *
	 * @param iscurrent
	 *            the new current
	 */
	public void setCurrent(boolean iscurrent) {
		this.current = iscurrent;
	}

	/**
	 * Gets the experience type.
	 *
	 * @return the experience type
	 */
	@Enumerated(EnumType.STRING)
	public ExperienceType getExperienceType() {
		return experienceType;
	}

	/**
	 * Sets the experience type.
	 *
	 * @param experienceType
	 *            the new experience type
	 */
	public void setExperienceType(ExperienceType experienceType) {
		this.experienceType = experienceType;
	}

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 *
	 * @param client
	 *            the new client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Gets the work experience skills.
	 *
	 * @return the work experience skills
	 */
	public Set<WorkExperienceSkill> getWorkExperienceSkills() {
		return workExperienceSkills;
	}

	/**
	 * Sets the work experience skills.
	 *
	 * @param workExperienceSkills
	 *            the new work experience skills
	 */
	public void setWorkExperienceSkills(Set<WorkExperienceSkill> workExperienceSkills) {
		this.workExperienceSkills = workExperienceSkills;
	}

	/**
	 * Gets the work experience id.
	 *
	 * @return the work experience id
	 */
	public long getWorkExperienceId() {
		return workExperienceId;
	}

	/**
	 * Sets the work experience id.
	 *
	 * @param workExperienceId
	 *            the new work experience id
	 */
	public void setWorkExperienceId(long workExperienceId) {
		this.workExperienceId = workExperienceId;
	}

}
