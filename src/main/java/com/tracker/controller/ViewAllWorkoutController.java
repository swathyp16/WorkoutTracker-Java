package com.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.Exception.BusinessException;
import com.tracker.model.AddWorkoutModel;
import com.tracker.service.WorkoutServiceImpl;

/**
 * The Class ViewAllWorkoutController.
 */
@RestController
public class ViewAllWorkoutController {

	/** The workout service. */
	@Autowired
	private WorkoutServiceImpl workoutService;
	
	/**
	 * View all workout.
	 *
	 * @return the list
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/viewAllWorkout",method=RequestMethod.GET)
	public List<AddWorkoutModel> viewAllWorkout() {
		List<AddWorkoutModel> workoutsList =  workoutService.viewAllWorkouts();
		return workoutsList;
		
	}
	
	/**
	 * Delete category.
	 *
	 * @param workoutModel the workout model
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/deleteWorkout",method=RequestMethod.POST)
	public String deleteCategory(@RequestBody AddWorkoutModel workoutModel) throws BusinessException {
		String respStr = null;
		respStr = workoutService.deleteWorkout(workoutModel.getWorkoutId());
		return respStr;		
	}
	
	/**
	 * Edits the workout.
	 *
	 * @param workoutId the workout id
	 * @return the list
	 * @throws BusinessException the business exception
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/editWorkout/{workoutId}",method=RequestMethod.GET)
	public List<AddWorkoutModel> editWorkout(@PathVariable String workoutId) throws BusinessException {
		List<AddWorkoutModel> editModel = new ArrayList<AddWorkoutModel>();
		editModel = workoutService.editWorkout(workoutId);
		return editModel;		
	}
	
	/**
	 * Start workout.
	 *
	 * @param startWorkoutModel the start workout model
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/startWorkout",method=RequestMethod.POST)
	public String startWorkout(@RequestBody AddWorkoutModel startWorkoutModel)throws BusinessException {
		String respStr = workoutService.startWorkout(startWorkoutModel);
		return respStr;		
	}
	
}
