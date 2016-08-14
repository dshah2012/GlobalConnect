package com.ge.tps.entities;

import javax.persistence.Embeddable;



/**
 * @author Nikhil Jain
 * @since 2016
 * @description Used to store location information of a particular address of a user
 */
@Embeddable
public class Location {
	
	/** The city of given address */
	private String city;
	
	/** The state of given address */
	private String state;
	
	/** The country of given address */
	private String country;
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	
	/**
	 * 
	 */
	public Location() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param city
	 * @param state
	 * @param country
	 */
	public Location(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}


	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
