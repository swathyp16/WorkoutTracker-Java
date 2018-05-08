package com.tracker.service;

import java.util.ArrayList;
import java.util.Calendar;
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

@Component
public class WorkoutTrackerServiceImpl implements IWorkoutTrackerService {
	
	@Autowired
	private WorkoutTrackerDao workoutTrackerDao;
	
	public WorkoutTrackerModel getWorkoutTrackerData() throws BusinessException {
		WorkoutTrackerModel workoutTrackerModel = new WorkoutTrackerModel();
		long dailyTimeDuration;
		Integer dailyTimeDurationInMinutes = 0;
		long weeklyTimeDuration;
		Integer weeklyTimeDurationInMinutes = 0;
		long monthlyTimeDuration;
		Integer monthlyTimeDurationInMinutes = 0;
		String currentDate = CommonUtil.formatCurrentDateToString(new Date());
		System.out.println("currentDate: " + currentDate);
		List<WorkoutActiveEntity> currentDayWorkouts = workoutTrackerDao.fetchWorkoutTrackerData(currentDate);
		for(WorkoutActiveEntity workoutActivity: currentDayWorkouts) {
			dailyTimeDuration= workoutActivity.getEndTime().getTime() - workoutActivity.getStartTime().getTime();
			dailyTimeDurationInMinutes = (int) (dailyTimeDurationInMinutes + TimeUnit.MILLISECONDS.toMinutes(dailyTimeDuration));		
		}
		System.out.println("Daily workout time : "+ dailyTimeDurationInMinutes);	
		workoutTrackerModel.setWorkoutTimeOfDay(dailyTimeDurationInMinutes);
		
		List<WorkoutCollectionEntity> currentWeeksWorkouts = workoutTrackerDao.fetchCurrentWeekWorkouts();
		List<AddWorkoutModel> weeklyWorkouts = mapEntityToWorkoutModel(currentWeeksWorkouts);
		workoutTrackerModel.setWeeklyWorkouts(weeklyWorkouts);
		for(WorkoutCollectionEntity weekWorkout: currentWeeksWorkouts) {
			WorkoutActiveEntity workoutActiveEntity = weekWorkout.getWorkoutActiveEntity();
			System.out.println("*****************************");
			System.out.println("Current week Workout : " + weekWorkout.toString());
			System.out.println("*****************************");
			if(workoutActiveEntity != null) {
				weeklyTimeDuration = workoutActiveEntity.getEndTime().getTime() - workoutActiveEntity.getStartTime().getTime();
				weeklyTimeDurationInMinutes = (int) (weeklyTimeDurationInMinutes + TimeUnit.MILLISECONDS.toMinutes(weeklyTimeDuration));
			}
			
		}
		System.out.println("Weekly workout time : "+ weeklyTimeDurationInMinutes);	
		workoutTrackerModel.setWorkoutTimeOfWeek(weeklyTimeDurationInMinutes);
		
		
		List<WorkoutCollectionEntity> currentMonthWorkouts = workoutTrackerDao.fetchCurrentMonthWorkouts();
		List<AddWorkoutModel> monthlyWorkouts = mapEntityToWorkoutModel(currentMonthWorkouts);
		workoutTrackerModel.setMonthlyWorkouts(monthlyWorkouts);
		for(WorkoutCollectionEntity monthlyWorkout: currentMonthWorkouts) {
			WorkoutActiveEntity workoutActiveEntity = monthlyWorkout.getWorkoutActiveEntity();
			System.out.println("*****************************");
			System.out.println("Current month Workout : " + monthlyWorkout.toString());
			System.out.println("*****************************");
			if(workoutActiveEntity != null) {
				monthlyTimeDuration = workoutActiveEntity.getEndTime().getTime() - workoutActiveEntity.getStartTime().getTime();
				monthlyTimeDurationInMinutes = (int) (monthlyTimeDurationInMinutes + TimeUnit.MILLISECONDS.toMinutes(monthlyTimeDuration));
			}			
		}
		System.out.println("Monthly workout time : "+ monthlyTimeDurationInMinutes);
		workoutTrackerModel.setWorkoutTimeOfMonth(monthlyTimeDurationInMinutes);
		
		
		List<WorkoutCollectionEntity> currentYearWorkouts = workoutTrackerDao.fetchCurrentYearWorkouts();
		List<AddWorkoutModel> yearlyWorkouts = mapEntityToWorkoutModel(currentYearWorkouts);
		workoutTrackerModel.setYearlyWorkouts(yearlyWorkouts);
		for(WorkoutCollectionEntity yearlyWorkout : currentYearWorkouts) {
			System.out.println("*****************************");
			System.out.println("Current Year Workout : " + yearlyWorkout.toString());
			System.out.println("*****************************");
		}		
		
		return workoutTrackerModel;
	}
	
	
	
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
			 workoutsList.add(addWorkoutModel);
		 }
		 return workoutsList;
	 }
	  
	
}
