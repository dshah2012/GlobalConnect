/**
 * 
 */
package com.ge.tps.entities;

/**
 * @author anil
 * @since 26-Feb-2016
 * @version
 */

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class LanguagesKnown.
 */
@Entity
public class LanguageKnown {

	/** The lang known id. */
	@Id
	@GeneratedValue
	private int langKnownId;

	/** The can read. */
	@Type(type = "yes_no")
	private boolean canRead;

	/** The can write. */
	@Type(type = "yes_no")
	private boolean canWrite;

	/** The can speak. */
	@Type(type = "yes_no")
	private boolean canSpeak;

	/** The language. */
	@ManyToOne(cascade = CascadeType.ALL)
	private SpokenLanguage spokenLanguage;

	/**
	 * Instantiates a new language known.
	 */
	public LanguageKnown() {

	}

	/**
	 * Instantiates a new language known.
	 *
	 * @param canRead
	 *            the can read
	 * @param canWrite
	 *            the can write
	 * @param canSpeak
	 *            the can speak
	 * @param spokenLanguage
	 *            the spoken language
	 */
	public LanguageKnown(boolean canRead, boolean canWrite, boolean canSpeak, SpokenLanguage spokenLanguage) {
		super();
		this.canRead = canRead;
		this.canWrite = canWrite;
		this.canSpeak = canSpeak;
		this.spokenLanguage = spokenLanguage;
	}

	/**
	 * Gets the lang known id.
	 *
	 * @return the lang known id
	 */
	public int getLangKnownId() {
		return langKnownId;
	}

	/**
	 * Sets the lang known id.
	 *
	 * @param langKnownId
	 *            the new lang known id
	 */
	public void setLangKnownId(int langKnownId) {
		this.langKnownId = langKnownId;
	}

	/**
	 * Checks if is can read.
	 *
	 * @return true, if is can read
	 */
	public boolean isCanRead() {
		return canRead;
	}

	/**
	 * Sets the can read.
	 *
	 * @param canRead
	 *            the new can read
	 */
	public void setCanRead(boolean canRead) {
		this.canRead = canRead;
	}

	/**
	 * Checks if is can write.
	 *
	 * @return true, if is can write
	 */
	public boolean isCanWrite() {
		return canWrite;
	}

	/**
	 * Sets the can write.
	 *
	 * @param canWrite
	 *            the new can write
	 */
	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}

	/**
	 * Checks if is can speak.
	 *
	 * @return true, if is can speak
	 */
	public boolean isCanSpeak() {
		return canSpeak;
	}

	/**
	 * Sets the can speak.
	 *
	 * @param canSpeak
	 *            the new can speak
	 */
	public void setCanSpeak(boolean canSpeak) {
		this.canSpeak = canSpeak;
	}

	/**
	 * Gets the spoken language.
	 *
	 * @return the spoken language
	 */
	public SpokenLanguage getSpokenLanguage() {
		return spokenLanguage;
	}

	/**
	 * Sets the spoken language.
	 *
	 * @param spokenLanguage
	 *            the new spoken language
	 */
	public void setSpokenLanguage(SpokenLanguage spokenLanguage) {
		this.spokenLanguage = spokenLanguage;
	}

}
