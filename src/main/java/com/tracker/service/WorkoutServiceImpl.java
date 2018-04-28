package com.tracker.service;

import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tracker.constants.CommonConstants;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.entity.WorkoutCollectionEntity;
import com.tracker.intf.IWorkoutService;
import com.tracker.model.AddWorkoutModel;
import com.tracker.model.StartEndWorkoutModel;
import com.tracker.util.CommonUtil;
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
	
	@Override
	public String startWorkout(AddWorkoutModel startEndWorkoutModel) {
		WorkoutActiveEntity workoutActiveEntity = new WorkoutActiveEntity();
		workoutActiveEntity.setWorkout_id(Integer.parseInt(startEndWorkoutModel.getWorkoutId()));
		if(startEndWorkoutModel.isStartWorkoutFlag() == true) {
			workoutActiveEntity.setStartDate(CommonUtil.formatDate(startEndWorkoutModel.getStartDate()));
			workoutActiveEntity.setStartTime(Time.valueOf(startEndWorkoutModel.getStartTime()));
			workoutActiveEntity.setComment(CommonConstants.STARTED_STATUS);
		} else if(startEndWorkoutModel.isStartWorkoutFlag() == false){
			workoutActiveEntity.setEndDate(CommonUtil.formatDate(startEndWorkoutModel.getEndDate()));
			workoutActiveEntity.setEndTime(Time.valueOf(startEndWorkoutModel.getEndTime()));
			workoutActiveEntity.setComment(CommonConstants.ENDED_STATUS);
		}		
		System.out.println("<----------- workoutActiveEntity ----------->" + workoutActiveEntity.toString());
		HibernateUtil.startWorkout(workoutActiveEntity,startEndWorkoutModel.isStartWorkoutFlag());
		return CommonConstants.SUCCESS_RESPONSE;		
	}

}
