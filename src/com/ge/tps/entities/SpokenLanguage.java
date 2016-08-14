/**
 * 
 */
package com.ge.tps.entities;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SpokenLanguage.
 *
 * @author anil
 * @version 
 * @since 26-Feb-2016
 */

@Entity
public class SpokenLanguage {

	/** The language id. */
	@Id
	@GeneratedValue
	private long languageId;

	/** The language name. */
	private String languageName;

	/**
	 * Instantiates a new spoken language.
	 */
	public SpokenLanguage() {

	}

	/**
	 * Instantiates a new spoken language.
	 *
	 * @param languageName the language name
	 */
	public SpokenLanguage(String languageName) {
		super();
		this.languageName = languageName;
	}

	/**
	 * Gets the language id.
	 *
	 * @return the language id
	 */
	public long getLanguageId() {
		return languageId;
	}

	/**
	 * Sets the language id.
	 *
	 * @param languageId the new language id
	 */
	public void setLanguageId(long languageId) {
		this.languageId = languageId;
	}

	/**
	 * Gets the language name.
	 *
	 * @return the language name
	 */
	public String getLanguageName() {
		return languageName;
	}

	/**
	 * Sets the language name.
	 *
	 * @param languageName the new language name
	 */
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

}