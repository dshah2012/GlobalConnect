

package com.ge.tps.service;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ge.tps.dao.SaveProfileDao;
import com.ge.tps.dto.RealTimeExperienceDto;
import com.ge.tps.dto.TrainingExperienceDto;
import com.ge.tps.dto.WorkExperienceSkillDto;
import com.ge.tps.entities.Address;
import com.ge.tps.entities.Category;
import com.ge.tps.entities.Certificate;
import com.ge.tps.entities.Client;
import com.ge.tps.entities.Contact;
import com.ge.tps.entities.Education;
import com.ge.tps.entities.HonorAndAward;
import com.ge.tps.entities.JobEmployment;
import com.ge.tps.entities.LanguageKnown;
import com.ge.tps.entities.Patent;
import com.ge.tps.entities.PreferredContact;
import com.ge.tps.entities.RealTimeExperience;
import com.ge.tps.entities.Skill;
import com.ge.tps.entities.SkillSet;
import com.ge.tps.entities.TrainerProfile;
import com.ge.tps.entities.TrainingExperience;
import com.ge.tps.entities.WorkExperience;
import com.ge.tps.entities.WorkExperienceSkill;
import com.ge.tps.enums.ExperienceType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AddProfileInfoService {
	SaveProfileDao saveProfileDao=null;
	public List<Education> addEducation(Education education, long trainerId) {
		// TODO Auto-generated method stub
		System.out.println("Service AddEdu");
		saveProfileDao=new SaveProfileDao();
		List<Education>educationList=saveProfileDao.addEducationInfo(education,trainerId);
		return educationList;	
	}
	public List<JobEmployment> addEmployment(JobEmployment job, long trainerId) {
		System.out.println("Service AddJob");
		saveProfileDao=new SaveProfileDao();
		List<JobEmployment> jobEmploymentList=saveProfileDao.addJobInfo(job,trainerId);
		return jobEmploymentList;
	}
	
	public List<Patent> addPatent(Patent patent, long trainerId) {
		System.out.println("Service AddPatent");
		saveProfileDao=new SaveProfileDao();
		List<Patent> patentList=saveProfileDao.addPatentInfo(patent,trainerId);
		return patentList;
	}
	public List<HonorAndAward> addHonorAndAwards(HonorAndAward honorAndAwards, long trainerId) {
		// TODO Auto-generated method stub
		System.out.println("Service AddAwards");
		saveProfileDao=new SaveProfileDao();
		List<HonorAndAward> honorAndAwardsList=saveProfileDao.addAwardsInfo(honorAndAwards,trainerId);
		return honorAndAwardsList;
	}
	public List<LanguageKnown> addLanguage(LanguageKnown lang, long trainerId,long personalInfoId) {
		System.out.println("Service AddLanguage");
		saveProfileDao=new SaveProfileDao();
		List<LanguageKnown> languageKnownList=saveProfileDao.addLangInfo(lang,trainerId,personalInfoId);
		return languageKnownList;
	}
	public List<SkillSet> addSkillSet(String skillName, String categoryName,long trainerId) {
		saveProfileDao=new SaveProfileDao();
		System.out.println("In add SkillSet service");
		Category category=new Category();
		category.setCategoryName(categoryName);
		
		Skill skill=new Skill();
		skill.setSkillName(skillName);
		skill.setCategory(category);
		
		SkillSet skillSet=new SkillSet();
		skillSet.setSkill(skill);
		
		List<SkillSet> skillSetList=  saveProfileDao.addSkillSet(skillSet, trainerId);
		return skillSetList;
	}
	public Set<WorkExperience> addRealTimeExperience(String trainingExpJson, long trainerId) {
		// TODO Auto-generated method stub
		saveProfileDao=new SaveProfileDao();
		GsonBuilder gsonBuilder=new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd");
		Gson gson=gsonBuilder.create();
		RealTimeExperienceDto realTimeExperienceDto=gson.fromJson(trainingExpJson, RealTimeExperienceDto.class); 
		
		
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
		
		
		Set<WorkExperienceSkill> workExperienceSkills=new HashSet<>();
		for (WorkExperienceSkillDto workExperienceSkillDto : realTimeExperienceDto.getWorkExperienceSkillsdto()) {
			WorkExperienceSkill workExperienceSkill=new WorkExperienceSkill();
			Category category=new Category();
			Skill skill=new Skill();
			
			category.setCategoryName(workExperienceSkillDto.getCategoryName());
			skill.setSkillName(workExperienceSkillDto.getSkillName());
			skill.setCategory(category);
			workExperienceSkill.setSkill(skill);
			workExperienceSkill.setSkillDurationInMonths(workExperienceSkillDto.getSkillDurationInMonths());
			workExperienceSkills.add(workExperienceSkill);
		}
		realTimeExperience.setWorkExperienceSkills(workExperienceSkills);
		Set<WorkExperience> realTimeExperienceList=saveProfileDao.addRealTimeExperiece(realTimeExperience,trainerId);
		return realTimeExperienceList;
	}
	
	
public Set<WorkExperience> addTrainingExperience(String trainingExpJson, long trainerId) {
		
		saveProfileDao=new SaveProfileDao();
		System.out.println("in addTrainingExperience service");
		GsonBuilder gsonBuilder=new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd");
		Gson gson=gsonBuilder.create();
		TrainingExperienceDto trainingExperienceDto= gson.fromJson(trainingExpJson,TrainingExperienceDto.class);
		
		System.out.println("///////////////////////"+trainingExperienceDto.getWorkExperienceSkillsdto().size());
		
		TrainingExperience trainingExperience=new TrainingExperience();
		Client trainerClient=new Client();
		trainerClient.setClientName(trainingExperienceDto.getClientName());
		trainerClient.setLogoUrl(trainingExperienceDto.getClientLogoUrl());
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
		
		TrainerProfile trainer=saveProfileDao.getTrainerFromTrainerId(trainerId);
		trainingExperience.setWorkExperienceSkills(workExperienceSkills);
		//System.out.println("CHECK 123"+trainingExperience.getTrainingMode()+"  "+trainingExperienceDto.getTrainingMode());
		Set<WorkExperience> workExperiences=saveProfileDao.addTrainingExperience(trainingExperience,trainer);
		System.out.println("Converted Successfully");
		return workExperiences;
	}

public boolean setPreferredContact(String methodOfContact,long userId) {
	saveProfileDao=new SaveProfileDao();
	Gson gson = new Gson();
	PreferredContact preferredContact	=gson.fromJson(methodOfContact,PreferredContact.class);
	System.out.println("CHECK          "+preferredContact.getPreferredContactId());
	saveProfileDao.setPreferredContact(preferredContact, userId);
	return false;
}
public String addAddress(Address address, long trainerId,String addressType,long contactId) {
	System.out.println("Service Add addr");
	saveProfileDao=new SaveProfileDao();
	TrainerProfile trainer=saveProfileDao.getTrainerFromTrainerId(trainerId);
	System.out.println(addressType+"Check 12345");
	if(addressType.equals("Current")){
		trainer.getUser().getContact().setCurrentAddress(address);
	}else if(addressType.equals("Permanent")){
		trainer.getUser().getContact().setPermanentAddress(address);
		
	}else if(addressType.equals("Office")){
		trainer.getUser().getContact().setOfficeAddress(address);
		
	}
	Contact contact=saveProfileDao.addAddressInfo(trainer,contactId);
	Gson gson =new Gson();
	String contactJson=gson.toJson(contact);
	return contactJson;
}
public Set<Certificate> addCertificate(long trainerId, String addCertificateJson) {
	// TODO Auto-generated method stub
	saveProfileDao=new SaveProfileDao();
	GsonBuilder gsonBuilder=new GsonBuilder();
	gsonBuilder.setDateFormat("yyyy-MM-dd");
	Gson gson=gsonBuilder.create();
	Certificate certificate= gson.fromJson(addCertificateJson,Certificate.class);
	TrainerProfile trainer=saveProfileDao.getTrainerFromTrainerId(trainerId);
	trainer.getCertificates().add(certificate);
	Set<Certificate> certificateList=saveProfileDao.addCertificate(trainer);
	return certificateList;
} 
public void setProficePicUrl(String relativePath, long tpid) {
	// TODO Auto-generated method stub service 
	System.out.println("In Serevice Profile Pic URl");
	saveProfileDao=new SaveProfileDao();
	TrainerProfile trainer=saveProfileDao.getTrainerFromTrainerId(tpid);
	trainer.setProfilePicUrl(relativePath);
	saveProfileDao.setProfilePicUrl(trainer);
} 

}

