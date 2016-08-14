package com.ge.tps.dao.impl;


import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.ge.tps.dao.LiveSessionDao;
import com.ge.tps.entities.Comment;
import com.ge.tps.entities.LiveSession;
import com.ge.tps.entities.User;

public class LiveSessionDaoImpl implements LiveSessionDao {
	
	Configuration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	Session session = null;
	Transaction tx = null;
	public LiveSession getLiveSession(String url) {
		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		String hql = "FROM LiveSession ls where ls.liveSessionURL = ? ";
		Query query = session.createQuery(hql);
		query.setParameter(0, url);
		LiveSession liveSession = (LiveSession) query.uniqueResult();
		
		return liveSession;
	}

	@Override
	public LiveSession addLiveSessionComment(String url, String comment, long userId) {

		session=sessionFactory.openSession();
		tx = session.beginTransaction();
		String hql = "FROM LiveSession ls where ls.liveSessionURL = ? ";
		Query query = session.createQuery(hql);
		query.setParameter(0, url);
		LiveSession liveSession = (LiveSession) query.uniqueResult();
		
		String userQueryString = "FROM User u where u.userId = ? ";
		query = session.createQuery(userQueryString);
		query.setParameter(0, userId);
		
		User user = (User) query.uniqueResult();
		Comment newComment = new Comment(new Date(), comment, user);
		liveSession.getComments().add(newComment);

		session.update(liveSession);
		tx.commit();
		return liveSession;
	}
//
//	public LiveSession addSessionLike(String url, long userId) {
//
//		// Configuration cfg = new
//		// AnnotationConfiguration().configure("hibernate.cfg.xml");
//		// SessionFactory sessionFactory = cfg.buildSessionFactory();
//		//
//		// Session session = sessionFactory.openSession();
//		// Transaction tx = session.beginTransaction();
//		// String hql = "FROM LiveSession ls where ls.liveSessionURL =:url ";
//		// Query query = session.createQuery(hql);
//		// query.setParameter("url", url);
//		// LiveSession liveSession = (LiveSession) query.uniqueResult();
//		// User user = (User) session.load(User.class, userId);
//		// liveSession.getSessionLikes().add(new SessionLike(new Date(), user));
//		// session.save(liveSession);
//		// tx.commit();
//		// return liveSession;
//		return null;
//	}

}
