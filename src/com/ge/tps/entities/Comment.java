/**
 * 
 */
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
 * The Class Comment.
 *
 * @author Abhishek
 * @version v1.01
 * @since 26-Feb-2016
 * @description
 */

@Entity
public class Comment {

	/** The comment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commentId;

	/** The created date. */
	private Date createdDate;

	/** The description. */
	private String description;

	/** The user. */
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	/**
	 * Instantiates a new comment.
	 */
	public Comment() {
	}

	/**
	 * Instantiates a new comment.
	 *
	 * @param createdDate
	 *            the created date
	 * @param description
	 *            the description
	 */
	public Comment(Date createdDate, String description) {
		super();
		this.createdDate = createdDate;
		this.description = description;
	}

	
	/**
	 * Instantiates a new comment.
	 *
	 * @param createdDate the created date
	 * @param description the description
	 * @param user the user
	 */
	public Comment(Date createdDate, String description, User user) {
		super();
		this.createdDate = createdDate;
		this.description = description;
		this.user = user;
	}

	/**
	 * Gets the comment id.
	 *
	 * @return the comment id
	 */
	public long getCommentId() {
		return commentId;
	}

	/**
	 * Sets the comment id.
	 *
	 * @param commentId
	 *            the new comment id
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
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

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", createdDate=" + createdDate + ", description=" + description
				+ ", user=" + user + "]";
	}

	
}
