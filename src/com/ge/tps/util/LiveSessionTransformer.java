package com.ge.tps.util;

import java.util.ArrayList;
import java.util.List;

import com.ge.tps.dto.CommentDTO;
import com.ge.tps.dto.LiveSessionDTO;
import com.ge.tps.entities.Comment;
import com.ge.tps.entities.LiveSession;


public class LiveSessionTransformer {

	public LiveSessionDTO transform(LiveSession liveSession) {
		List<CommentDTO> commentDTOs = new ArrayList<>();
		for(Comment comment : liveSession.getComments() ){
			System.out.println("Comment : " + comment);
			commentDTOs.add(new CommentDTO(comment.getCreatedDate().getTime(), comment.getDescription(), comment.getUser().getUserName()));
		}
		LiveSessionDTO liveSessionDTO = new LiveSessionDTO(liveSession.getLiveSessionURL(), liveSession.getDescription());
		liveSessionDTO.setCommentDTOs(commentDTOs);
//		liveSessionDTO.setNoOfLikes(liveSession.getSessionLikes().size());
		liveSessionDTO.setNoOfLikes(0);
		return liveSessionDTO;
	}
	
}