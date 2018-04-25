package com.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.AddWorkoutModel;
import com.tracker.service.WorkoutServiceImpl;

@RestController
@RequestMapping("/viewWorkout")
public class ViewAllWorkoutController {

	@Autowired
	WorkoutServiceImpl workoutService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<AddWorkoutModel> viewAllWorkout() {
		System.out.println("***********************************************");
		System.out.println("Inside VIEW ALL WORKOUT");
		System.out.println("***********************************************");
		List<AddWorkoutModel> workoutsList = new ArrayList<AddWorkoutModel>() ;
		try {
			workoutsList = workoutService.viewAllWorkouts();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return workoutsList;
		
	}
}
