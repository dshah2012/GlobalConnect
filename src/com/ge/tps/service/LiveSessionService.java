package com.ge.tps.service;

import com.ge.tps.entities.LiveSession;


public interface LiveSessionService {

	public LiveSession getLiveSession(String url);

	public LiveSession addLiveSessionComment(String url, String comment,long userId);

}
