package com.tracker.dao;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.constants.CommonConstants;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.repository.WorkoutActiveRepository;

@Component("workoutTrackerDao")
public class WorkoutTrackerDao {
	
	@Autowired
	private WorkoutActiveRepository workoutActiveRepository;
	
	public List<WorkoutActiveEntity> fetchWorkoutTrackerData(String currentDate) {
		List<WorkoutActiveEntity> completedWorkoutsList = workoutActiveRepository.findCurrentDayWorkoutTime(currentDate,CommonConstants.WORKOUT_COMPLETED_STATUS);
		System.out.println("completedWorkoutsList: " + completedWorkoutsList);
		return completedWorkoutsList;
	}
	
	
	public void fetchCurrentWeekWorkouts() {
		LocalDate today = LocalDate.now();
		LocalDate monday = today;
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
	      monday = monday.minusDays(1);
	    }
	    LocalDate sunday = today;
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
	      sunday = sunday.plusDays(1);
	    }
		List<WorkoutActiveEntity> currentWeekWorkouts = workoutActiveRepository.fetchCurrentWeekWorkouts(monday,sunday);
		for(WorkoutActiveEntity workoutActiveEntity :currentWeekWorkouts) {
			System.out.println("**************************");
			System.out.println(workoutActiveEntity.toString());
			System.out.println("**************************");
		}
	}
	
	
	/*public static void main(String[] args) {
	    LocalDate today = LocalDate.now();

	    // Go backward to get Monday
	    LocalDate monday = today;
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
	      monday = monday.minusDays(1);
	    }

	    // Go forward to get Sunday
	    LocalDate sunday = today;
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
	      sunday = sunday.plusDays(1);
	    }

	   
	  }*/
	

}
