package com.tracker.intf;

import java.util.List;

import com.tracker.model.AddWorkoutModel;
import com.tracker.model.StartEndWorkoutModel;

public interface IWorkoutService {

	public String addWorkout(AddWorkoutModel addWorkoutModel);
	
	public List<AddWorkoutModel> viewAllWorkouts();
	
	public String deleteWorkout(String workoutTitle);

	public List<AddWorkoutModel> editWorkout(String workoutId);
	
	public String startWorkout(AddWorkoutModel startEndWorkoutModel);
}
