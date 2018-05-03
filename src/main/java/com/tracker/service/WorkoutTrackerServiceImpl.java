package com.tracker.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.Exception.BusinessException;
import com.tracker.dao.WorkoutTrackerDao;
import com.tracker.entity.WorkoutActiveEntity;
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
		long timeDurationInMinutes;
		String currentDate = CommonUtil.formatCurrentDateToString(new Date());
		System.out.println("currentDate: " + currentDate);
		List<WorkoutActiveEntity> completedWorkoutsList = workoutTrackerDao.fetchWorkoutTrackerData(currentDate);
		for(WorkoutActiveEntity workoutActivity: completedWorkoutsList) {
			timeDuration= workoutActivity.getStartTime().getTime() - workoutActivity.getEndTime().getTime();
			timeDurationInMinutes = TimeUnit.MILLISECONDS.toMinutes(timeDuration);
			System.out.println("timeDurationInMinutes : "+ timeDurationInMinutes);
			
		}
		return workoutTrackerModel;
	}
	
}
