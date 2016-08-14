package com.ge.tps.entities;
/**
 * 
 */


import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Skill.
 *
 * @author Nikhil
 * @version 
 * @since 26-Feb-2016
 * @description 
 */
@Entity
public class Skill {
	
	//Instance variables
	

	/** The skill id. */
	private long skillId;
	
	/** The skill name. */
	private String skillName;
	
	/** The category. */
	private Category category;
	
	/**
	 * Instantiates a new skill.
	 */
	//Deafult Constructor
	public Skill() {
		super();
	}
	

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}
	/**
	 * Instantiates a new skill.
	 *
	 * @param skillName the skill name
	 * @param category the category
	 */
	public Skill(String skillName, Category category) {
		super();
		this.skillName = skillName;
		this.category = category;
	}


	/**
	 * Gets the skill id.
	 *
	 * @return the skill id
	 */
	//Getters and setters
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getSkillId() {
		return skillId;
	}
	
	/**
	 * Sets the skill id.
	 *
	 * @param skillId the new skill id
	 */
	
	
	/**
	 * Gets the skill name.
	 *
	 * @return the skill name
	 */
	@Column
	public String getSkillName() {
		return skillName;
	}
	
	/**
	 * Sets the skill name.
	 *
	 * @param skillName the new skill name
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId")
	public Category getCategory() {
		return category;
	}
	
	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
