package com.tracker.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tracker.constants.CommonConstants;
import com.tracker.entity.WorkoutCollectionEntity;
import com.tracker.intf.IWorkoutService;
import com.tracker.model.AddWorkoutModel;
import com.tracker.util.HibernateUtil;

@Component
public class WorkoutServiceImpl implements IWorkoutService{
	
	@Override
	public String addWorkout(AddWorkoutModel addWorkoutModel) {
		WorkoutCollectionEntity collectionEntity = new WorkoutCollectionEntity();
		if(addWorkoutModel.getWorkoutId() != null) {
			collectionEntity.setWorkout_id(Integer.parseInt(addWorkoutModel.getWorkoutId()));
		}		
		collectionEntity.setCategoryId(Integer.parseInt(addWorkoutModel.getCategoryId()));
		collectionEntity.setCaloriesBurnt(Float.parseFloat(addWorkoutModel.getCaloriesBurnt()));
		collectionEntity.setWorkoutTitle(addWorkoutModel.getWorkoutTitle());
		collectionEntity.setWorkoutNote(addWorkoutModel.getWorkoutNote());
		HibernateUtil.insertInfo(collectionEntity);
		return CommonConstants.SUCCESS_RESPONSE;
		
	}
	
	@Override
	public List<AddWorkoutModel> viewAllWorkouts() {
		List<AddWorkoutModel> workoutsList = HibernateUtil.getInfo();
		return workoutsList;
		
	}
	
	@Override
	public String deleteWorkout(String workoutTitle) {
		HibernateUtil.deleteWorkout(workoutTitle);
		return CommonConstants.SUCCESS_RESPONSE;
	}
	
	@Override
	public List<AddWorkoutModel> editWorkout(String workoutId) {
		List<AddWorkoutModel> editModel = HibernateUtil.editWorkout(workoutId);
		return editModel;
	}

}
