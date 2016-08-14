package com.ge.tps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ge.tps.entities.TrainerProfile;
import com.ge.tps.entities.User;

public class RegistrationServiceHibernate {
	public String registerTrainerProfile(TrainerProfile trainerProfile) {

		/*
		 * HibernateTemplate hibernateTemplate =
		 * SessionFactoryUtil.getHibernateTemplate();
		 * hibernateTemplate.save(trainerProfile.getUser().getContact());
		 * hibernateTemplate.save(trainerProfile.getUser());
		 * hibernateTemplate.save(trainerProfile); return "success";
		 */

		// create config object
		Configuration cfg = new AnnotationConfiguration()
				.configure("hibernate.cfg.xml");

		// get the session factory
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// get the session
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		session.save(trainerProfile.getUser().getContact());
		session.save(trainerProfile.getUser());
		session.save(trainerProfile);

		tx.commit();

		session.close();
		return "success";
	}

	/*
	 * 
	 * public boolean registerTrainerProfile(TrainerProfile trainerProfile) {
	 * HibernateTemplate hibernateTemplate =
	 * SessionFactoryUtil.getHibernateTemplate();
	 * hibernateTemplate.save(trainerProfile.getUser().getContact());
	 * hibernateTemplate.save(trainerProfile.getUser());
	 * hibernateTemplate.save(trainerProfile); return true; }
	 */
	public boolean isUserNameAvailable(String userName) {
		// HibernateTemplate hibernateTemplate =
		// SessionFactoryUtil.getHibernateTemplate();
		// create config object
		Configuration cfg = new AnnotationConfiguration()
				.configure("hibernate.cfg.xml");

		// get the session factory
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// get the session
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		System.out.println("Checking for : " + userName);
		String hql = "FROM User u where u.userName = ?";
		Query query = session.createQuery(hql);
		// List<User> user = session.find(hql, userName);
		// session.close();
		List<User> user = query.list();
		if (user.size() > 0) {
			return false; // UserName unavailable
		} else {
			return true; // UserName available
		}

	}

	public boolean isEmailAvailable(String primaryMailId) {
		// HibernateTemplate hibernateTemplate =
		// SessionFactoryUtil.getHibernateTemplate();
		// create config object
		Configuration cfg = new AnnotationConfiguration()
				.configure("hibernate.cfg.xml");

		// get the session factory
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// get the session
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		System.out.println("Checking for : " + primaryMailId);
		String hql = "FROM User u where u.primaryMailId = ?";
		Query query = session.createQuery(hql);
		// List<User> user = hibernateTemplate.find(hql, primaryMailId);
		List<User> user = query.list();
		if (user.size() > 0) {
			return false; // UserName unavailable
		} else {
			return true; // UserName available
		}

	}
}
