/**
 * 
 */
package com.ge.tps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ge.tps.dao.SearchDao;
import com.ge.tps.dao.impl.SearchDaoImpl;
import com.ge.tps.dto.TrainerProfileDTOMain;
import com.ge.tps.service.SearchService;


/**
 * @author Uday
 * @description 
 * @since 03-Mar-2016
 * @version 
 */
public class SearchServiceImpl implements SearchService {

	/* (non-Javadoc)
	 * @see com.ge.tps.services.SearchService#getSearchResults(java.lang.String)
	 */
	@Override
	public Map<String, List<TrainerProfileDTOMain>> getSearchResults() {
		// TODO Auto-generated method stub
		SearchDao searchDaoImpl = new SearchDaoImpl();
		Map<String, List<TrainerProfileDTOMain>> searchMap = new HashMap<>();
		searchMap = searchDaoImpl.retrieve();
		return searchMap;
	}

}
