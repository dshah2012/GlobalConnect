package com.ge.tps.dto;


public class CommentDTO {
	private long timeStamp;
	private String comment;
	private String user;

	
	public CommentDTO(long timeStamp, String comment, String user) {
		this.timeStamp = timeStamp;
		this.comment = comment;
		this.user = user;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CommentDTO [timeStamp=" + timeStamp + ", comment=" + comment + ", user=" + user + "]";
	}

	
}