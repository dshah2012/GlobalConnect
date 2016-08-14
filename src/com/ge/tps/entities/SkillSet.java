package com.ge.tps.entities;
/**
 * 
 */

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SkillSet.
 *
 * @author Nikhil
 * @version
 * @since 26-Feb-2016
 * @description
 */
@Entity
public class SkillSet {

	/** The skill set id. */
	// Instance variables
	@Id
	@GeneratedValue
	private long skillSetId;



	/** The skill. */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skillId")
	private Skill skill;

	/**
	 * Instantiates a new skill set.
	 */
	public SkillSet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new skill set.
	 *
	 * @param skillSetId
	 *            the skill set id
	 * @param numberOfMonths
	 *            the number of months
	 * @param skill
	 *            the skill
	 */
	public SkillSet( Skill skill) {
		super();
		this.skill = skill;
	}

	/**
	 * Gets the skill set id.
	 *
	 * @return the skill set id
	 */
	// Getters and setters
	
	public long getSkillSetId() {
		return skillSetId;
	}

	/**
	 * Sets the skill set id.
	 *
	 * @param skillSetId
	 *            the new skill set id
	 */
	public void setSkillSetId(long skillSetId) {
		this.skillSetId = skillSetId;
	}

	/**
	 * Gets the number of months.
	 *
	 * @return the number of months
	 */
	
	/**
	 * Sets the number of months.
	 *
	 * @param numberOfMonths
	 *            the new number of months

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
	 * @param skill
	 *            the new skill
	 */
	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
