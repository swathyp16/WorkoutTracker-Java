package com.tracker.controller;


import java.awt.PageAttributes.MediaType;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.AddWorkoutModel;


@RestController
@RequestMapping("/createWorkout")
public class AddWorkoutController {

	@RequestMapping(value="/all",method=RequestMethod.POST, headers="Accept=application/x-www-form-urlencoded")
	public void createWorkout(AddWorkoutModel addWorkoutModel) {
		System.out.println("***********************************************");
		System.out.println(addWorkoutModel.toString());
		System.out.println("***********************************************");
	}
}
