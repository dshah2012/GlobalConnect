package com.ge.tps.util;

import java.util.Collections;
import java.util.Comparator;

import com.ge.tps.entities.Comment;
import com.ge.tps.entities.LiveSession;


public class CustomSortUtil {

	public static void sortLiveSessionCommentsByDateTime(LiveSession liveSession) {

		Collections.sort(liveSession.getComments(),new Comparator<Comment>(){

			@Override
			public int compare(Comment comment1, Comment comment2) {
				return comment2.getCreatedDate().compareTo(comment1.getCreatedDate());
			}
			
		});
	}

}