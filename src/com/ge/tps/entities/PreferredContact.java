package com.ge.tps.entities;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ge.tps.enums.MethodOfContact;




/**
 * @author Nikhil Jain
 * @since 2016
 * @description Used to store preferred contact of  users
 */
@Entity
public class PreferredContact {
	
	/** The preferred contact id differentiates one preferred contact from another */
	@Id
	@GeneratedValue
	private int preferredContactId;
	
	/** The method of contact preferred by user */
	@Enumerated(EnumType.STRING)
	private MethodOfContact methodOfContact;
	
	/** The priority for method of contact */
	private int priority;
	
	
	/**
	 * 
	 */
	public PreferredContact() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @param methodOfContact
	 * @param priority
	 * @param contact
	 */
	public PreferredContact(MethodOfContact methodOfContact, int priority,
			Contact contact) {
		super();
		this.methodOfContact = methodOfContact;
		this.priority = priority;
		
	}



	/**
	 * Gets the preferred contact id.
	 *
	 * @return the preferred contact id
	 */
	public int getPreferredContactId() {
		return preferredContactId;
	}
	
	/**
	 * Sets the preferred contact id.
	 *
	 * @param preferredContactId the new preferred contact id
	 */
	public void setPreferredContactId(int preferredContactId) {
		this.preferredContactId = preferredContactId;
	}
	
	/**
	 * Gets the method of contact.
	 *
	 * @return the method of contact
	 */
	public MethodOfContact getMethodOfContact() {
		return methodOfContact;
	}
	
	/**
	 * Sets the method of contact.
	 *
	 * @param methodOfContact the new method of contact
	 */
	public void setMethodOfContact(MethodOfContact methodOfContact) {
		this.methodOfContact = methodOfContact;
	}
	
	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	
	/**
	 * Sets the priority.
	 *
	 * @param priority the new priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	


	
	
	
}
