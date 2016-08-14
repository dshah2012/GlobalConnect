package com.ge.tps.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class Address.
 *
 * @author Nikhil Jain
 * @since 2016
 * @description The Class Address is used to store current,office,permanent
 *              address of a user
 * @version 1.0
 */
@Entity
public class Address {

	/** The address id. */
	@Id
	@GeneratedValue
	private long addressId;

	/** The property no of a user. */
	private String propertyNo;

	/** The street name no of a user. */
	private String streetName;

	/** The area name of a user. */
	private String areaName;

	/** The pincode no of a user. */
	private String pincode;

	/** The landmark of a user. */
	private String landmark;

	/** The location of user. */
	@Embedded
	private Location location;

	/**
	 * Instantiates a new address.
	 */
	public Address() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new address.
	 *
	 * @param propertyNo
	 *            the property no
	 * @param streetName
	 *            the street name
	 * @param areaName
	 *            the area name
	 * @param pincode
	 *            the pincode
	 * @param landmark
	 *            the landmark
	 * @param location
	 *            the location
	 */
	public Address(String propertyNo, String streetName, String areaName, String pincode, String landmark,
			Location location) {
		super();
		this.propertyNo = propertyNo;
		this.streetName = streetName;
		this.areaName = areaName;
		this.pincode = pincode;
		this.landmark = landmark;
		this.location = location;
	}

	/**
	 * Gets the address id.
	 *
	 * @return the address id
	 */
	public long getAddressId() {
		return addressId;
	}

	/**
	 * Sets the address id.
	 *
	 * @param addressId
	 *            the new address id
	 */
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	/**
	 * Gets the property no.
	 *
	 * @return the property no
	 */
	public String getPropertyNo() {
		return propertyNo;
	}

	/**
	 * Sets the property no.
	 *
	 * @param propertyNo
	 *            the new property no
	 */
	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}

	/**
	 * Gets the street name.
	 *
	 * @return the street name
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Sets the street name.
	 *
	 * @param streetName
	 *            the new street name
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Gets the area name.
	 *
	 * @return the area name
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * Sets the area name.
	 *
	 * @param areaName
	 *            the new area name
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * Gets the pincode.
	 *
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * Sets the pincode.
	 *
	 * @param pincode
	 *            the new pincode
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * Gets the landmark.
	 *
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * Sets the landmark.
	 *
	 * @param landmark
	 *            the new landmark
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
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

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", propertyNo=" + propertyNo + ", streetName=" + streetName
				+ ", areaName=" + areaName + ", pincode=" + pincode + ", landmark=" + landmark + ", location="
				+ location + "]";
	}
	

}
