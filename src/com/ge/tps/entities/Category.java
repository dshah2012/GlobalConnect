package com.ge.tps.entities;
/**
 * 
 */


import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Category.
 *
 * @author Nikhil
 * @version 
 * @since 26-Feb-2016
 * @description 
 */
@Entity
public class Category {

	/** The category id. */
	//Instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long categoryId;

	
	/** The category name. */
	private String categoryName;

	/**
	 * Instantiates a new category.
	 */
	//Default Constructor	
	public Category() {
		super();
	}


	/**
	 * Instantiates a new category.
	 *
	 * @param categoryId the category id
	 * @param categoryName the category name
	 */
	public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	

	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	@Column
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



}