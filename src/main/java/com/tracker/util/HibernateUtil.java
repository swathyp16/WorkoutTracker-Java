package com.tracker.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.loader.collection.CollectionJoinWalker;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.util.CollectionUtils;

import com.tracker.constants.CommonConstants;
import com.tracker.constants.QueryConstants;
import com.tracker.entity.CategoryEntity;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.entity.WorkoutCollectionEntity;
import com.tracker.model.AddWorkoutModel;
import com.tracker.model.CategoryModel;



public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static void insertInfo(WorkoutCollectionEntity collectionEntity) {		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select *  from workout_collection where workout_id ="+collectionEntity.getWorkout_id());
		List<Object[]> rows = query.list();
		System.out.println("rows: " + rows.size());
		if(!rows.isEmpty() && rows.size()>0) {
			System.out.println("*********inisde loop 1 **********");
			SQLQuery updateQuery = session.createSQLQuery("UPDATE workout_collection SET workout_title ='"+ collectionEntity.getWorkoutTitle() +
					"' , workout_note = '" + collectionEntity.getWorkoutNote()+ "' , category_id = " + collectionEntity.getCategoryId()+" where workout_id ="+ collectionEntity.getWorkout_id());
			updateQuery.executeUpdate();
		}else {
			System.out.println("*********inisde loop 2 **********");
			session.save(collectionEntity);
		}
		
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
			categoryModel.setCategoryId(row[0].toString());
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
	
	public static void deleteWorkout(String workoutTitle) {
		System.out.println("<-----------workout NAME ---------->" + workoutTitle);
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("delete from WorkoutCollectionEntity where workout_title ='"+workoutTitle+"'");
		q.executeUpdate();
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	public static List<AddWorkoutModel> editWorkout(String workoutId) {
		System.out.println("<-----------workout ID ---------->" + workoutId);
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select *  from workout_collection where workout_id ="+workoutId.toString());
		List<Object[]> rows = query.list();
		AddWorkoutModel editWorkoutModel = null;
		List<AddWorkoutModel> editWorkoutList = new ArrayList<AddWorkoutModel>();
		for(Object[] row : rows){
			editWorkoutModel = new AddWorkoutModel();
			editWorkoutModel.setWorkoutId(row[0].toString());
			editWorkoutModel.setWorkoutTitle(row[1].toString());
			editWorkoutModel.setWorkoutNote(row[2].toString());
			editWorkoutModel.setCaloriesBurnt(row[3].toString());
			editWorkoutModel.setCategoryId(row[4].toString());			
			editWorkoutList.add(editWorkoutModel);
		}
		System.out.println("Edit details : "+ editWorkoutModel.toString());
		tx.commit();
		session.close();
		sessionFactory.close();
		return editWorkoutList;		
	}
	
	public static void startWorkout(WorkoutActiveEntity workoutActiveEntity) {
		System.out.println("<-----------WorkoutActiveEntity ---------->" + workoutActiveEntity);
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select *  from workout_active where workout_id ="+workoutActiveEntity.getWorkout_id());
		List<Object[]> rows = query.list();
		SQLQuery updateQuery = null;
		if(!rows.isEmpty() && rows.size()>0) {
			for(Object[] row : rows){
			if(row[5].equals(CommonConstants.STARTED_STATUS)){
				updateQuery = session.createSQLQuery("UPDATE workout_active SET end_date ='"+ workoutActiveEntity.getEndDate() +
						"' , end_time = '" + workoutActiveEntity.getEndTime() + "' , status = 1" + " where workout_id ="+ workoutActiveEntity.getWorkout_id());
			}
			}
			updateQuery.executeUpdate();
		}else {
			session.save(workoutActiveEntity);
		}		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	

}
