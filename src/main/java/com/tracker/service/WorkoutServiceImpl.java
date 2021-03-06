package com.tracker.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.Exception.BusinessException;
import com.tracker.constants.CommonConstants;
import com.tracker.dao.WorkoutDao;
import com.tracker.entity.CategoryEntity;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.entity.WorkoutCollectionEntity;
import com.tracker.intf.IWorkoutService;
import com.tracker.model.AddWorkoutModel;
import com.tracker.util.CommonUtil;

/**
 * The Class WorkoutServiceImpl.
 */
@Component
public class WorkoutServiceImpl implements IWorkoutService{
	
	/** The workout dao. */
	@Autowired
	private WorkoutDao workoutDao;
	
	/* (non-Javadoc)
	 * @see com.tracker.intf.IWorkoutService#addWorkout(com.tracker.model.AddWorkoutModel)
	 */
	@Override
	public String addWorkout(AddWorkoutModel addWorkoutModel) throws BusinessException {
		WorkoutCollectionEntity collectionEntity = new WorkoutCollectionEntity();
		try {
			if(addWorkoutModel.getWorkoutId() != null) {
				collectionEntity.setWorkoutId(Integer.parseInt(addWorkoutModel.getWorkoutId()));
			}		
			collectionEntity.setCategoryId(Integer.parseInt(addWorkoutModel.getCategoryId()));
			collectionEntity.setCaloriesBurnt(Float.parseFloat(addWorkoutModel.getCaloriesBurnt()));
			collectionEntity.setWorkoutTitle(addWorkoutModel.getWorkoutTitle());
			collectionEntity.setWorkoutNote(addWorkoutModel.getWorkoutNote());
		}catch(NumberFormatException e) {
			throw new BusinessException(e.toString());
		}	
		workoutDao.insertInfo(collectionEntity);
		return CommonConstants.SUCCESS_RESPONSE;		
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.intf.IWorkoutService#viewAllWorkouts()
	 */
	@Override
	public List<AddWorkoutModel> viewAllWorkouts() {
		List<WorkoutCollectionEntity> workoutEntityList = workoutDao.fetchWorkoutInfo();
		List<AddWorkoutModel> workoutsList = new ArrayList<AddWorkoutModel>();
		AddWorkoutModel addWorkoutModel = null;
		for(WorkoutCollectionEntity workout : workoutEntityList) {
			addWorkoutModel = new AddWorkoutModel();
			addWorkoutModel.setWorkoutId(Integer.toString(workout.getWorkoutId()));
			addWorkoutModel.setWorkoutTitle(workout.getWorkoutTitle());
			addWorkoutModel.setWorkoutNote(workout.getWorkoutNote());
			addWorkoutModel.setCaloriesBurnt(Float.toString(workout.getCaloriesBurnt()));
			addWorkoutModel.setCategoryId(Integer.toString(workout.getCategoryId()));
			workoutsList.add(addWorkoutModel);
		}
		return workoutsList;		
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.intf.IWorkoutService#deleteWorkout(java.lang.String)
	 */
	@Override
	public String deleteWorkout(String workoutId) throws BusinessException {
		workoutDao.deleteWorkout(workoutId);
		return CommonConstants.SUCCESS_RESPONSE;
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.intf.IWorkoutService#editWorkout(java.lang.String)
	 */
	@Override
	public List<AddWorkoutModel> editWorkout(String workoutId) throws BusinessException {
		List<WorkoutCollectionEntity> editModel = workoutDao.fetchEditWorkoutDetails(workoutId);
		List<AddWorkoutModel> editWorkoutDetails = new ArrayList<AddWorkoutModel>();
		AddWorkoutModel addWorkoutModel= null;
		for(WorkoutCollectionEntity editData :editModel) {
			addWorkoutModel = new AddWorkoutModel();
			addWorkoutModel.setWorkoutId(Integer.toString(editData.getWorkoutId()));
			addWorkoutModel.setWorkoutTitle(editData.getWorkoutTitle());
			addWorkoutModel.setWorkoutNote(editData.getWorkoutNote());
			addWorkoutModel.setCaloriesBurnt(Float.toString(editData.getCaloriesBurnt()));
			addWorkoutModel.setCategoryId(Integer.toString(editData.getCategoryId()));
			fetchCategory(editData.getCategoryId(),addWorkoutModel);
			fetchStartWorkoutDetails(workoutId, addWorkoutModel);
			editWorkoutDetails.add(addWorkoutModel);
		}
		
		return editWorkoutDetails;
	}
	
	
	/**
	 * Fetch start workout details.
	 *
	 * @param workoutId the workout id
	 * @param addWorkoutModel the add workout model
	 * @throws BusinessException the business exception
	 */
	private void fetchStartWorkoutDetails(String workoutId,AddWorkoutModel addWorkoutModel) throws BusinessException {
		WorkoutActiveEntity workoutActiveEntity = workoutDao.fetchStartWorkoutDetails(workoutId);
		if(workoutActiveEntity!=null) {
			Date inputDate = workoutActiveEntity.getStartDate();
			addWorkoutModel.setStartDate(CommonUtil.formatDateToString(inputDate));
			if(workoutActiveEntity.getStartTime()!=null) {
				addWorkoutModel.setStartTime(workoutActiveEntity.getStartTime().toString());
			}		
		}
	}
	
	private void fetchCategory(int categoryId,AddWorkoutModel addWorkoutModel) {
		CategoryEntity categoryEntity = workoutDao.findByCategoryId(categoryId);
		addWorkoutModel.setCategoryName(categoryEntity.getCategoryName());
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.intf.IWorkoutService#startWorkout(com.tracker.model.AddWorkoutModel)
	 */
	@Override
	public String startWorkout(AddWorkoutModel startEndWorkoutModel) throws BusinessException {
		WorkoutActiveEntity workoutActiveEntity = new WorkoutActiveEntity();
		workoutActiveEntity.setWorkoutId(Integer.parseInt(startEndWorkoutModel.getWorkoutId()));
		if(startEndWorkoutModel.isStartWorkoutFlag() == true) {
			workoutActiveEntity.setStartDate(CommonUtil.formatDate(startEndWorkoutModel.getStartDate()));
			workoutActiveEntity.setStartTime(Time.valueOf(startEndWorkoutModel.getStartTime()));
			workoutActiveEntity.setComment(CommonConstants.STARTED_STATUS);
			workoutActiveEntity.setStatus(Boolean.FALSE);
		} else if(startEndWorkoutModel.isStartWorkoutFlag() == false){
			workoutActiveEntity.setStartDate(CommonUtil.formatDate(startEndWorkoutModel.getStartDate()));
			workoutActiveEntity.setStartTime(Time.valueOf(startEndWorkoutModel.getStartTime()));
			workoutActiveEntity.setEndDate(CommonUtil.formatDate(startEndWorkoutModel.getEndDate()));
			workoutActiveEntity.setEndTime(Time.valueOf(startEndWorkoutModel.getEndTime()));
			workoutActiveEntity.setComment(CommonConstants.ENDED_STATUS);
			workoutActiveEntity.setStatus(Boolean.TRUE);
		}	
		workoutDao.startWorkout(workoutActiveEntity);
		return CommonConstants.SUCCESS_RESPONSE;		
	}

}
