package com.ge.tps.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.ge.tps.entities.TrainerProfile;
import com.ge.tps.entities.User;

public class RetrieveProfileDao {
	Configuration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");

	SessionFactory sessionFactory = cfg.buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	public TrainerProfile getUserProfile(long user_id){
		System.out.println(user_id);
		String hql = "FROM TrainerProfile tp WHERE tp.user.userId = :user";
		Query query = session.createQuery(hql);
		query.setParameter("user",user_id);
		tx.commit();
		TrainerProfile trainer = (TrainerProfile) query.uniqueResult();
		return trainer;
	}
}
