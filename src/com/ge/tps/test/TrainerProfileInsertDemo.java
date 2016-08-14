package com.ge.tps.test;

import java.util.ArrayList;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


import com.ge.tps.entities.*;
import com.ge.tps.enums.*;

public class TrainerProfileInsertDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args0) throws InterruptedException {
		Configuration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		
		loadAbhishekData(sessionFactory);
		loadDarshanData(sessionFactory);
		loadSarangData(sessionFactory);
		loadNikhilJainData(sessionFactory);
		loadVikasData(sessionFactory);
		loadMragankData(sessionFactory);
		loadSaranshData(sessionFactory);
		loadSurajData(sessionFactory);
		loadKunalData(sessionFactory);
		loadRahulData(sessionFactory);
		loadShubhData(sessionFactory);
		loadNikhilHAData(sessionFactory);
		loadUdayData(sessionFactory);
		loadAnilData(sessionFactory);
		//System.out.println(tp);
	}

	private static void loadAnilData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadUdayData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadNikhilHAData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadShubhData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadRahulData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadKunalData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadSurajData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadSaranshData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadMragankData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadVikasData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadNikhilJainData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadSarangData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadDarshanData(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		
	}

	private static void loadAbhishekData(SessionFactory sessionFactory) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		TrainerProfile trainerProfile = new TrainerProfile(new Date(), "About Me", "Who am I", true, "profileUrl1",
				"resumeUrl", Salutation.DR, ProfileType.TRAINER);

		SpokenLanguage spokenLanguage1 = new SpokenLanguage("English");
		SpokenLanguage spokenLanguage2 = new SpokenLanguage("Hindi");
		LanguageKnown languageKnown1 = new LanguageKnown(true, true, true, spokenLanguage1);
		LanguageKnown languageKnown2 = new LanguageKnown(true, true, true, spokenLanguage2);
		List<LanguageKnown> languagesKnown = new ArrayList<>();
		languagesKnown.add(languageKnown1);
		languagesKnown.add(languageKnown2);
		PersonalInfo personalInfo = new PersonalInfo("Abhishek", "", "Vaddi", "", new Date(), Gender.MALE,
				MaritalStatus.SINGLE);
		personalInfo.setLanguagesknown(languagesKnown);
		trainerProfile.setPersonalInfo(personalInfo);

		SessionLike sessionLike1 = new SessionLike(new Date());
		SessionLike sessionLike2 = new SessionLike(new Date());
		SessionLike sessionLike3 = new SessionLike(new Date());
		SessionLike sessionLike4 = new SessionLike(new Date());

		List<SessionLike> sessionLikeList1 = new ArrayList<>();
		List<SessionLike> sessionLikeList2 = new ArrayList<>();

		sessionLikeList1.add(sessionLike1);
		sessionLikeList1.add(sessionLike2);
		sessionLikeList2.add(sessionLike3);
		sessionLikeList2.add(sessionLike4);

		Comment comment1 = new Comment(new Date(), "Comment1");
		Comment comment2 = new Comment(new Date(), "Comment2");
		Comment comment3 = new Comment(new Date(), "Comment3");
		Comment comment4 = new Comment(new Date(), "Comment4");

		List<Comment> commentsList1 = new ArrayList<>();
		List<Comment> commentsList2 = new ArrayList<>();
		commentsList1.add(comment1);
		commentsList1.add(comment2);
		commentsList2.add(comment3);
		commentsList2.add(comment4);
		LiveSession liveSession1 = new LiveSession("http://www.youtube.com/embed/Y7C0oXks-qM", new Date(), new Date(),
				"Amadeus Java Batch 2016");
		LiveSession liveSession2 = new LiveSession("http://www.youtube.com/embed/CnTdJ5tG5Hk", new Date(), new Date(),
				"Amadeus Java Batch 2016");

		liveSession1.setSessionLikes(sessionLikeList1);
		liveSession2.setSessionLikes(sessionLikeList2);
		liveSession1.setComments(commentsList1);
		liveSession2.setComments(commentsList2);

		List<LiveSession> liveSessionList1 = new ArrayList<>();
		liveSessionList1.add(liveSession1);
		liveSessionList1.add(liveSession2);

		JobEmployment employment = new JobEmployment();
		employment.setCurrent(true);
		employment.setDesignation("SSE");
		employment.setStartDate(new Date());
		employment.setEndDate(new Date());
		employment.setOrganizationName("Amadeus");
		employment.setSalaryPackage(800000);
		Set<JobEmployment> jobEmployments = new HashSet<>();
		jobEmployments.add(employment);
		trainerProfile.setJobEmployments(jobEmployments);

		User user = new User();
		user.setUserName("Amadeus");
		user.setPassword("AMADEUS");
		user.setPrimaryMailId("amadeus@amadeus.com");
		user.setUserStatus(UserStatus.ACTIVE);

		Role role = new Role();
		role.setRoleName("Engineer");
		user.setRole(role);

		Contact contact = new Contact();
		contact.setFaxNo("123");
		contact.setOfficeContactNo(123456789l);
		contact.setPrimaryMobileNo(123456789l);
		contact.setSecondaryMobileNo(123456789l);
		contact.setSecondaryMailId("amadeus@amadeus.com");

		PreferredContact preferredContact = new PreferredContact();
		preferredContact.setPriority(5);
		preferredContact.setMethodOfContact(MethodOfContact.MOBILE);

		Address address = new Address();
		address.setAreaName("RR Nagar");
		address.setLandmark("Near dominos");
		address.setPincode("1234");
		address.setPropertyNo("58");
		address.setStreetName("1phase");
		
		Address address2 = new Address();
		address2.setAreaName("WhiteField");
		address2.setLandmark("Near Piza Hut");
		address2.setPincode("56029");
		address2.setPropertyNo("322");
		address2.setStreetName("HopeFarm");
		

		
		contact.getPreferredContacts().add(preferredContact);
		contact.setCurrentAddress(address);
		contact.setOfficeAddress(address2);
		

		Location location = new Location();
		location.setCity("bangalore");
		location.setCountry("India");
		location.setState("Karnataka");
		address.setLocation(location);
		address2.setLocation(location);
		user.setContact(contact);
