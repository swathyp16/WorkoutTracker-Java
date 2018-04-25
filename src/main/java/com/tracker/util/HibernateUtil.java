package com.tracker.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.CategoryEntity;
import com.tracker.model.AddWorkoutModel;
import com.tracker.model.CategoryModel;



public class HibernateUtil {
	
/*	public static void main(String[] args) {
		
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

		//AddWorkoutModel model = new AddWorkoutModel();
		//model.setWorkoutId(1);
		//model.setWorkoutTitle("Running");
		//model.setCategoryId(2);
		//model.setWorkoutNote("Fast running 10kms");
		//model.setCaloriesBurnt(25.3f);
		//HibernateUtil.insertInfo(model);
		
	//}
	private static SessionFactory sessionFactory;
	
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
	
	public static List<AddWorkoutModel> getInfo() {
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		List<AddWorkoutModel> workoutsList = new ArrayList<AddWorkoutModel>();
		AddWorkoutModel addWorkoutModel = null;
		sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(QueryConstants.VIEW_WORKOUTS_QUERY);
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			addWorkoutModel = new AddWorkoutModel();
			addWorkoutModel.setWorkoutId(row[0].toString());
			addWorkoutModel.setWorkoutTitle(row[1].toString());
			addWorkoutModel.setWorkoutNote(row[2].toString());
			addWorkoutModel.setCaloriesBurnt(row[3].toString());
			addWorkoutModel.setCategoryId(row[4].toString());
			System.out.println("output: " + row[0].toString() +","+row[1].toString()+","+row[2].toString());
			workoutsList.add(addWorkoutModel);
		}
		
		return workoutsList;
	}
	
	public static List<CategoryModel> getCategoryList() {
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		List<CategoryModel> categoryList = new ArrayList<CategoryModel>();
		CategoryModel categoryModel = null;
		sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(QueryConstants.VIEW_CATEGORY_QUERY);
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			categoryModel = new CategoryModel();
			//categoryModel.setCategoryId(row[0].toString());
			categoryModel.setCategoryName(row[1].toString());
			categoryList.add(categoryModel);
		}
		
		return categoryList;
	}
	
	public static void addCategory(CategoryEntity model) {
		System.out.println("<-----------CATGEORY MODEL ---------->" + model);
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
	
	public static void deleteCategory(String categoryName) {
		System.out.println("<-----------CATGEORY NAME ---------->" + categoryName);
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("delete from CategoryEntity where category_name ='"+categoryName+"'");
		q.executeUpdate();
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}

}
