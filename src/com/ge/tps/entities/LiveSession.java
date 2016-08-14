package com.ge.tps.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class LiveSession.
 *
 * @author Abhishek
 * @version v1.0
 * @since 26-Feb-2016
 * @description
 */

@Entity
public class LiveSession {

	/** The live session id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long liveSessionId;

	/** The live session url. */
	private String liveSessionURL;

	/** The created date. */
	private Date createdDate;

	/** The start date. */
	private Date startDate;

	/** The description. */
	private String description;

	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	/** The session likes. */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "liveSessionId", referencedColumnName = "liveSessionId")
	private List<SessionLike> sessionLikes;

	/** The comments. */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "liveSessionId", referencedColumnName = "liveSessionId")
	private List<Comment> comments;

	/**
	 * Instantiates a new live session.
	 */
	public LiveSession() {
	}

	public LiveSession(String liveSessionURL, Date createdDate, Date startDate, String description) {
		super();
		this.liveSessionURL = liveSessionURL;
		this.createdDate = createdDate;
		this.startDate = startDate;
		this.description = description;
	}

	/**
	 * Gets the live session id.
	 *
	 * @return the live session id
	 */
	public long getLiveSessionId() {
		return liveSessionId;
	}

	/**
	 * Sets the live session id.
	 *
	 * @param liveSessionId
	 *            the new live session id
	 */
	public void setLiveSessionId(long liveSessionId) {
		this.liveSessionId = liveSessionId;
	}

	/**
	 * Gets the live session url.
	 *
	 * @return the live session url
	 */
	public String getLiveSessionURL() {
		return liveSessionURL;
	}

	/**
	 * Sets the live session url.
	 *
	 * @param liveSessionURL
	 *            the new live session url
	 */
	public void setLiveSessionURL(String liveSessionURL) {
		this.liveSessionURL = liveSessionURL;
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
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
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
	 * Sets the start date.
	 *
	 * @param startDate
	 *            the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the session likes.
	 *
	 * @return the session likes
	 */
	public List<SessionLike> getSessionLikes() {
		return sessionLikes;
	}

	/**
	 * Sets the session likes.
	 *
	 * @param sessionLikes
	 *            the new session likes
	 */
	public void setSessionLikes(List<SessionLike> sessionLikes) {
		this.sessionLikes = sessionLikes;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * Sets the comments.
	 *
	 * @param comments
	 *            the new comments
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
