package com.tracker.intf;

import java.util.List;

import com.tracker.Exception.BusinessException;
import com.tracker.model.AddWorkoutModel;
import com.tracker.model.StartEndWorkoutModel;

public interface IWorkoutService {

	public String addWorkout(AddWorkoutModel addWorkoutModel)  throws BusinessException;
	
	public List<AddWorkoutModel> viewAllWorkouts();
	
	public String deleteWorkout(String workoutTitle);

	public List<AddWorkoutModel> editWorkout(String workoutId);
	
	public String startWorkout(AddWorkoutModel startEndWorkoutModel) throws BusinessException;
}
