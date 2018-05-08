package com.tracker.model;

import java.util.List;

public class WorkoutTrackerModel {
	
	private Integer workoutTimeOfDay;
	
	private Integer workoutTimeOfWeek;
	
	private Integer workoutTimeOfMonth;
	
	private List<AddWorkoutModel> weeklyWorkouts;
	
	private List<AddWorkoutModel> monthlyWorkouts;
	
	private List<AddWorkoutModel> yearlyWorkouts;

	public Integer getWorkoutTimeOfDay() {
		return workoutTimeOfDay;
	}

	public void setWorkoutTimeOfDay(Integer workoutTimeOfDay) {
		this.workoutTimeOfDay = workoutTimeOfDay;
	}

	public Integer getWorkoutTimeOfWeek() {
		return workoutTimeOfWeek;
	}

	public void setWorkoutTimeOfWeek(Integer workoutTimeOfWeek) {
		this.workoutTimeOfWeek = workoutTimeOfWeek;
	}

	public Integer getWorkoutTimeOfMonth() {
		return workoutTimeOfMonth;
	}

	public void setWorkoutTimeOfMonth(Integer workoutTimeOfMonth) {
		this.workoutTimeOfMonth = workoutTimeOfMonth;
	}

	public List<AddWorkoutModel> getWeeklyWorkouts() {
		return weeklyWorkouts;
	}

	public void setWeeklyWorkouts(List<AddWorkoutModel> weeklyWorkouts) {
		this.weeklyWorkouts = weeklyWorkouts;
	}

	public List<AddWorkoutModel> getMonthlyWorkouts() {
		return monthlyWorkouts;
	}

	public void setMonthlyWorkouts(List<AddWorkoutModel> monthlyWorkouts) {
		this.monthlyWorkouts = monthlyWorkouts;
	}

	public List<AddWorkoutModel> getYearlyWorkouts() {
		return yearlyWorkouts;
	}

	public void setYearlyWorkouts(List<AddWorkoutModel> yearlyWorkouts) {
		this.yearlyWorkouts = yearlyWorkouts;
	}

	@Override
	public String toString() {
		return "WorkoutTrackerModel [workoutTimeOfDay=" + workoutTimeOfDay + ", workoutTimeOfWeek=" + workoutTimeOfWeek
				+ ", workoutTimeOfMonth=" + workoutTimeOfMonth + ", weeklyWorkouts=" + weeklyWorkouts
				+ ", monthlyWorkouts=" + monthlyWorkouts + ", yearlyWorkouts=" + yearlyWorkouts + "]";
	}	
	
	

}
