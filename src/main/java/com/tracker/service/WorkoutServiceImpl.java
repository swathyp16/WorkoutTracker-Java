package com.tracker.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tracker.constants.CommonConstants;
import com.tracker.intf.IWorkoutService;
import com.tracker.model.AddWorkoutModel;
import com.tracker.util.HibernateUtil;

@Component
public class WorkoutServiceImpl implements IWorkoutService{
	
	@Override
	public String addWorkout(AddWorkoutModel addWorkoutModel) {
		HibernateUtil.insertInfo(addWorkoutModel);
		return CommonConstants.SUCCESS_RESPONSE;
		
	}
	
	@Override
	public List<AddWorkoutModel> viewAllWorkouts() {
		List<AddWorkoutModel> workoutsList = HibernateUtil.getInfo();
		return workoutsList;
		
	}

}
