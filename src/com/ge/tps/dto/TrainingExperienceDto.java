package com.ge.tps.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ge.tps.entities.WorkExperience;
import com.ge.tps.entities.WorkExperienceSkill;
import com.ge.tps.enums.ExperienceType;
import com.ge.tps.enums.TrainingMode;
import com.ge.tps.enums.TrainingType;

public class TrainingExperienceDto {
	long trainingExpId;
	int startTimeHour;
	int startTimeMinute;
	int endTimeHour;
	int endTimeMinute;
	String locationOfTrainer;
	boolean throughvendor;
	String vendorName;
	TrainingMode trainingMode;
	TrainingType trainingType;
	Date startDate;
	Date endDate;
	int totalMonths;
	String pocName;
	String pocContactNo;
	String description;
	boolean isCurrent;
	ExperienceType experienceType;
	String clientName;
	String clientLogoUrl;
	List<WorkExperienceSkillDto> workExperienceSkillsdto=new ArrayList<>();
	public int getStartTimeHour() {
		return startTimeHour;
	}
	public void setStartTimeHour(int startTimeHour) {
		this.startTimeHour = startTimeHour;
	}
	public int getStartTimeMinute() {
		return startTimeMinute;
	}
	public void setStartTimeMinute(int startTimeMinute) {
		this.startTimeMinute = startTimeMinute;
	}
	public int getEndTimeHour() {
		return endTimeHour;
	}
	public void setEndTimeHour(int endTimeHour) {
		this.endTimeHour = endTimeHour;
	}
	public int getEndTimeMinute() {
		return endTimeMinute;
	}
	public void setEndTimeMinute(int endTimeMinute) {
		this.endTimeMinute = endTimeMinute;
	}
	
	public String getLocationOfTrainer() {
		return locationOfTrainer;
	}
	public void setLocationOfTrainer(String locationOfTrainer) {
		this.locationOfTrainer = locationOfTrainer;
	}
	public boolean isThroughvendor() {
		return throughvendor;
	}
	public void setThroughvendor(boolean throughvendor) {
		this.throughvendor = throughvendor;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public TrainingMode getTrainingMode() {
		return trainingMode;
	}
	public void setTrainingMode(TrainingMode trainingMode) {
		this.trainingMode = trainingMode;
	}
	public TrainingType getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTotalMonths() {
		return totalMonths;
	}
	public void setTotalMonths(int totalMonths) {
		this.totalMonths = totalMonths;
	}
	public String getPocName() {
		return pocName;
	}
	public void setPocName(String pocName) {
		this.pocName = pocName;
	}
	public String getPocContactNo() {
		return pocContactNo;
	}
	public void setPocContactNo(String pocContactNo) {
		this.pocContactNo = pocContactNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCurrent() {
		return isCurrent;
	}
	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	public ExperienceType getExperienceType() {
		return experienceType;
	}
	public void setExperienceType(ExperienceType experienceType) {
		this.experienceType = experienceType;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientLogoUrl() {
		return clientLogoUrl;
	}
	public void setClientLogoUrl(String clientLogoUrl) {
		this.clientLogoUrl = clientLogoUrl;
	}
	public List<WorkExperienceSkillDto> getWorkExperienceSkillsdto() {
		return workExperienceSkillsdto;
	}
	public void setWorkExperienceSkillsdto(
			List<WorkExperienceSkillDto> workExperienceSkillsdto) {
		this.workExperienceSkillsdto = workExperienceSkillsdto;
	}
	public long getTrainingExpId() {
		return trainingExpId;
	}
	public void setTrainingExpId(long trainingExpId) {
		this.trainingExpId = trainingExpId;
	}
	
	
	
}