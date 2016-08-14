package com.ge.tps.service.impl;

import com.ge.tps.dao.LiveSessionDao;
import com.ge.tps.dao.impl.LiveSessionDaoImpl;
import com.ge.tps.entities.LiveSession;
import com.ge.tps.service.LiveSessionService;

public class LiveSessionServiceImpl implements LiveSessionService {

	LiveSessionDao liveSessionDAO = new LiveSessionDaoImpl();

	@Override
	public LiveSession getLiveSession(String url) {
		return liveSessionDAO.getLiveSession(url);
	}

	@Override
	public LiveSession addLiveSessionComment(String url, String comment,
			long userId) {
		return liveSessionDAO.addLiveSessionComment(url, comment, userId);
	}

}