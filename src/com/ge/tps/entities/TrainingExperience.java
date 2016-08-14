package com.ge.tps.entities;

import java.util.Calendar;

import java.util.Date;

import javax.persistence.*;
// TODO: Auto-generated Javadoc

import com.ge.tps.enums.ExperienceType;
import com.ge.tps.enums.TrainingMode;
import com.ge.tps.enums.TrainingType;



/**
 * The Class TrainingExperience.
 *
 * @author Nikhil
 * @version The Class WorkExperience.
 * @since 26-Feb-2016
 * @description 
 */

@Entity
public class TrainingExperience extends WorkExperience{
	
	/** The start time. */
	//Instance Variables
	private Calendar startTime;
	
	/** The end time. */
	private Calendar endTime;
	
	/** The location. */
	private String location;
	
	/** The throughvendor. */
	private boolean throughvendor;
	
	/** The vendor name. */
	private String vendorName;
	
	/** The training mode. */
	private TrainingMode trainingMode;
	
	/** The training type. */
	private TrainingType trainingType;
	
	/**
	 * Instantiates a new training experience.
	 */
	//Default Constructor
	public TrainingExperience() {
		super();
	}
	
	
	/**
	 * Instantiates a new training experience.
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param location the location
	 * @param throughvendor the throughvendor
	 * @param vendorName the vendor name
	 * @param trainingMode the training mode
	 * @param trainingType the training type
	 */
	public TrainingExperience( Date startDate, Date endDate, int totalMonths, String pocName,
			String pocContactNo, String description, boolean current, ExperienceType experienceType, Client client,
			Calendar startTime, Calendar endTime, String location, boolean throughvendor,
			String vendorName, TrainingMode trainingMode, TrainingType trainingType) {
		super(startDate, endDate, totalMonths, pocName, pocContactNo, description,
				current, experienceType, client);
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.throughvendor = throughvendor;
		this.vendorName = vendorName;
		this.trainingMode = trainingMode;
		this.trainingType = trainingType;
	}


	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	//Setters and getters
	@Column
	public Calendar getStartTime() {
		return startTime;
	}
	
	/**
	 * Sets the start time.
	 *
	 * @param startTime the new start time
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	@Column
	public Calendar getEndTime() {
		return endTime;
	}
	
	/**
	 * Sets the end time.
	 *
	 * @param endTime the new end time
	 */
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	@Column
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Gets the vendor name.
	 *
	 * @return the vendor name
	 */
	@Column
	public String getVendorName() {
		return vendorName;
	}
	
	/**
	 * Sets the vendor name.
	 *
	 * @param vendorName the new vendor name
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	/**
	 * Checks if is throughvendor.
	 *
	 * @return true, if is throughvendor
	 */
	@Column(name="isthroughVendor", columnDefinition = "tinyint default false")
	public boolean isThroughvendor() {
		return throughvendor;
	}


	/**
	 * Sets the throughvendor.
	 *
	 * @param isthroughvendor the new throughvendor
	 */
	public void setThroughvendor(boolean isthroughvendor) {
		this.throughvendor = isthroughvendor;
	}
	
	/**
	 * Gets the training mode.
	 *
	 * @return the training mode
	 */
	@Column
	public TrainingMode getTrainingMode() {
		return trainingMode;
	}


	/**
	 * Sets the training mode.
	 *
	 * @param trainingMode the new training mode
	 */
	public void setTrainingMode(TrainingMode trainingMode) {
		this.trainingMode = trainingMode;
	}
	
	/**
	 * Gets the training type.
	 *
	 * @return the training type
	 */
	@Column
	public TrainingType getTrainingType() {
		return trainingType;
	}


	/**
	 * Sets the training type.
	 *
	 * @param trainingType the new training type
	 */
	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}
	
	
}
