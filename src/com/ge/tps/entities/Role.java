/**
 * 
 */
package com.ge.tps.entities;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Role.
 *
 * @author Suraj
 * @version
 * @since 26-Feb-2016
 * @description
 */

@Entity
public class Role {

	/** The role id. */
	private int roleId;

	/** The role name. */
	private String roleName;

	/**
	 * Instantiates a new role.
	 */
	public Role() {

	}

	/**
	 * Instantiates a new role.
	 *
	 * @param roleName
	 *            the role name
	 */
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	@Id
	@GeneratedValue
	@Column(name = "roleId")
	public int getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId
	 *            the new role id
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	@Column(name = "roleName", nullable = false, length = 250)
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName
	 *            the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
