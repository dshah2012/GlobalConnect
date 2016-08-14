package com.ge.tps.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ge.tps.enums.ExperienceType;

public class RealTimeExperienceDto {
	private long realTimeExpId;

	private Date startDate;

	private String projectUrl;

	 private List<WorkExperienceSkillDto> workExperienceSkillsdto=new ArrayList<>();

	private String experienceType;

	private String roleName;

	private Date endDate;

	private String pocContactNo;

	private String projectTitle;

	private String companyName;

	private String pocName;

	private String projectOVerview;

	private String description;

	private String isCurrent;

	private String totalMonths;

	public String getProjectUrl() {
		return projectUrl;
	}

	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}

	
	public List<WorkExperienceSkillDto> getWorkExperienceSkillsdto() {
		return workExperienceSkillsdto;
	}

	public void setWorkExperienceSkillsdto(List<WorkExperienceSkillDto> workExperienceSkillsdto) {
		this.workExperienceSkillsdto = workExperienceSkillsdto;
	}

	public String getExperienceType() {
		return experienceType;
	}

	public void setExperienceType(String experienceType) {
		this.experienceType = experienceType;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public String getPocContactNo() {
		return pocContactNo;
	}

	public void setPocContactNo(String pocContactNo) {
		this.pocContactNo = pocContactNo;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPocName() {
		return pocName;
	}

	public void setPocName(String pocName) {
		this.pocName = pocName;
	}

	public String getProjectOVerview() {
		return projectOVerview;
	}

	public void setProjectOVerview(String projectOVerview) {
		this.projectOVerview = projectOVerview;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(String isCurrent) {
		this.isCurrent = isCurrent;
	}

	public String getTotalMonths() {
		return totalMonths;
	}

	public void setTotalMonths(String totalMonths) {
		this.totalMonths = totalMonths;
	}

	public long getRealTimeExpId() {
		return realTimeExpId;
	}

	public void setRealTimeExpId(long realTimeExpId) {
		this.realTimeExpId = realTimeExpId;
	}

	
	
}
