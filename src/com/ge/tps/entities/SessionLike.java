package com.ge.tps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class SessionLike.
 *
 * @author Abhishek
 * @version 1.0
 * @since 26-Feb-2016
 * @description
 */

@Entity
public class SessionLike {

	/** The session like id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sessionLikeId;

	/** The created date. */
	private Date createdDate;

//	/** The user. */
//	@OneToOne
//	@JoinColumn(name="userId")
//	private User user;

	/**
	 * Instantiates a new session like.
	 */
	public SessionLike() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Instantiates a new session like.
	 *
	 * @param createdDate the created date
	 */
	public SessionLike(Date createdDate) {
		super();
		this.createdDate = createdDate;
	}


	/**
	 * Instantiates a new session like.
	 *
	 * @param createdDate the created date
	 * @param user the user
	 */
	public SessionLike(Date createdDate, User user) {
		super();
		this.createdDate = createdDate;
//		this.user = user;
	}



	/**
	 * Gets the session like id.
	 *
	 * @return the session like id
	 */
	public long getSessionLikeId() {
		return sessionLikeId;
	}

	/**
	 * Sets the session like id.
	 *
	 * @param sessionLikeId
	 *            the new session like id
	 */
	public void setSessionLikeId(long sessionLikeId) {
		this.sessionLikeId = sessionLikeId;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate
	 *            the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

//	/**
//	 * Gets the user.
//	 *
//	 * @return the user
//	 */
//	public User getUser() {
//		return user;
//	}
//
//	/**
//	 * Sets the user.
//	 *
//	 * @param user the new user
//	 */
//	public void setUser(User user) {
//		this.user = user;
//	}

	
}