//
//		sessionLike1.setUser(user);
//		sessionLike2.setUser(user);
//		sessionLike3.setUser(user);
//		sessionLike4.setUser(user);
		comment1.setUser(user);
		comment2.setUser(user);
		comment3.setUser(user);
		comment4.setUser(user);
		liveSession1.setUser(user);
		liveSession2.setUser(user);
		trainerProfile.setUser(user);
		
		Set<Certificate>certificate=new HashSet<Certificate>();
		certificate.add(new Certificate("Cisco",new Date("20/03/2012"),"A","CCNA","www.google.com"));
		certificate.add(new Certificate("Cisco12",new Date("22/03/2012"),"B","CCNAas","www.yahoo.com"));
		trainerProfile.setCertificates(certificate);
		
		Education education1 = new Education();
		Education education2 = new Education();
		Location educationLocation1 = new Location();
		Location educationLocation2 = new Location();

		educationLocation1.setCity("Jammu");
		educationLocation1.setCountry("India");
		educationLocation1.setState("J&K");

		educationLocation2.setCity("Srinagar");
		educationLocation2.setCountry("India");
		educationLocation2.setState("J&K");

		education1.setBoardName("CBSE");
		education1.setCourseDuration(1);
		education1.setCourseName("12th");

		education1.setFieldOfStudy("PCM");
		education1.setInstituteName("GHPS");
		education1.setPercentage(74.6f);
		education1.setStartYear(2010);
		education1.setYearOfPassing(2011);
		education1.setLocation(educationLocation1);

		education2.setBoardName("VTU");
		education2.setCourseDuration(4);
		education2.setCourseName("BE");

		education2.setFieldOfStudy("IT");
		education2.setInstituteName("PESIT");
		education2.setPercentage(74.6f);
		education2.setStartYear(2012);
		education2.setYearOfPassing(2016);
		education2.setLocation(educationLocation2);

		Set<Education> educations = new HashSet<>();
		educations.add(education1);
		educations.add(education2);

		trainerProfile.setEducations(educations);
		Client client1 = new Client(  );
		client1.setClientName("Amadeus");
		Client client2 = new Client( );
		client2.setClientName("Amadeus");
		Category category = new Category(1, "Java");

		Skill skill = new Skill("Javascript", category);
		WorkExperienceSkill workExperienceSkill = new WorkExperienceSkill(21, skill);

		Set<WorkExperienceSkill> workExperienceSkillSet = new HashSet<>();
		workExperienceSkillSet.add(workExperienceSkill);

		RealTimeExperience realExp1 = new RealTimeExperience(new Date("01/01/2015"), new Date("03/29/2015"), 2,
				"Nikhil", "7899753159", "Experience as a freelancer", false, ExperienceType.REAL_TIME, client1,
				"Web Developer", "Pathfinder", "Website for organization", "pathf.in/der", "Pathfinder");
		realExp1.setWorkExperienceSkills(workExperienceSkillSet);

		RealTimeExperience realExp2 = new RealTimeExperience(new Date("01/01/2015"), new Date("03/29/2015"), 8, "Uday",
				"7899753159", "Experience as a freelancer", false, ExperienceType.REAL_TIME, client1, "Web Developer",
				"Pathfinder", "Website for organization", "pathf.in/der", "Pathfinder");
		realExp1.setWorkExperienceSkills(workExperienceSkillSet);

		TrainingExperience trainingExp1 = new TrainingExperience(new Date("01/01/2016"), new Date("03/29/2016"), 2,
				"Ruchi", "9900998877", "Amadeus Training", true, ExperienceType.TRAINING, client2,
				new GregorianCalendar(2016, 1, 10, 8, 30, 00), new GregorianCalendar(2016, 3, 10, 18, 30, 00),
				"Bangalore", true, "Amadeus", TrainingMode.FACE_TO_FACE, TrainingType.LATERAL);

		// Creating the Set of Work Experiences
		Set<WorkExperience> workExperiences = new HashSet<>();

		// Adding work experiences
		workExperiences.add(realExp1);
		workExperiences.add(realExp2);
		workExperiences.add(trainingExp1);

		// Creating the Set of Skills
		SkillSet skillSet = new SkillSet(skill);
		Set<SkillSet> skillSetSet = new HashSet<>();
		skillSetSet.add(skillSet);
		trainerProfile.setSkillset(skillSetSet);
		trainerProfile.setWorkExperiences(workExperiences);
		Patent patent1 =  new Patent( "USA", 281298l ,true, "title",new Date(01,12,14),"url",
				"description...");
		Patent patent2 = new Patent( "INDIA", 856876l, true,"title",new Date(05,3,11),"url","decription...");
		Set<Patent> patents = new HashSet<>();
		patents.add(patent1);
		patents.add(patent2);
		trainerProfile.setPatents(patents);
		
		//Honors and Awards
		HonorAndAward honorsAndAwards1 = new HonorAndAward( "Coder of the Year", "Google", 
				"Software Engineer",new Date(02,3,11));
		HonorAndAward honorsAndAwards2 = new HonorAndAward( "Debugger of the Year", "Amazon",
				"Performance Engineer",new Date(05,3,11));
		Set<HonorAndAward> honorsAndAwards = new HashSet<>();
		honorsAndAwards.add(honorsAndAwards1);
		honorsAndAwards.add(honorsAndAwards2);
		
		trainerProfile.setHonorAndAwards(honorsAndAwards);

		tx.begin();

//		session.save(address);
//		session.save(user);
//		session.save(role);
//		session.save(contact);
//		session.save(preferredContact);
//		session.save(trainerProfile);

		session.save(category);
		session.save(skill);
		session.save(role);
		session.save(address);
		session.save(address2);
		session.save(preferredContact);
		session.save(contact);
		session.save(user);
		session.save(sessionLike1);
		session.save(sessionLike2);
		session.save(sessionLike3);
		session.save(sessionLike4);
		session.save(trainerProfile);
		session.save(liveSession1);
		session.save(liveSession2);
		
		long startTime = System.currentTimeMillis();
		TrainerProfile tp = (TrainerProfile) session.load(TrainerProfile.class, 1L);
		long endTime = System.currentTimeMillis();
		tx.commit();
		session.close();
		
		
		//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		System.out.println("Time Difference : " + (endTime - startTime));
	}
}
