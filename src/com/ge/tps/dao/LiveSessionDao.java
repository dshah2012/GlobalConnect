package com.ge.tps.dao;

import com.ge.tps.entities.LiveSession;

public interface LiveSessionDao {

	public LiveSession getLiveSession(String url);

	public LiveSession addLiveSessionComment(String url, String comment,
			long userId);
}
