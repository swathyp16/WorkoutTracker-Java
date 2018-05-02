package com.tracker.controller;


import java.awt.PageAttributes.MediaType;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.Exception.BusinessException;
import com.tracker.model.AddWorkoutModel;
import com.tracker.service.WorkoutServiceImpl;


@RestController
@RequestMapping("/createWorkout")
public class AddWorkoutController {
	
	@Autowired
	WorkoutServiceImpl workoutService;
	
	@CrossOrigin//(origins = "http://localhost:4200")
	@RequestMapping(value="/all",method=RequestMethod.POST)
	public String createWorkout(@RequestBody AddWorkoutModel addWorkoutModel) throws BusinessException {
		System.out.println("***********************************************");
		System.out.println(addWorkoutModel.toString());
		System.out.println("***********************************************");
		String responseString = null;		
		responseString = workoutService.addWorkout(addWorkoutModel);
		return responseString;
		
	}
}
