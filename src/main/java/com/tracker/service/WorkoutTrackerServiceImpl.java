package com.tracker.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.Exception.BusinessException;
import com.tracker.dao.WorkoutTrackerDao;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.entity.WorkoutCollectionEntity;
import com.tracker.intf.IWorkoutTrackerService;
import com.tracker.model.AddWorkoutModel;
import com.tracker.model.WorkoutTrackerModel;
import com.tracker.util.CommonUtil;

/**
 * The Class WorkoutTrackerServiceImpl.
 */
@Component
public class WorkoutTrackerServiceImpl implements IWorkoutTrackerService {
	
	/** The workout tracker dao. */
	@Autowired
	private WorkoutTrackerDao workoutTrackerDao;
	
	/* (non-Javadoc)
	 * @see com.tracker.intf.IWorkoutTrackerService#getWorkoutTrackerData()
	 */
	public WorkoutTrackerModel getWorkoutTrackerData() throws BusinessException {
		WorkoutTrackerModel workoutTrackerModel = new WorkoutTrackerModel();
		long dailyTimeDuration;
		Integer dailyTimeDurationInMinutes = 0;
		long weeklyTimeDuration;
		Integer weeklyTimeDurationInMinutes = 0;
		long monthlyTimeDuration;
		Integer monthlyTimeDurationInMinutes = 0;
		String currentDate = CommonUtil.formatCurrentDateToString(new Date());
		List<WorkoutActiveEntity> currentDayWorkouts = workoutTrackerDao.fetchWorkoutTrackerData(currentDate);
		for(WorkoutActiveEntity workoutActivity: currentDayWorkouts) {
			dailyTimeDuration= workoutActivity.getEndTime().getTime() - workoutActivity.getStartTime().getTime();
			dailyTimeDurationInMinutes = (int) (dailyTimeDurationInMinutes + TimeUnit.MILLISECONDS.toMinutes(dailyTimeDuration));		
		}	
		workoutTrackerModel.setWorkoutTimeOfDay(dailyTimeDurationInMinutes);
		
		List<WorkoutCollectionEntity> currentWeeksWorkouts = workoutTrackerDao.fetchCurrentWeekWorkouts();
		List<AddWorkoutModel> weeklyWorkouts = mapEntityToWorkoutModel(currentWeeksWorkouts);
		workoutTrackerModel.setWeeklyWorkouts(weeklyWorkouts);
		for(WorkoutCollectionEntity weekWorkout: currentWeeksWorkouts) {
			WorkoutActiveEntity workoutActiveEntity = weekWorkout.getWorkoutActiveEntity();
			if(workoutActiveEntity != null) {
				weeklyTimeDuration = workoutActiveEntity.getEndTime().getTime() - workoutActiveEntity.getStartTime().getTime();
				weeklyTimeDurationInMinutes = (int) (weeklyTimeDurationInMinutes + TimeUnit.MILLISECONDS.toMinutes(weeklyTimeDuration));
			}
			
		}	
		workoutTrackerModel.setWorkoutTimeOfWeek(weeklyTimeDurationInMinutes);
		
		
		List<WorkoutCollectionEntity> currentMonthWorkouts = workoutTrackerDao.fetchCurrentMonthWorkouts();
		List<AddWorkoutModel> monthlyWorkouts = mapEntityToWorkoutModel(currentMonthWorkouts);
		workoutTrackerModel.setMonthlyWorkouts(monthlyWorkouts);
		for(WorkoutCollectionEntity monthlyWorkout: currentMonthWorkouts) {
			WorkoutActiveEntity workoutActiveEntity = monthlyWorkout.getWorkoutActiveEntity();
			if(workoutActiveEntity != null) {
				monthlyTimeDuration = workoutActiveEntity.getEndTime().getTime() - workoutActiveEntity.getStartTime().getTime();
				monthlyTimeDurationInMinutes = (int) (monthlyTimeDurationInMinutes + TimeUnit.MILLISECONDS.toMinutes(monthlyTimeDuration));
			}			
		}
		workoutTrackerModel.setWorkoutTimeOfMonth(monthlyTimeDurationInMinutes);		
		List<WorkoutCollectionEntity> currentYearWorkouts = workoutTrackerDao.fetchCurrentYearWorkouts();
		List<AddWorkoutModel> yearlyWorkouts = mapEntityToWorkoutModel(currentYearWorkouts);
		workoutTrackerModel.setYearlyWorkouts(yearlyWorkouts);		
		return workoutTrackerModel;
	}
	
	
	
	 /**
 	 * Map entity to workout model.
 	 *
 	 * @param workoutEntity the workout entity
 	 * @return the list
 	 * @throws BusinessException the business exception
 	 */
 	private List<AddWorkoutModel> mapEntityToWorkoutModel(List<WorkoutCollectionEntity> workoutEntity) throws BusinessException {
		 List<AddWorkoutModel> workoutsList = new ArrayList<AddWorkoutModel>();
		 AddWorkoutModel addWorkoutModel = null;
		 for(WorkoutCollectionEntity entity: workoutEntity) {
			 addWorkoutModel = new AddWorkoutModel();
			 addWorkoutModel.setCaloriesBurnt(Float.toString(entity.getCaloriesBurnt()));
			 addWorkoutModel.setStartDate(CommonUtil.formatDateForUI(entity.getWorkoutActiveEntity().getStartDate()));
			 addWorkoutModel.setEndDate(CommonUtil.formatDateForUI(entity.getWorkoutActiveEntity().getEndDate()));
			 addWorkoutModel.setWorkoutId(Integer.toString(entity.getWorkoutId()));
			 addWorkoutModel.setWorkoutTitle(entity.getWorkoutTitle());
			 addWorkoutModel.setStartTime(entity.getWorkoutActiveEntity().getStartTime().toString());
			 addWorkoutModel.setEndTime(entity.getWorkoutActiveEntity().getEndTime().toString());
			 workoutsList.add(addWorkoutModel);
		 }
		 return workoutsList;
	 }
	  
	
}
