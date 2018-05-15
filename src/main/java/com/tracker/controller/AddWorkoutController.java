package com.tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.Exception.BusinessException;
import com.tracker.model.AddWorkoutModel;
import com.tracker.service.WorkoutServiceImpl;


/**
 * The Class AddWorkoutController.
 */
@CrossOrigin
@RestController
@RequestMapping("/createWorkout")
public class AddWorkoutController {
	
	/** The workout service. */
	@Autowired
	private WorkoutServiceImpl workoutService;
	
	/**
	 * Creates the workout.
	 *
	 * @param addWorkoutModel the add workout model
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	@RequestMapping(value="/all",method=RequestMethod.POST)
	public String createWorkout(@RequestBody AddWorkoutModel addWorkoutModel) throws BusinessException {
		String responseString = null;		
		responseString = workoutService.addWorkout(addWorkoutModel);
		return responseString;
		
	}
}
