package com.tracker.intf;

import java.util.List;

import com.tracker.Exception.BusinessException;
import com.tracker.model.AddWorkoutModel;

/**
 * The Interface IWorkoutService.
 */
public interface IWorkoutService {

	/**
	 * Adds the workout.
	 *
	 * @param addWorkoutModel the add workout model
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	public String addWorkout(AddWorkoutModel addWorkoutModel)  throws BusinessException;
	
	/**
	 * View all workouts.
	 *
	 * @return the list
	 */
	public List<AddWorkoutModel> viewAllWorkouts();
	
	/**
	 * Delete workout.
	 *
	 * @param workoutTitle the workout title
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	public String deleteWorkout(String workoutTitle)throws BusinessException;

	/**
	 * Edits the workout.
	 *
	 * @param workoutId the workout id
	 * @return the list
	 * @throws BusinessException the business exception
	 */
	public List<AddWorkoutModel> editWorkout(String workoutId) throws BusinessException;
	
	/**
	 * Start workout.
	 *
	 * @param startEndWorkoutModel the start end workout model
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	public String startWorkout(AddWorkoutModel startEndWorkoutModel) throws BusinessException;
}
