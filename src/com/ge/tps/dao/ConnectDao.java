package com.ge.tps.dao;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.ge.tps.entities.Connect;

public class ConnectDao {

	public void connectMe(String userName, String connectName, String reason,
			Boolean bool, Date start, String description) {
		
		Configuration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Connect connect = new Connect();
		connect.setDescription(description);
		connect.setInPerson(bool);
		connect.setReason(reason);
		connect.setWhenDate(start);
		connect.setUserName(userName);
		connect.setTodayDate(new Date());
		
		System.out.println(connect);
		session.save(connect);
		tx.commit();
		session.close();
	}

}
