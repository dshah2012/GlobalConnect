package com.ge.tps.dto;

import java.util.List;

public class LiveSessionDTO {
	private String url;
	private String description;
	private int noOfLikes;
	private List<CommentDTO> commentDTOs;

	
	public LiveSessionDTO(String url, String description) {
		super();
		this.url = url;
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getNoOfLikes() {
		return noOfLikes;
	}

	public void setNoOfLikes(int noOfLikes) {
		this.noOfLikes = noOfLikes;
	}

	public List<CommentDTO> getCommentDTOs() {
		return commentDTOs;
	}

	public void setCommentDTOs(List<CommentDTO> commentDTOs) {
		this.commentDTOs = commentDTOs;
	}

	
	@Override
	public String toString() {
		return "LiveSessionDTO [url=" + url + ", description=" + description + ", commentDTOs=" + commentDTOs + "]";
	}

	
}