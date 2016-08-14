/**
 * 
 */
package com.ge.tps.dao;

import java.util.List;
import java.util.Map;

import com.ge.tps.dto.TrainerProfileDTOMain;


/**
 * @author Uday
 * @description 
 * @since 03-Mar-2016
 * @version 
 */
public interface SearchDao {

	/**
	 * @param searchQuery
	 * @return
	 */
	public Map<String, List<TrainerProfileDTOMain>> retrieve();
}
