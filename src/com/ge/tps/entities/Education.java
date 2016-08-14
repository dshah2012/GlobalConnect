package com.ge.tps.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Education.
 *
 * @author Sarang
 * @version
 * @since 26-Feb-2016
 */

@Entity
public class Education {

	/**
	 * Instantiates a new education.
	 */
	public Education() {
	}

	/** The education id. */
	@Id
	@GeneratedValue
	private long educationId;

	/** The course name. */
	private String courseName;

	/** The institute name. */
	private String instituteName;

	/** The field of study. */
	private String fieldOfStudy;

	/** The percentage. */
	private float percentage;

	/** The start year. */
	private int startYear;

	/** The course duration. */
	private int courseDuration;

	/** The board name. */
	private String boardName;

	/** The year of passing. */
	private int yearOfPassing;

	/** The location. */
	@Embedded
	private Location location;

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Instantiates a new education.
	 *
	 * @param courseName
	 *            the course name
	 * @param instituteName
	 *            the institute name
	 * @param fieldOfStudy
	 *            the field of study
	 * @param percentage
	 *            the percentage
	 * @param startYear
	 *            the start year
	 * @param courseDuration
	 *            the course duration
	 * @param boardName
	 *            the board name
	 * @param yearOfPassing
	 *            the year of passing
	 * @param location
	 *            the location
	 */
	public Education(String courseName, String instituteName, String fieldOfStudy, float percentage, int startYear,
			int courseDuration, String boardName, int yearOfPassing, Location location) {
		super();
		this.courseName = courseName;
		this.instituteName = instituteName;
		this.fieldOfStudy = fieldOfStudy;
		this.percentage = percentage;
		this.startYear = startYear;
		this.courseDuration = courseDuration;
		this.boardName = boardName;
		this.yearOfPassing = yearOfPassing;
		this.location = location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location
	 *            the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Gets the education id.
	 *
	 * @return the education id
	 */
	public long getEducationId() {
		return educationId;
	}

	/**
	 * Sets the education id.
	 *
	 * @param educationId
	 *            the new education id
	 */
	public void setEducationId(long educationId) {
		this.educationId = educationId;
	}

	/**
	 * Gets the course name.
	 *
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name.
	 *
	 * @param courseName
	 *            the new course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the institute name.
	 *
	 * @return the institute name
	 */
	public String getInstituteName() {
		return instituteName;
	}

	/**
	 * Sets the institute name.
	 *
	 * @param instituteName
	 *            the new institute name
	 */
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	/**
	 * Gets the field of study.
	 *
	 * @return the field of study
	 */
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	/**
	 * Sets the field of study.
	 *
	 * @param fieldOfStudy
	 *            the new field of study
	 */
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	/**
	 * Gets the percentage.
	 *
	 * @return the percentage
	 */
	public float getPercentage() {
		return percentage;
	}

	/**
	 * Sets the percentage.
	 *
	 * @param percentage
	 *            the new percentage
	 */
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	/**
	 * Gets the start year.
	 *
	 * @return the start year
	 */
	public int getStartYear() {
		return startYear;
	}

	/**
	 * Sets the start year.
	 *
	 * @param startYear
	 *            the new start year
	 */
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	/**
	 * Gets the course duration.
	 *
	 * @return the course duration
	 */
	public int getCourseDuration() {
		return courseDuration;
	}

	/**
	 * Sets the course duration.
	 *
	 * @param courseDuration
	 *            the new course duration
	 */
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	/**
	 * Gets the board name.
	 *
	 * @return the board name
	 */
	public String getBoardName() {
		return boardName;
	}

	/**
	 * Sets the board name.
	 *
	 * @param boardName
	 *            the new board name
	 */
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	/**
	 * Gets the year of passing.
	 *
	 * @return the year of passing
	 */
	public int getYearOfPassing() {
		return yearOfPassing;
	}

	/**
	 * Sets the year of passing.
	 *
	 * @param yearOfPassing
	 *            the new year of passing
	 */
	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
}
