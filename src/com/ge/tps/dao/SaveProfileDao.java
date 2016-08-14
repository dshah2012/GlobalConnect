package com.ge.tps.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.ge.tps.dto.RealTimeExperienceDto;
import com.ge.tps.entities.Category;
import com.ge.tps.entities.Certificate;
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
import com.ge.tps.entities.User;
import com.ge.tps.entities.WorkExperience;
import com.ge.tps.entities.WorkExperienceSkill;
import com.ge.tps.enums.ExperienceType;

public class SaveProfileDao {
	Configuration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	Session session = null;
	Transaction tx = null;
	
	
		public TrainerProfile getTrainer(long user_id){
		
		User user = (User) session.get(User.class, user_id);
		String hql = "FROM TrainerProfile tp WHERE tp.user =:user";
		Query query = session.createQuery(hql);
		query.setParameter("user",user);
		TrainerProfile trainer = (TrainerProfile) query.uniqueResult();
		return trainer;
		}
		public TrainerProfile getTrainerFromTrainerId(long trainerId){
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			String hql = "FROM TrainerProfile tp WHERE tp.trainerProfileId =:trainerProfileId";
			Query query = session.createQuery(hql);
			query.setParameter("trainerProfileId",trainerId);
			TrainerProfile trainer = (TrainerProfile) query.uniqueResult();
			tx.commit();
			session.close();
			return trainer;
		}
		
	public List<Education> addEducationInfo(Education education,long trainerId) {
		// TODO Auto-generated method stub
		System.out.println("save AddEDu");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		TrainerProfile trainerInfo=getTrainerFromTrainerId(trainerId);
		trainerInfo.getEducations().add(education);
		session.save(trainerInfo);
		List<Education> educationList=new ArrayList<>();
		String hql = "FROM Education WHERE trainerProfileId =:trainerId";
		Query query = session.createQuery(hql);
		query.setParameter("trainerId",trainerId);
		educationList=query.list();
		tx.commit();
		session.close();
		return educationList;
	}
public List<JobEmployment> addJobInfo(JobEmployment job, long trainerId) {
		
		System.out.println("save AddJob");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		TrainerProfile trainerInfo=getTrainerFromTrainerId(trainerId);
		trainerInfo.getJobEmployments().add(job);
		session.save(trainerInfo);
		List<JobEmployment> jobEmploymentList=new ArrayList<>();
		String hql = "FROM JobEmployment WHERE trainerProfileId =:trainerId";
		Query query = session.createQuery(hql);
		query.setParameter("trainerId",trainerId);
		jobEmploymentList=query.list();
		tx.commit();
		session.close();
		return jobEmploymentList;
		
		
	}

public List<Patent> addPatentInfo(Patent patent, long trainerId) {
	System.out.println("save PatentInfo");
	session=sessionFactory.openSession();
	tx = session.beginTransaction();
	TrainerProfile trainerInfo=getTrainerFromTrainerId(trainerId);
	trainerInfo.getPatents().add(patent);
	session.save(trainerInfo);
	List<Patent> patentsList=new ArrayList<>();
	String hql = "FROM Patent WHERE trainerProfileId =:trainerId";
	Query query = session.createQuery(hql);
	query.setParameter("trainerId",trainerId);
	patentsList=query.list();
	tx.commit();
	session.close();
	return patentsList;
	
}
public List<HonorAndAward> addAwardsInfo(HonorAndAward honorAndAwards, long trainerId) {
	// TODO Auto-generated method stub
	System.out.println("save AddHonor");
	session=sessionFactory.openSession();
	tx = session.beginTransaction();
	TrainerProfile trainerInfo=getTrainerFromTrainerId(trainerId);
	trainerInfo.getHonorAndAwards().add(honorAndAwards);
	session.save(trainerInfo);
	List<HonorAndAward> honorAndAwardsList=new ArrayList<>();
	String hql = "FROM HonorAndAward WHERE trainerProfileId =:trainerId";
	Query query = session.createQuery(hql);
	query.setParameter("trainerId",trainerId);
	honorAndAwardsList=query.list();
	tx.commit();
	session.close();
	return honorAndAwardsList;
}
public List<LanguageKnown> addLangInfo(LanguageKnown lang, long trainerId,long personalInfoId) {
	System.out.println("dao AddLanguage");
	session=sessionFactory.openSession();
	tx = session.beginTransaction();
	TrainerProfile trainer=getTrainerFromTrainerId(trainerId);
	trainer.getPersonalInfo().getLanguagesknown().add(lang);
	session.save(trainer);
	List<LanguageKnown> languageKnownList=null;
	String hql = "FROM LanguageKnown WHERE personalInfoId =:personalInfoId";
	Query query = session.createQuery(hql);
	query.setParameter("personalInfoId",personalInfoId);
	languageKnownList=query.list();
	tx.commit();
	session.close();
	return languageKnownList;
}

	public List<SkillSet> addSkillSet(SkillSet skillSet,long trainerId) {
		System.out.println("dao AddSkill");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		
		TrainerProfile trainer=getTrainerFromTrainerId(trainerId);
		trainer.getSkillset().add(skillSet);
		session.update(trainer);
		
		List<SkillSet> skillSetList=null;
		String hql = "FROM SkillSet WHERE trainerProfileId =:trainerProfileId";
		Query query = session.createQuery(hql);
		query.setParameter("trainerProfileId",trainerId);
		skillSetList= query.list();
		tx.commit();
		session.close();
		return skillSetList;
	//	return languageKnownList;
	
	}

	public Set<WorkExperience> addRealTimeExperiece(RealTimeExperience realTimeExperience, long trainerId) {
		// TODO Auto-generated method stub
		System.out.println("dao AddSkill");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		TrainerProfile trainer=getTrainerFromTrainerId(trainerId);
		
		trainer.getWorkExperiences().add(realTimeExperience);
		session.update(trainer);
		Set<WorkExperience>workExperienceList= trainer.getWorkExperiences();
		tx.commit();
		session.close();
		return workExperienceList;
	}
	public Set<WorkExperience> addTrainingExperience(TrainingExperience trainingExperience,
			TrainerProfile trainer) {
		
		System.out.println("dao add experience");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		trainer.getWorkExperiences().add(trainingExperience);
		session.update(trainer);
		tx.commit();
		session.close();
		return trainer.getWorkExperiences();
	}

	public void setPreferredContact(PreferredContact preferredContact,long userId) {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		TrainerProfile trainerInfo=getTrainerFromTrainerId(userId);
		trainerInfo.getUser().getContact().getPreferredContacts().add(preferredContact);
		session.update(trainerInfo);
		tx.commit();
		
	}
	public Contact addAddressInfo(TrainerProfile trainer,long contactId) {
		
		System.out.println("save address dao");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(trainer);
		String hql = "FROM Contact WHERE contactId =:contactId";
		Query query = session.createQuery(hql);
		query.setParameter("contactId",contactId);
		Contact contact=(Contact)query.uniqueResult();
		tx.commit();
		session.close();
		return contact;
		
	}
	public Set<Certificate> addCertificate(TrainerProfile trainer) {
		System.out.println("save certificate dao");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(trainer);
		tx.commit();
		session.close();
		return trainer.getCertificates();
	}
	public void setProfilePicUrl(TrainerProfile trainer) {
		// TODO Auto-generated method stub
		System.out.println("save ProFile Pic dao");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(trainer);
		tx.commit();
		session.close();
	}

	
}
