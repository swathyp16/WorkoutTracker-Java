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
import com.tracker.model.CategoryModel;
import com.tracker.model.StartEndWorkoutModel;
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
	public String deleteCategory(@RequestBody AddWorkoutModel workoutModel) throws BusinessException {
		System.out.println("***********************************************");
		System.out.println("Inside DELETE WORKOUT" + workoutModel.toString());
		System.out.println("***********************************************");
		String respStr = null;
		//try {
			respStr = workoutService.deleteWorkout(workoutModel.getWorkoutId());
		//}catch(Exception e) {
		//	e.printStackTrace();
		//}
		return respStr;		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/editWorkout/{workoutId}",method=RequestMethod.GET)
	public List<AddWorkoutModel> editWorkout(@PathVariable String workoutId) {
		System.out.println("***********************************************");
		System.out.println("Inside EDIT WORKOUT" + workoutId);
		System.out.println("***********************************************");
		List<AddWorkoutModel> editModel = new ArrayList<AddWorkoutModel>();
		try {
			editModel = workoutService.editWorkout(workoutId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return editModel;		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/startWorkout",method=RequestMethod.POST)
	public String startWorkout(@RequestBody AddWorkoutModel startWorkoutModel)throws BusinessException {
		System.out.println("***********************************************");
		System.out.println("Inside START WORKOUT" + startWorkoutModel.toString());
		System.out.println("***********************************************");
		String respStr = workoutService.startWorkout(startWorkoutModel);
		return respStr;		
	}
	
}
