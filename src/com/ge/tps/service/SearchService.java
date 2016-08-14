/**
 * 
 */
package com.ge.tps.service;

import java.util.List;
import java.util.Map;

import com.ge.tps.dto.TrainerProfileDTOMain;



/**
 * @author Uday
 * @description 
 * @since 03-Mar-2016
 * @version 
 */
public interface SearchService {
	public Map<String, List<TrainerProfileDTOMain>> getSearchResults();
}
