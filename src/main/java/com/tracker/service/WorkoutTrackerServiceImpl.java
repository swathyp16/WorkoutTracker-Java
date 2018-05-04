package com.tracker.service;

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
import com.tracker.model.WorkoutTrackerModel;
import com.tracker.util.CommonUtil;

@Component
public class WorkoutTrackerServiceImpl implements IWorkoutTrackerService {
	
	@Autowired
	private WorkoutTrackerDao workoutTrackerDao;
	
	public WorkoutTrackerModel getWorkoutTrackerData() throws BusinessException {
		WorkoutTrackerModel workoutTrackerModel = new WorkoutTrackerModel();
		long timeDuration;
		Integer timeDurationInMinutes = 0;
		long weeklyTimeDuration;
		Integer weeklyTimeDurationInMinutes = 0;
		String currentDate = CommonUtil.formatCurrentDateToString(new Date());
		System.out.println("currentDate: " + currentDate);
		List<WorkoutActiveEntity> completedWorkoutsList = workoutTrackerDao.fetchWorkoutTrackerData(currentDate);
		for(WorkoutActiveEntity workoutActivity: completedWorkoutsList) {
			timeDuration= workoutActivity.getEndTime().getTime() - workoutActivity.getStartTime().getTime();
			timeDurationInMinutes = (int) (timeDurationInMinutes + TimeUnit.MILLISECONDS.toMinutes(timeDuration));		
		}
		System.out.println("Daily workout time : "+ timeDurationInMinutes);	
		workoutTrackerModel.setWorkoutTimeOfDay(timeDurationInMinutes);
		List<WorkoutCollectionEntity> currentWeeksWorkouts = workoutTrackerDao.fetchCurrentWeekWorkouts();
		for(WorkoutCollectionEntity weekWorkout: currentWeeksWorkouts) {
			WorkoutActiveEntity workoutActiveEntity = weekWorkout.getWorkoutActiveEntity();
			if(workoutActiveEntity != null) {
				weeklyTimeDuration = workoutActiveEntity.getEndTime().getTime() - workoutActiveEntity.getStartTime().getTime();
				weeklyTimeDurationInMinutes = (int) (weeklyTimeDurationInMinutes + TimeUnit.MILLISECONDS.toMinutes(weeklyTimeDuration));
			}
			
		}
		System.out.println("Weekly workout time : "+ weeklyTimeDurationInMinutes);	
		return workoutTrackerModel;
	}
	
	
	
	 private void findStartAndEndDateOfMonth() {
		 Calendar calendar = Calendar.getInstance();
		 int yearpart = 2018;
		  int monthPart = 11;
		  int dateDay = 1;
		  calendar.set(yearpart, monthPart, dateDay);
		  int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		  System.out.println("Number of Days: " + numOfDaysInMonth);
		  System.out.println("First Day of month: " + calendar.getTime());
		  calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth-1);


		  System.out.println("Last Day of month: " + calendar.getTime());
	 }
	  
	
}
