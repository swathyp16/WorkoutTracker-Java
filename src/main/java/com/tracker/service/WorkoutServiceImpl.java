package com.tracker.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.Exception.BusinessException;
import com.tracker.constants.CommonConstants;
import com.tracker.dao.WorkoutDao;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.entity.WorkoutCollectionEntity;
import com.tracker.intf.IWorkoutService;
import com.tracker.model.AddWorkoutModel;
import com.tracker.model.StartEndWorkoutModel;
import com.tracker.util.CommonUtil;
import com.tracker.util.HibernateUtil;

@Component
public class WorkoutServiceImpl implements IWorkoutService{
	
	@Autowired
	WorkoutDao workoutDao;
	
	@Override
	public String addWorkout(AddWorkoutModel addWorkoutModel) throws BusinessException {
		WorkoutCollectionEntity collectionEntity = new WorkoutCollectionEntity();
		try {
			if(addWorkoutModel.getWorkoutId() != null) {
				collectionEntity.setWorkout_id(Integer.parseInt(addWorkoutModel.getWorkoutId()));
			}		
			collectionEntity.setCategoryId(Integer.parseInt(addWorkoutModel.getCategoryId()));
			collectionEntity.setCaloriesBurnt(Float.parseFloat(addWorkoutModel.getCaloriesBurnt()));
			collectionEntity.setWorkoutTitle(addWorkoutModel.getWorkoutTitle());
			collectionEntity.setWorkoutNote(addWorkoutModel.getWorkoutNote());
		}catch(NumberFormatException e) {
			throw new BusinessException(e.toString());
		}		
		//HibernateUtil.insertInfo(collectionEntity);
		workoutDao.insertInfo(collectionEntity);
		return CommonConstants.SUCCESS_RESPONSE;		
	}
	
	@Override
	public List<AddWorkoutModel> viewAllWorkouts() {
		List<WorkoutCollectionEntity> workoutEntityList = workoutDao.fetchWorkoutInfo();
		List<AddWorkoutModel> workoutsList = new ArrayList<AddWorkoutModel>();
		AddWorkoutModel addWorkoutModel = null;
		for(WorkoutCollectionEntity workout : workoutEntityList) {
			addWorkoutModel = new AddWorkoutModel();
			addWorkoutModel.setWorkoutId(Integer.toString(workout.getWorkout_id()));
			addWorkoutModel.setWorkoutTitle(workout.getWorkoutTitle());
			addWorkoutModel.setWorkoutNote(workout.getWorkoutNote());
			addWorkoutModel.setCaloriesBurnt(Float.toString(workout.getCaloriesBurnt()));
			addWorkoutModel.setCategoryId(Integer.toString(workout.getCategoryId()));
			workoutsList.add(addWorkoutModel);
		}
				//HibernateUtil.getInfo();
		
		return workoutsList;		
	}
	
	@Override
	public String deleteWorkout(String workoutId) throws BusinessException {
		//HibernateUtil.deleteWorkout(workoutTitle);
		workoutDao.deleteWorkout(workoutId);
		return CommonConstants.SUCCESS_RESPONSE;
	}
	
	@Override
	public List<AddWorkoutModel> editWorkout(String workoutId) {
		List<WorkoutCollectionEntity> editModel = workoutDao.fetchEditWorkoutDetails(workoutId);
		List<AddWorkoutModel> editWorkoutDetails = new ArrayList<AddWorkoutModel>();
		AddWorkoutModel addWorkoutModel= null;
		for(WorkoutCollectionEntity editData :editModel) {
			addWorkoutModel = new AddWorkoutModel();
			addWorkoutModel.setWorkoutId(Integer.toString(editData.getWorkout_id()));
			addWorkoutModel.setWorkoutTitle(editData.getWorkoutTitle());
			addWorkoutModel.setWorkoutNote(editData.getWorkoutNote());
			addWorkoutModel.setCaloriesBurnt(Float.toString(editData.getCaloriesBurnt()));
			addWorkoutModel.setCategoryId(Integer.toString(editData.getCategoryId()));
			editWorkoutDetails.add(addWorkoutModel);
		}
				//HibernateUtil.editWorkout(workoutId);
		return editWorkoutDetails;
	}
	
	@Override
	public String startWorkout(AddWorkoutModel startEndWorkoutModel) throws BusinessException {
		WorkoutActiveEntity workoutActiveEntity = new WorkoutActiveEntity();
		workoutActiveEntity.setWorkout_id(Integer.parseInt(startEndWorkoutModel.getWorkoutId()));
		if(startEndWorkoutModel.isStartWorkoutFlag() == true) {
			workoutActiveEntity.setStartDate(CommonUtil.formatDate(startEndWorkoutModel.getStartDate()));
			workoutActiveEntity.setStartTime(Time.valueOf(startEndWorkoutModel.getStartTime()));
			workoutActiveEntity.setComment(CommonConstants.STARTED_STATUS);
			workoutActiveEntity.setStatus(Boolean.FALSE);
		} else if(startEndWorkoutModel.isStartWorkoutFlag() == false){
			workoutActiveEntity.setEndDate(CommonUtil.formatDate(startEndWorkoutModel.getEndDate()));
			workoutActiveEntity.setEndTime(Time.valueOf(startEndWorkoutModel.getEndTime()));
			workoutActiveEntity.setComment(CommonConstants.ENDED_STATUS);
			workoutActiveEntity.setStatus(Boolean.TRUE);
		}		
		//System.out.println("<----------- workoutActiveEntity ----------->" + workoutActiveEntity.toString());
		//HibernateUtil.startWorkout(workoutActiveEntity,startEndWorkoutModel.isStartWorkoutFlag());
		workoutDao.startWorkout(workoutActiveEntity);
		return CommonConstants.SUCCESS_RESPONSE;		
	}

}
