package com.tracker.intf;

import java.util.List;

import com.tracker.model.AddWorkoutModel;

public interface IWorkoutService {

	public String addWorkout(AddWorkoutModel addWorkoutModel);
	
	public List<AddWorkoutModel> viewAllWorkouts();
	
	public String deleteWorkout(String workoutTitle);
	
<<<<<<< HEAD
	public List<AddWorkoutModel> editWorkout(String workoutId);
=======
	public AddWorkoutModel editWorkout(String workoutId);
>>>>>>> 90497c4e7b3df48beacf17c33a55f2bd2917e617
	
}
