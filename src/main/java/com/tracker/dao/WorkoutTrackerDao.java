package com.tracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.constants.CommonConstants;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.repository.WorkoutActiveRepository;

@Component("workoutTrackerDao")
public class WorkoutTrackerDao {
	
	@Autowired
	private WorkoutActiveRepository workoutActiveRepository;
	
	public List<WorkoutActiveEntity> fetchWorkoutTrackerData(String currentDate) {
		List<WorkoutActiveEntity> completedWorkoutsList = workoutActiveRepository.findCurrentDayWorkoutTime(currentDate,CommonConstants.WORKOUT_COMPLETED_STATUS);
		System.out.println("completedWorkoutsList: " + completedWorkoutsList);
		return completedWorkoutsList;
	}
	
	

}
