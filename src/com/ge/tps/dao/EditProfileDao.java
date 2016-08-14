package com.ge.tps.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.ge.tps.dto.ContactInfoDto;
import com.ge.tps.dto.PersonalInfoDto;
import com.ge.tps.entities.Certificate;
import com.ge.tps.entities.Education;
import com.ge.tps.entities.HonorAndAward;
import com.ge.tps.entities.JobEmployment;
import com.ge.tps.entities.LanguageKnown;
import com.ge.tps.entities.Patent;
import com.ge.tps.entities.PreferredContact;
import com.ge.tps.entities.RealTimeExperience;
import com.ge.tps.entities.TrainerProfile;
import com.ge.tps.entities.TrainingExperience;
import com.ge.tps.entities.User;
import com.ge.tps.entities.WorkExperience;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EditProfileDao {
	Configuration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	Session session = null;
	Transaction tx = null;

	public boolean editAboutMe(long user_id, String aboutMe) {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		String hql = "update TrainerProfile tp set aboutMe=:about_Me WHERE tp.user.userId = :user_id";
		Query query = session.createQuery(hql);
		query.setParameter("about_Me", aboutMe);
		query.setParameter("user_id", user_id);
		int result=query.executeUpdate();
		System.out.println(result);
		tx.commit();
		session.close();
		return true;
	}
	
	public boolean editPersonalInfo(long userId, PersonalInfoDto personalInfoDto) {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		String hql1 = "update TrainerProfile tp set readyToRelocate=:ready WHERE tp.user.userId = :user_id";
		Query query = session.createQuery(hql1);
		System.out.println(personalInfoDto.isReadyToRelocate());
		query.setParameter("ready", personalInfoDto.isReadyToRelocate());
		query.setParameter("user_id", userId);
		int result=query.executeUpdate();
		System.out.println(result);
	
		
		String hql2 = "update PersonalInfo pi set firstName=:fn,middleName=:mn,lastName=:ln,gender=:gnd,maritalstatus=:ms,dateOfBirth=:dob,spouseName=:sn WHERE  pi.personalInfoId=:pid";
		Query query2=session.createQuery(hql2);
		System.out.println("TEST " +personalInfoDto.getMiddleName());
		query2.setParameter("fn",personalInfoDto.getFirstName());
		query2.setParameter("mn",personalInfoDto.getMiddleName());
		query2.setParameter("ln",personalInfoDto.getLastName());
		query2.setParameter("gnd",personalInfoDto.getGender());
		query2.setParameter("ms",personalInfoDto.getMaritalstatus());
		query2.setParameter("dob",personalInfoDto.getDateOfBirth());
		query2.setParameter("pid",personalInfoDto.getPersonalInfoId());
		query2.setParameter("sn",personalInfoDto.getSpouseName());
		System.out.println(query2.executeUpdate());
		tx.commit();
		session.close();
		return false;
	}

	public boolean editEducationInfo(long userId, Education education) {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(education);
		tx.commit();
		return true;
	}
	
	public boolean editContactInfo(long userId, ContactInfoDto contactInfoDto) {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		String hql = "update Contact ci set primaryMobileNo=:pmn,secondaryMobileNo=:smn,secondaryMailId=:sei,faxNo=:fn,residenceNo=:rn,officeContactNo=:ocn WHERE ci.contactId=:cid";
		Query query2=session.createQuery(hql);
		//System.out.println("TEST " +contactInfoDto.getMiddleName());
		query2.setParameter("cid",contactInfoDto.getContactId());
		query2.setParameter("pmn",contactInfoDto.getPrimaryMobileNo());
		query2.setParameter("smn",contactInfoDto.getSecondaryMobileNo());
		query2.setParameter("sei",contactInfoDto.getSecondaryMailId());
		query2.setParameter("fn",contactInfoDto.getFaxNo());
		query2.setParameter("rn",contactInfoDto.getResidenceNo());
		query2.setParameter("ocn",contactInfoDto.getOfficeContactNo());
		System.out.println(query2.executeUpdate());
		tx.commit();
		session.close();
		return false;
	}

	public boolean editCertificateInfo(long userId, Certificate certificate) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(certificate);
		tx.commit();
		session.close();
		return true;
		
	}

	public boolean editPatentInfo(long userId, Patent patent) {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(patent);
		tx.commit();
		session.close();
		return true;
	}

	public boolean editAwardInfo(long userId, HonorAndAward honorsAndAwards) {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(honorsAndAwards);
		tx.commit();
		session.close();
		return true;
	}

	public boolean editPreferredContact(long userId, PreferredContact preferredContact) {
		System.out.println("IN DAO");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		System.out.println(preferredContact.getPreferredContactId());
		System.out.println(preferredContact.getPriority());
		System.out.println(preferredContact.getMethodOfContact());
		session.update(preferredContact);
		tx.commit();
		session.close();
		System.out.println("DONE");
		return true;
	}
	public List<LanguageKnown> editLanguages(long personalInfoId, LanguageKnown language) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(language);
		String hql = "FROM LanguageKnown WHERE personalInfoId =:personalInfoId";
		Query query = session.createQuery(hql);
		query.setParameter("personalInfoId",personalInfoId);
		List<LanguageKnown> languageKnownList= query.list();
		tx.commit();
		session.close();
		return languageKnownList;
	}
	public boolean editJobEmployement(long userId, JobEmployment jobEmployment) {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(jobEmployment);
		tx.commit();
		return true;
	}
	public List<WorkExperience> editTrainingExperience(TrainingExperience trainingExperience,long trainerId) {
		System.out.println("dao edit experience");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(trainingExperience);
		String hql = "FROM WorkExperience WHERE trainerProfileId =:trainerProfileId";
		Query query = session.createQuery(hql);
		query.setParameter("trainerProfileId",trainerId);
		List<WorkExperience> workExperienceList= query.list();
		tx.commit();
		session.close();
		return workExperienceList;
	}
	public List<WorkExperience> editRealTimeExperiece(RealTimeExperience realTimeExperience, long trainerId) {
		// TODO Auto-generated method stub
		System.out.println("In EditRealTimeDao");
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(realTimeExperience);
		String hql = "FROM WorkExperience WHERE trainerProfileId =:trainerProfileId";
		Query query = session.createQuery(hql);
		query.setParameter("trainerProfileId",trainerId);
		List<WorkExperience>workExperienceList= query.list();
		tx.commit();
		session.close();
		return workExperienceList;
	}
}
