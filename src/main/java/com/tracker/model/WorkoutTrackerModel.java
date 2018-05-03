package com.tracker.model;

public class WorkoutTrackerModel {
	
	private Integer workoutTimeOfDay;
	
	private Integer workoutTimeOfWeek;
	
	private Integer workoutTimeOfMonth;
	
	private Integer weeklyCaloriesBurnt;
	
	private Integer monthlyCaloriesBurnt;
	
	private Integer yearlyCaloriesBurnt;

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

	public Integer getWeeklyCaloriesBurnt() {
		return weeklyCaloriesBurnt;
	}

	public void setWeeklyCaloriesBurnt(Integer weeklyCaloriesBurnt) {
		this.weeklyCaloriesBurnt = weeklyCaloriesBurnt;
	}

	public Integer getMonthlyCaloriesBurnt() {
		return monthlyCaloriesBurnt;
	}

	public void setMonthlyCaloriesBurnt(Integer monthlyCaloriesBurnt) {
		this.monthlyCaloriesBurnt = monthlyCaloriesBurnt;
	}

	public Integer getYearlyCaloriesBurnt() {
		return yearlyCaloriesBurnt;
	}

	public void setYearlyCaloriesBurnt(Integer yearlyCaloriesBurnt) {
		this.yearlyCaloriesBurnt = yearlyCaloriesBurnt;
	}

	@Override
	public String toString() {
		return "WorkoutTrackerModel [workoutTimeOfDay=" + workoutTimeOfDay + ", workoutTimeOfWeek=" + workoutTimeOfWeek
				+ ", workoutTimeOfMonth=" + workoutTimeOfMonth + ", weeklyCaloriesBurnt=" + weeklyCaloriesBurnt
				+ ", monthlyCaloriesBurnt=" + monthlyCaloriesBurnt + ", yearlyCaloriesBurnt=" + yearlyCaloriesBurnt
				+ "]";
	}
	
	

}
