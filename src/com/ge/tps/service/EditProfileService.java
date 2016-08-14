package com.ge.tps.service;


import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ge.tps.dao.EditProfileDao;
import com.ge.tps.dao.SaveProfileDao;
import com.ge.tps.dto.ContactInfoDto;
import com.ge.tps.dto.PersonalInfoDto;
import com.ge.tps.dto.RealTimeExperienceDto;
import com.ge.tps.dto.TrainingExperienceDto;
import com.ge.tps.dto.WorkExperienceSkillDto;
import com.ge.tps.entities.Category;
import com.ge.tps.entities.Certificate;
import com.ge.tps.entities.Client;
import com.ge.tps.entities.Education;
import com.ge.tps.entities.HonorAndAward;
import com.ge.tps.entities.JobEmployment;
import com.ge.tps.entities.LanguageKnown;
import com.ge.tps.entities.Patent;
import com.ge.tps.entities.PreferredContact;
import com.ge.tps.entities.RealTimeExperience;
import com.ge.tps.entities.Skill;
import com.ge.tps.entities.TrainingExperience;
import com.ge.tps.entities.WorkExperience;
import com.ge.tps.entities.WorkExperienceSkill;
import com.ge.tps.enums.ExperienceType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EditProfileService {
	EditProfileDao editProfileDao=new EditProfileDao();
	public boolean setAboutMe(long user_id,String aboutMe){
		boolean status=editProfileDao.editAboutMe(user_id, aboutMe);
		return status;
	}
	public boolean setPersonalInfo(long userId, String personalInfo) {
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
		System.out.println(personalInfo);
		PersonalInfoDto personalInfoDto=gson.fromJson(personalInfo, PersonalInfoDto.class);
		boolean status=editProfileDao.editPersonalInfo(userId,personalInfoDto);
		return status;
	}
	public boolean editEducationInfo(long userId, String educationInfoJson) {
		Gson gson=new GsonBuilder().create();
		System.out.println(educationInfoJson);
		Education education=gson.fromJson(educationInfoJson,Education.class);
		boolean status=editProfileDao.editEducationInfo(userId,education);
		return status;
	}
	
	public boolean setContactInfo(long userId, String contactInfo) {
		Gson gson=new GsonBuilder().create();
		System.out.println(contactInfo);
		ContactInfoDto contactInfoDto=gson.fromJson(contactInfo, ContactInfoDto.class);
		boolean status=editProfileDao.editContactInfo(userId,contactInfoDto);
		return status;
	}
	public boolean editCertificationInfo(long userId, String certificationJson) {
		// TODO Auto-generated method stub
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
		System.out.println(certificationJson);
		Certificate certificate=gson.fromJson(certificationJson,Certificate.class);
		boolean status=editProfileDao.editCertificateInfo(userId,certificate);
		return status;
	}
	public boolean editPatentInfo(long userId, String patentInfoJson) {
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
		System.out.println(patentInfoJson);
		Patent patent=gson.fromJson(patentInfoJson,Patent.class);
		boolean status=editProfileDao.editPatentInfo(userId,patent);
		return status;
	}
	public boolean editAwardInfo(long userId, String awardInfoJson) {
		
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
		System.out.println(awardInfoJson);
		HonorAndAward honorsAndAwards=gson.fromJson(awardInfoJson, HonorAndAward.class);
		boolean status=editProfileDao.editAwardInfo(userId,honorsAndAwards);
		return status;
	}
	public boolean editPreferredContact(long userId, String preferredInfoJson) {
		  Gson gson = new GsonBuilder().create();
		  System.out.println(preferredInfoJson);
		  PreferredContact preferredContact=gson.fromJson(preferredInfoJson, PreferredContact.class);
		  boolean status=editProfileDao.editPreferredContact(userId,preferredContact);
		  return status;
	}
	public List<LanguageKnown> editLanguage(long personalInfoId, String lanInfoJson) {
		// TODO Auto-generated method stub
		Gson gson=new GsonBuilder().create();
		System.out.println(lanInfoJson);
		LanguageKnown language=gson.fromJson(lanInfoJson, LanguageKnown.class);
		List<LanguageKnown> languageKnownList=editProfileDao.editLanguages(personalInfoId,language);
		return languageKnownList;
	}
	public boolean editJobEmployement(long userId, String jobInfoJson) {
		editProfileDao=new EditProfileDao();
		System.out.println("in edit TrainingExperience service");
		GsonBuilder gsonBuilder=new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd");
		Gson gson=gsonBuilder.create();
		System.out.println(jobInfoJson);
		JobEmployment jobEmployment=gson.fromJson(jobInfoJson, JobEmployment.class);
		boolean status=editProfileDao.editJobEmployement(userId,jobEmployment);
		return status;
	}
	public List<WorkExperience> editTrainingExperience(String trainingExpJson, long trainerId) {
		editProfileDao=new EditProfileDao();
		System.out.println("in edit TrainingExperience service");
		GsonBuilder gsonBuilder=new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd");
		Gson gson=gsonBuilder.create();
		TrainingExperienceDto trainingExperienceDto= gson.fromJson(trainingExpJson,TrainingExperienceDto.class);
		
		TrainingExperience trainingExperience=new TrainingExperience();
		Client trainerClient=new Client();
		trainerClient.setClientName(trainingExperienceDto.getClientName());
		trainerClient.setLogoUrl(trainingExperienceDto.getClientLogoUrl());
		trainingExperience.setWorkExperienceId(trainingExperienceDto.getTrainingExpId());
		trainingExperience.setClient(trainerClient);
		trainingExperience.setCurrent(trainingExperienceDto.isCurrent());
		trainingExperience.setDescription(trainingExperienceDto.getDescription());
		trainingExperience.setEndDate(trainingExperienceDto.getEndDate());
		trainingExperience.setEndTime(new GregorianCalendar(0,0,0,trainingExperienceDto.getEndTimeHour(),trainingExperienceDto.getEndTimeMinute(),0));
		trainingExperience.setExperienceType(ExperienceType.TRAINING);
		trainingExperience.setLocation(trainingExperienceDto.getLocationOfTrainer());
		trainingExperience.setPocContactNo(trainingExperienceDto.getPocContactNo());
		trainingExperience.setPocName(trainingExperienceDto.getPocName());
		trainingExperience.setStartDate(trainingExperienceDto.getStartDate());
		trainingExperience.setStartTime(new GregorianCalendar(0,0,0,trainingExperienceDto.getStartTimeHour(),trainingExperienceDto.getStartTimeMinute(),0));
		trainingExperience.setThroughvendor(trainingExperienceDto.isThroughvendor());
		trainingExperience.setTotalMonths(trainingExperienceDto.getTotalMonths());
		trainingExperience.setTrainingMode(trainingExperienceDto.getTrainingMode());
		trainingExperience.setTrainingType(trainingExperienceDto.getTrainingType());
		trainingExperience.setVendorName(trainingExperienceDto.getVendorName());
		
		
		Set<WorkExperienceSkill> workExperienceSkills=new HashSet<>();
		for (WorkExperienceSkillDto workExperienceSkillDto : trainingExperienceDto.getWorkExperienceSkillsdto()) {
			Category category=new Category();
			Skill skill=new Skill();
			WorkExperienceSkill workExperienceSkill=new WorkExperienceSkill();
			category.setCategoryName(workExperienceSkillDto.getCategoryName());
			skill.setSkillName(workExperienceSkillDto.getSkillName());
			skill.setCategory(category);
			workExperienceSkill.setSkill(skill);
			workExperienceSkill.setSkillDurationInMonths(workExperienceSkillDto.getSkillDurationInMonths());
			workExperienceSkills.add(workExperienceSkill);
		}
		
		
		trainingExperience.setWorkExperienceSkills(workExperienceSkills);
		List<WorkExperience> workExperiences=editProfileDao.editTrainingExperience(trainingExperience,trainerId);
		System.out.println("Converted Successfully");
		return workExperiences;
	}
	public List<WorkExperience> editRealTimeExperience(String realTimeExpJson, long trainerId) {
		// TODO Auto-generated method stub
		System.out.println("In EditRealTime Service");
		editProfileDao=new EditProfileDao();
		GsonBuilder gsonBuilder=new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd");
		Gson gson=gsonBuilder.create();
		RealTimeExperienceDto realTimeExperienceDto=gson.fromJson(realTimeExpJson, RealTimeExperienceDto.class); 
		
		
		RealTimeExperience realTimeExperience=new RealTimeExperience();
		realTimeExperience.setCompanyName(realTimeExperienceDto.getCompanyName());
		realTimeExperience.setDescription(realTimeExperienceDto.getDescription());
		realTimeExperience.setEndDate(realTimeExperienceDto.getEndDate());
		realTimeExperience.setCurrent(Boolean.parseBoolean(realTimeExperienceDto.getIsCurrent()));
		realTimeExperience.setPocName(realTimeExperienceDto.getPocName());
		realTimeExperience.setPocContactNo(realTimeExperienceDto.getPocContactNo());
		realTimeExperience.setExperienceType(ExperienceType.REAL_TIME);
		realTimeExperience.setProjectOverview(realTimeExperienceDto.getProjectOVerview());
		realTimeExperience.setProjectTitle(realTimeExperienceDto.getProjectTitle());
		realTimeExperience.setStartDate(realTimeExperienceDto.getStartDate());
		realTimeExperience.setRoleName(realTimeExperienceDto.getRoleName());
		realTimeExperience.setProjectUrl(realTimeExperienceDto.getProjectUrl());
		realTimeExperience.setWorkExperienceId(realTimeExperienceDto.getRealTimeExpId());
		System.out.println("WorkExperice--------------------" +realTimeExperience.getWorkExperienceId());
		
		
		
		Set<WorkExperienceSkill> workExperienceSkills=new HashSet<>();
		for (WorkExperienceSkillDto workExperienceSkillDto : realTimeExperienceDto.getWorkExperienceSkillsdto()) {
			Category category=new Category();
			Skill skill=new Skill();
			WorkExperienceSkill workExperienceSkill=new WorkExperienceSkill();
			category.setCategoryName(workExperienceSkillDto.getCategoryName());
			skill.setSkillName(workExperienceSkillDto.getSkillName());
			skill.setCategory(category);
			workExperienceSkill.setSkill(skill);
			workExperienceSkill.setSkillDurationInMonths(workExperienceSkillDto.getSkillDurationInMonths());
			workExperienceSkills.add(workExperienceSkill);
		}
		realTimeExperience.setWorkExperienceSkills(workExperienceSkills);

		List<WorkExperience> realTimeExperienceList=editProfileDao.editRealTimeExperiece(realTimeExperience,trainerId);
		
		return realTimeExperienceList;
	}
}
