package com.tracker.util;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

import com.tracker.model.AddWorkoutModel;



public class HibernateUtil {
	
	public static void main(String[] args) {
		
		/*AddWorkoutModel model = new AddWorkoutModel();
		model.setWorkoutId(1);
		model.setWorkoutTitle("Running");
		model.setCategoryId(2);
		model.setWorkoutNote("Fast running 10kms");
		model.setCaloriesBurnt(25);
		SessionFactory sessionFactory = null;
		
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			System.out.println("Session created");
			tx = session.beginTransaction();
			session.save(model);
			tx.commit();
			System.out.println("Workout title="+ model.getWorkoutTitle());
		}catch(Exception e) {
			System.out.println("Exception occured");
		}finally {
			if(sessionFactory!= null && !sessionFactory.isClosed()) {
				sessionFactory.close();
			}
		}*/

		AddWorkoutModel model = new AddWorkoutModel();
		model.setWorkoutId(1);
		model.setWorkoutTitle("Running");
		model.setCategoryId(2);
		model.setWorkoutNote("Fast running 10kms");
		model.setCaloriesBurnt(25.3f);
		HibernateUtil.insertInfo(model);
		
	}
	private static SessionFactory sessionFactory;
	
	private static Session session;
	
	/*public static SessionFactory buildSessionFactory() {
		try {
			Configuration conf = new Configuration();
			conf.configure("/hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new  servic.applySettings(conf.getProperties()).buildServiceRegistry();
			sessionFactory= conf.buildSessionFactory(serviceRegistry);
			//session = sessionFactory.openSession();
			return sessionFactory;
		} catch(Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
		
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}*/
	
	public static void insertInfo(AddWorkoutModel model) {
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(model);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	public static void getInfo() {
		Configuration conf = new Configuration();
		conf.configure("./src/main/resources/hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from workout_collection");
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			System.out.println("output: " + row[0].toString() +","+row[1].toString()+","+row[2].toString());
		}
				
	}

}
