package com.tracker.model;

import java.util.List;

/**
 * The Class WorkoutTrackerModel.
 */
public class WorkoutTrackerModel {
	
	/** The workout time of day. */
	private Integer workoutTimeOfDay;
	
	/** The workout time of week. */
	private Integer workoutTimeOfWeek;
	
	/** The workout time of month. */
	private Integer workoutTimeOfMonth;
	
	/** The weekly workouts. */
	private List<AddWorkoutModel> weeklyWorkouts;
	
	/** The monthly workouts. */
	private List<AddWorkoutModel> monthlyWorkouts;
	
	/** The yearly workouts. */
	private List<AddWorkoutModel> yearlyWorkouts;

	/**
	 * Gets the workout time of day.
	 *
	 * @return the workout time of day
	 */
	public Integer getWorkoutTimeOfDay() {
		return workoutTimeOfDay;
	}

	/**
	 * Sets the workout time of day.
	 *
	 * @param workoutTimeOfDay the new workout time of day
	 */
	public void setWorkoutTimeOfDay(Integer workoutTimeOfDay) {
		this.workoutTimeOfDay = workoutTimeOfDay;
	}

	/**
	 * Gets the workout time of week.
	 *
	 * @return the workout time of week
	 */
	public Integer getWorkoutTimeOfWeek() {
		return workoutTimeOfWeek;
	}

	/**
	 * Sets the workout time of week.
	 *
	 * @param workoutTimeOfWeek the new workout time of week
	 */
	public void setWorkoutTimeOfWeek(Integer workoutTimeOfWeek) {
		this.workoutTimeOfWeek = workoutTimeOfWeek;
	}

	/**
	 * Gets the workout time of month.
	 *
	 * @return the workout time of month
	 */
	public Integer getWorkoutTimeOfMonth() {
		return workoutTimeOfMonth;
	}

	/**
	 * Sets the workout time of month.
	 *
	 * @param workoutTimeOfMonth the new workout time of month
	 */
	public void setWorkoutTimeOfMonth(Integer workoutTimeOfMonth) {
		this.workoutTimeOfMonth = workoutTimeOfMonth;
	}

	/**
	 * Gets the weekly workouts.
	 *
	 * @return the weekly workouts
	 */
	public List<AddWorkoutModel> getWeeklyWorkouts() {
		return weeklyWorkouts;
	}

	/**
	 * Sets the weekly workouts.
	 *
	 * @param weeklyWorkouts the new weekly workouts
	 */
	public void setWeeklyWorkouts(List<AddWorkoutModel> weeklyWorkouts) {
		this.weeklyWorkouts = weeklyWorkouts;
	}

	/**
	 * Gets the monthly workouts.
	 *
	 * @return the monthly workouts
	 */
	public List<AddWorkoutModel> getMonthlyWorkouts() {
		return monthlyWorkouts;
	}

	/**
	 * Sets the monthly workouts.
	 *
	 * @param monthlyWorkouts the new monthly workouts
	 */
	public void setMonthlyWorkouts(List<AddWorkoutModel> monthlyWorkouts) {
		this.monthlyWorkouts = monthlyWorkouts;
	}

	/**
	 * Gets the yearly workouts.
	 *
	 * @return the yearly workouts
	 */
	public List<AddWorkoutModel> getYearlyWorkouts() {
		return yearlyWorkouts;
	}

	/**
	 * Sets the yearly workouts.
	 *
	 * @param yearlyWorkouts the new yearly workouts
	 */
	public void setYearlyWorkouts(List<AddWorkoutModel> yearlyWorkouts) {
		this.yearlyWorkouts = yearlyWorkouts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkoutTrackerModel [workoutTimeOfDay=" + workoutTimeOfDay + ", workoutTimeOfWeek=" + workoutTimeOfWeek
				+ ", workoutTimeOfMonth=" + workoutTimeOfMonth + ", weeklyWorkouts=" + weeklyWorkouts
				+ ", monthlyWorkouts=" + monthlyWorkouts + ", yearlyWorkouts=" + yearlyWorkouts + "]";
	}	
	
	

}
