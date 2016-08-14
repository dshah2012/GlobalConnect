package com.ge.tps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Certificate.
 *
 * @author Shubh
 */
@Entity
public class Certificate {

	/** The certificate id. */
	@Id
	@GeneratedValue
	private int certificateId;
	
	/** The institution name. */
	private String institutionName;
	
	/** The certified date. */
	private Date certifiedDate;
	
	/** The grade. */
	private String grade;
	
	/** The certification name. */
	private String certificationName;
	
	/** The certificate url. */
	private String certificateUrl;

	/**
	 * Instantiates a new certificate.
	 */
	public Certificate() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new certificate.
	 *
	 * @param institutionName the institution name
	 * @param certifiedDate the certified date
	 * @param grade the grade
	 * @param certificationName the certification name
	 * @param certificateUrl the certificate url
	 */
	public Certificate(String institutionName,
			Date certifiedDate, String grade, String certificationName,
			String certificateUrl) {
		super();
		this.institutionName = institutionName;
		this.certifiedDate = certifiedDate;
		this.grade = grade;
		this.certificationName = certificationName;
		this.certificateUrl = certificateUrl;
	}

	/**
	 * Gets the certificate id.
	 *
	 * @return the certificate id
	 */
	public int getCertificateId() {
		return certificateId;
	}

	/**
	 * Sets the certificate id.
	 *
	 * @param certificateId the new certificate id
	 */
	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	/**
	 * Gets the institution name.
	 *
	 * @return the institution name
	 */
	public String getInstitutionName() {
		return institutionName;
	}

	/**
	 * Sets the institution name.
	 *
	 * @param institutionName the new institution name
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	/**
	 * Gets the certified date.
	 *
	 * @return the certified date
	 */
	public Date getCertifiedDate() {
		return certifiedDate;
	}

	/**
	 * Sets the certified date.
	 *
	 * @param certifiedDate the new certified date
	 */
	public void setCertifiedDate(Date certifiedDate) {
		this.certifiedDate = certifiedDate;
	}

	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * Gets the certification name.
	 *
	 * @return the certification name
	 */
	public String getCertificationName() {
		return certificationName;
	}

	/**
	 * Sets the certification name.
	 *
	 * @param certificationName the new certification name
	 */
	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	/**
	 * Gets the certificate url.
	 *
	 * @return the certificate url
	 */
	public String getCertificateUrl() {
		return certificateUrl;
	}

	/**
	 * Sets the certificate url.
	 *
	 * @param certificateUrl the new certificate url
	 */
	public void setCertificateUrl(String certificateUrl) {
		this.certificateUrl = certificateUrl;
	}

}
