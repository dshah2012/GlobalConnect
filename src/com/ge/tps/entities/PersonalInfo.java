/**
 * 
 */
package com.ge.tps.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.ge.tps.enums.Gender;
import com.ge.tps.enums.MaritalStatus;



// TODO: Auto-generated Javadoc
/**
 * The Class PersonalInfo.
 *
 * @author Saransh
 * @version
 * @since 26-Feb-2016
 */

@Entity
public class PersonalInfo {

	/** The personal info id. */
	@Id
	@GeneratedValue
	private long personalInfoId;

	/** The first name. */
	private String firstName;

	/** The middle name. */
	private String middleName;

	/** The last name. */
	private String lastName;

	/** The spouse name. */
	private String spouseName;

	/** The date of birth. */
	private Date dateOfBirth;

	/** The gender. */
	@Enumerated(EnumType.STRING)
	private Gender gender;

	/** The martial status. */
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalstatus;

	/** The languages known. */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "personalInfoId", referencedColumnName = "personalInfoId")
	private List<LanguageKnown> languagesknown = new ArrayList<>();

	/**
	 * Gets the personal info id.
	 *
	 * @return the personal info id
	 */
	public long getPersonalInfoId() {
		return personalInfoId;
	}

	/**
	 * Instantiates a new personal info.
	 */
	public PersonalInfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new personal info.
	 *
	 * @param firstName
	 *            the first name
	 * @param middleName
	 *            the middle name
	 * @param lastName
	 *            the last name
	 * @param spouseName
	 *            the spouse name
	 * @param dateOfBirth
	 *            the date of birth
	 * @param gender
	 *            the gender
	 * @param maritalstatus
	 *            the maritalstatus
	 */
	public PersonalInfo(String firstName, String middleName, String lastName, String spouseName, Date dateOfBirth,
			Gender gender, MaritalStatus maritalstatus) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.spouseName = spouseName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.maritalstatus = maritalstatus;
	}

	/**
	 * Sets the personal info id.
	 *
	 * @param personalInfoId
	 *            the new personal info id
	 */
	public void setPersonalInfoId(long personalInfoId) {
		this.personalInfoId = personalInfoId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 *
	 * @param middleName
	 *            the new middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the spouse name.
	 *
	 * @return the spouse name
	 */
	public String getSpouseName() {
		return spouseName;
	}

	/**
	 * Sets the spouse name.
	 *
	 * @param spouseName
	 *            the new spouse name
	 */
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	/**
	 * Gets the maritalstatus.
	 *
	 * @return the maritalstatus
	 */
	public MaritalStatus getMaritalstatus() {
		return maritalstatus;
	}

	/**
	 * Sets the maritalstatus.
	 *
	 * @param maritalstatus
	 *            the new maritalstatus
	 */
	public void setMaritalstatus(MaritalStatus maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender
	 *            the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth
	 *            the new date of birth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Gets the languagesknown.
	 *
	 * @return the languagesknown
	 */
	public List<LanguageKnown> getLanguagesknown() {
		return languagesknown;
	}

	/**
	 * Sets the languagesknown.
	 *
	 * @param languagesknown
	 *            the new languagesknown
	 */
	public void setLanguagesknown(List<LanguageKnown> languagesknown) {
		this.languagesknown = languagesknown;
	}

}