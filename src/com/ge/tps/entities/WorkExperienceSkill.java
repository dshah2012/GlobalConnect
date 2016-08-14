package com.ge.tps.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkExperienceSkill.
 */
@Entity
public class WorkExperienceSkill {
	
	/** The work experience skill id. */
	@Id
	@GeneratedValue
	private long workExperienceSkillId;
	
	/** The skill duration in months. */
	private int skillDurationInMonths;
	
	/** The skill. */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "skillId")
	private Skill skill;
	
	/**
	 * Instantiates a new work experience skill.
	 */
	public WorkExperienceSkill() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new work experience skill.
	 *
	 * @param skillDurationInMonths the skill duration in months
	 * @param skill the skill
	 */
	public WorkExperienceSkill(int skillDurationInMonths, Skill skill) {
		super();
		this.skillDurationInMonths = skillDurationInMonths;
		this.skill = skill;
	}

	/**
	 * Gets the work experience skill id.
	 *
	 * @return the work experience skill id
	 */
	public long getWorkExperienceSkillId() {
		return workExperienceSkillId;
	}

	/**
	 * Sets the work experience skill id.
	 *
	 * @param workExperienceSkillId the new work experience skill id
	 */
	public void setWorkExperienceSkillId(long workExperienceSkillId) {
		this.workExperienceSkillId = workExperienceSkillId;
	}

	/**
	 * Gets the skill duration in months.
	 *
	 * @return the skill duration in months
	 */
	public int getSkillDurationInMonths() {
		return skillDurationInMonths;
	}

	/**
	 * Sets the skill duration in months.
	 *
	 * @param skillDurationInMonths the new skill duration in months
	 */
	public void setSkillDurationInMonths(int skillDurationInMonths) {
		this.skillDurationInMonths = skillDurationInMonths;
	}

	/**
	 * Gets the skill.
	 *
	 * @return the skill
	 */
	public Skill getSkill() {
		return skill;
	}

	/**
	 * Sets the skill.
	 *
	 * @param skill the new skill
	 */
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
