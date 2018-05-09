package com.tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.Exception.BusinessException;
import com.tracker.model.WorkoutTrackerModel;
import com.tracker.service.WorkoutTrackerServiceImpl;

/**
 * The Class WorkoutTrackerController.
 */
@RestController
public class WorkoutTrackerController {
	
	/** The workout tracker service. */
	@Autowired
	private WorkoutTrackerServiceImpl workoutTrackerService;
	
	/**
	 * Gets the workout tracker data.
	 *
	 * @return the workout tracker data
	 * @throws BusinessException the business exception
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/workoutTracker",method=RequestMethod.GET)
	public WorkoutTrackerModel getWorkoutTrackerData() throws BusinessException {
		WorkoutTrackerModel workoutTrackerModel = workoutTrackerService.getWorkoutTrackerData();
		return workoutTrackerModel;
		
	}

}
