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

import com.tracker.model.AddWorkoutModel;
import com.tracker.model.CategoryModel;
import com.tracker.service.WorkoutServiceImpl;

@RestController
public class ViewAllWorkoutController {

	@Autowired
	WorkoutServiceImpl workoutService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/viewAllWorkout",method=RequestMethod.GET)
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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/deleteWorkout",method=RequestMethod.POST)
	public String deleteCategory(@RequestBody AddWorkoutModel workoutModel) {
		System.out.println("***********************************************");
		System.out.println("Inside DELETE WORKOUT" + workoutModel.toString());
		System.out.println("***********************************************");
		String respStr = null;
		try {
			respStr = workoutService.deleteWorkout(workoutModel.getWorkoutTitle());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return respStr;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
<<<<<<< HEAD
	@RequestMapping(value="/editWorkout/{workoutId}",method=RequestMethod.GET)
	public List<AddWorkoutModel> editWorkout(@PathVariable String workoutId) {
		System.out.println("***********************************************");
		System.out.println("Inside EDIT WORKOUT" + workoutId);
		System.out.println("***********************************************");
		List<AddWorkoutModel> editModel = new ArrayList<AddWorkoutModel>();
=======
	@RequestMapping(value="/editWorkout",method=RequestMethod.POST)
	public AddWorkoutModel editWorkout(@RequestBody String workoutId) {
		System.out.println("***********************************************");
		System.out.println("Inside EDIT WORKOUT" + workoutId);
		System.out.println("***********************************************");
		AddWorkoutModel editModel = new AddWorkoutModel();
>>>>>>> 90497c4e7b3df48beacf17c33a55f2bd2917e617
		try {
			editModel = workoutService.editWorkout(workoutId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return editModel;
		
	}
}
