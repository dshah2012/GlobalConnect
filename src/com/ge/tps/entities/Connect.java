package com.ge.tps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
public class Connect {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long connectId;
	
	private String reason;
	
	@Type(type = "yes_no")
	private boolean inPerson;
	private Date todayDate;
	private Date whenDate;
	private String description;
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}

	public Date getWhenDate() {
		return whenDate;
	}

	public void setWhenDate(Date whenDate) {
		this.whenDate = whenDate;
	}

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public boolean isInPerson() {
		return inPerson;
	}
	public void setInPerson(boolean inPerson) {
		this.inPerson = inPerson;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getConnectId() {
		return connectId;
	}

	@Override
	public String toString() {
		return "Connect [connectId=" + connectId + ", reason=" + reason
				+ ", inPerson=" + inPerson + ", todayDate=" + todayDate
				+ ", whenDate=" + whenDate + ", description=" + description
				+ ", userName=" + userName + "]";
	}
	
	
	
	
	

}
