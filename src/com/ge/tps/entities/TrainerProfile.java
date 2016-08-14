package com.ge.tps.entities;

import java.util.*;

import javax.persistence.*;

import com.ge.tps.enums.ProfileType;
import com.ge.tps.enums.Salutation;


// TODO: Auto-generated Javadoc
/**
 * The Class Profile.
 *
 * @author Anil
 * @version
 * @since 26-Feb-2016
 * @description
 */
@Entity
public class TrainerProfile {

	/** The profile id. */
	@Id
	@GeneratedValue
	private long trainerProfileId;

	/** The profile creation date. */
	private Date profileCreationDate;

	/** The about me. */
	private String aboutMe;

	/** The who am i. */
	private String whoAmI;

	/** The ready to relocate. */
	private boolean readyToRelocate;

	/** The profile pic url. */
	private String profilePicUrl;

	/** The resume url. */
	private String resumeUrl;

	/** The salutation. */
	@Enumerated(EnumType.STRING)
	private Salutation salutation;

	/** The profile type. */
	@Enumerated(EnumType.STRING)
	private ProfileType profileType;

	/** The personal info. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "personalInfoId")
	private PersonalInfo personalInfo;

	/** The job employments. */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "trainerProfileId")
	private Set<JobEmployment> jobEmployments = new HashSet<JobEmployment>();
	
	/** The educations. */
	//** The education. *//*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "trainerProfileId", referencedColumnName = "trainerProfileId")
	private Set<Education> educations = new HashSet<Education>();
	
	/** The skill set. */
	//** The skills. *//*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "trainerProfileId")
	private Set<SkillSet> skillset = new HashSet<SkillSet>();

	/** The work experiences. */
	//** The work experiences. *//*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "trainerProfileId")
	private Set<WorkExperience> workExperiences = new HashSet<WorkExperience>();
	
	/** The honor and awards. */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "trainerProfileId")
	private Set<HonorAndAward> honorAndAwards = new HashSet<HonorAndAward>();

	/** The patents. */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "trainerProfileId")
	private Set<Patent> patents = new HashSet<Patent>();
	
	/** The tps_ user. */
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "trainerProfileId",referencedColumnName = "trainerProfileId")
	private Set<Certificate> certificates=new HashSet<Certificate>();
	/**
	 * Instantiates a new profile.
	 */
	public TrainerProfile() {
		
	}

	public Set<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}

	/**
	 * Instantiates a new profile.
	 *
	 * @param profileCreationDate
	 *            the profile creation date
	 * @param aboutMe
	 *            the about me
	 * @param whoAmI
	 *            the who am i
	 * @param readyToRelocate
	 *            the ready to relocate
	 * @param profilePicUrl
	 *            the profile pic url
	 * @param resumeUrl
	 *            the resume url
	 * @param salutation
	 *            the salutation
	 * @param profileType
	 *            the profile type
	 */
	// parameterized constructor
	public TrainerProfile(Date profileCreationDate, String aboutMe, String whoAmI, boolean readyToRelocate,
			String profilePicUrl, String resumeUrl, Salutation salutation, ProfileType profileType) {
		this();
		this.profileCreationDate = profileCreationDate;
		this.aboutMe = aboutMe;
		this.whoAmI = whoAmI;
		this.readyToRelocate = readyToRelocate;
		this.profilePicUrl = profilePicUrl;
		this.resumeUrl = resumeUrl;
		this.salutation = salutation;
		this.profileType = profileType;
	}

	/**
	 * Gets the trainer profile id.
	 *
	 * @return the trainer profile id
	 */
	public long getTrainerProfileId() {
		return trainerProfileId;
	}

	/**
	 * Sets the trainer profile id.
	 *
	 * @param trainerProfileId
	 *            the new trainer profile id
	 */
	public void setTrainerProfileId(long trainerProfileId) {
		this.trainerProfileId = trainerProfileId;
	}

	/**
	 * Gets the profile id.
	 *
	 * @return the profile id
	 */
	// getter and setter methods
	public long getProfileId() {
		return trainerProfileId;
	}

	/**
	 * Sets the profile id.
	 *
	 * @param profileId
	 *            the new profile id
	 */
	public void setProfileId(long profileId) {
		this.trainerProfileId = profileId;
	}

	/**
	 * Gets the profile creation date.
	 *
	 * @return the profile creation date
	 */
	public Date getProfileCreationDate() {
		return profileCreationDate;
	}

	/**
	 * Sets the profile creation date.
	 *
	 * @param profileCreationDate
	 *            the new profile creation date
	 */
	public void setProfileCreationDate(Date profileCreationDate) {
		this.profileCreationDate = profileCreationDate;
	}

	/**
	 * Gets the about me.
	 *
	 * @return the about me
	 */
	public String getAboutMe() {
		return aboutMe;
	}

	/**
	 * Sets the about me.
	 *
	 * @param aboutMe
	 *            the new about me
	 */
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	/**
	 * Gets the who am i.
	 *
	 * @return the who am i
	 */
	public String getWhoAmI() {
		return whoAmI;
	}

	/**
	 * Sets the who am i.
	 *
	 * @param whoAmI
	 *            the new who am i
	 */
	public void setWhoAmI(String whoAmI) {
		this.whoAmI = whoAmI;
	}

	/**
	 * Checks if is ready to relocate.
	 *
	 * @return true, if is ready to relocate
	 */
	public boolean isReadyToRelocate() {
		return readyToRelocate;
	}

	/**
	 * Sets the ready to relocate.
	 *
	 * @param readyToRelocate
	 *            the new ready to relocate
	 */
	public void setReadyToRelocate(boolean readyToRelocate) {
		this.readyToRelocate = readyToRelocate;
	}

	/**
	 * Gets the profile pic url.
	 *
	 * @return the profile pic url
	 */
	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	/**
	 * Sets the profile pic url.
	 *
	 * @param profilePicUrl
	 *            the new profile pic url
	 */
	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

	/**
	 * Gets the resume url.
	 *
	 * @return the resume url
	 */
	public String getResumeUrl() {
		return resumeUrl;
	}

	/**
	 * Sets the resume url.
	 *
	 * @param resumeUrl
	 *            the new resume url
	 */
	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}

	/**
	 * Gets the salutation.
	 *
	 * @return the salutation
	 */
	public Salutation getSalutation() {
		return salutation;
	}

	/**
	 * Sets the salutation.
	 *
	 * @param salutation
	 *            the new salutation
	 */
	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}

	/**
	 * Gets the profile type.
	 *
	 * @return the profile type
	 */
	public ProfileType getProfileType() {
		return profileType;
	}

	/**
	 * Sets the profile type.
	 *
	 * @param profileType
	 *            the new profile type
	 */
	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}

	/**
	 * Gets the personal info.
	 *
	 * @return the personal info
	 */
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	/**
	 * Sets the personal info.
	 *
	 * @param personalInfo
	 *            the new personal info
	 */
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	/**
	 * Gets the job employment.
	 *
	 * @return the job employment
	 */
	public Set<JobEmployment> getJobEmployments() {
		return jobEmployments;
	}

	/**
	 * Sets the job employment.
	 *
	 * @param jobEmployment
	 *            the new job employment
	 */
	public void setJobEmployments(Set<JobEmployment> jobEmployment) {
		this.jobEmployments = jobEmployment;
	}

	/**
	 * Gets the education.
	 *
	 * @return the education
	 */
	public Set<Education> getEducations() {
		return educations;
	}

	/**
	 * Sets the education.
	 *
	 * @param educations
	 *            the new educations
	 */
	public void setEducations(Set<Education> educations) {
		this.educations = educations;
	}

	/**
	 * Gets the honor and awards.
	 *
	 * @return the honor and awards
	 */
	public Set<HonorAndAward> getHonorAndAwards() {
		return honorAndAwards;
	}

	/**
	 * Sets the honor and awards.
	 *
	 * @param honorAndAwards the new honor and awards
	 */
	public void setHonorAndAwards(Set<HonorAndAward> honorAndAwards) {
		this.honorAndAwards = honorAndAwards;
	}

	/**
	 * Gets the patents.
	 *
	 * @return the patents
	 */
	public Set<Patent> getPatents() {
		return patents;
	}

	/**
	 * Sets the patents.
	 *
	 * @param patents the new patents
	 */
	public void setPatents(Set<Patent> patents) {
		this.patents = patents;
	}

	


	

	public Set<SkillSet> getSkillset() {
		return skillset;
	}

	public void setSkillset(Set<SkillSet> skillset) {
		this.skillset = skillset;
	}

	/**
	 * Gets the work experiences.
	 *
	 * @return the work experiences
	 */
	public Set<WorkExperience> getWorkExperiences() {
		return workExperiences;
	}

	/**
	 * Sets the work experiences.
	 *
	 * @param workExperiences
	 *            the new work experiences
	 */
	public void setWorkExperiences(Set<WorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	

}
