package com.ge.tps.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import com.ge.tps.enums.UserStatus;



// TODO: Auto-generated Javadoc
/**
 * The Class TPS_User.
 */
@Entity
public class User {
	
	/** The tps user id. */
	@Id
	@GeneratedValue
	private long userId;
	
	/** The primary mail id. */
	private String primaryMailId;
	
	/** The user name. */
	private String userName;
	
	/** The password. */
	private String password;
	
	/** The user status. */
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	
	/** The role. */
	@OneToOne
	@JoinColumn(name = "roleId")
	private Role role;
	
	/** The contact. */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "contactId")
	private Contact contact;
	
	/**
	 * Instantiates a new TP s_ user.
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new TP s_ user.
	 *
	 * @param primaryMailId the primary mail id
	 * @param userName the user name
	 * @param password the password
	 */
	public User(String primaryMailId, String userName, String password) {
		super();
		this.primaryMailId = primaryMailId;
		this.userName = userName;
		this.password = password;
	}


	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the primary mail id.
	 *
	 * @return the primary mail id
	 */
	public String getPrimaryMailId() {
		return primaryMailId;
	}

	/**
	 * Sets the primary mail id.
	 *
	 * @param primaryMailId the new primary mail id
	 */
	public void setPrimaryMailId(String primaryMailId) {
		this.primaryMailId = primaryMailId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user status.
	 *
	 * @return the user status
	 */
	public UserStatus getUserStatus() {
		return userStatus;
	}

	/**
	 * Sets the user status.
	 *
	 * @param userStatus the new user status
	 */
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}


	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 *
	 * @param contact the new contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
}
