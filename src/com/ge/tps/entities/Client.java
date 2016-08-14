package com.ge.tps.entities;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 *
 * @author Nikhil
 * @version 
 * @since 26-Feb-2016
 * @description 
 */
@Entity
public class Client {
	
	/** The client id. */
	//Instance variables
	private int clientId;
	
	/** The client name. */
	private String clientName;
	
	/** The logo url. */
	private String logoUrl;
	
	/**
	 * Instantiates a new client.
	 */
	//Default constructor	
	public Client() {
		super();
	}
	
	
	/**
	 * Instantiates a new client.
	 *
	 * @param clientId the client id
	 * @param clientName the client name
	 * @param logoUrl the logo url
	 */
	public Client(int clientId, String clientName, String logoUrl) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.logoUrl = logoUrl;
	}


	/**
	 * Gets the client id.
	 *
	 * @return the client id
	 */
	//Getters and setters
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getClientId() {
		return clientId;
	}
	
	/**
	 * Sets the client id.
	 *
	 * @param clientId the new client id
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	/**
	 * Gets the client name.
	 *
	 * @return the client name
	 */
	@Column
	public String getClientName() {
		return clientName;
	}
	
	/**
	 * Sets the client name.
	 *
	 * @param clientName the new client name
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	/**
	 * Gets the logo url.
	 *
	 * @return the logo url
	 */
	@Column
	public String getLogoUrl() {
		return logoUrl;
	}
	
	/**
	 * Sets the logo url.
	 *
	 * @param logoUrl the new logo url
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	

}
