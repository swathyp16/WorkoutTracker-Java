package com.tracker.model;

public class AddWorkoutModel {

	private String workoutId;
	
	private String workoutTitle;
	
	private String workoutNote;
	
	private String caloriesBurnt;
	
	private String categoryId;

	public String getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(String workoutId) {
		this.workoutId = workoutId;
	}

	public String getWorkoutTitle() {
		return workoutTitle;
	}

	public void setWorkoutTitle(String workoutTitle) {
		this.workoutTitle = workoutTitle;
	}

	public String getWorkoutNote() {
		return workoutNote;
	}

	public void setWorkoutNote(String workoutNote) {
		this.workoutNote = workoutNote;
	}

	public String getCaloriesBurnt() {
		return caloriesBurnt;
	}

	public void setCaloriesBurnt(String caloriesBurnt) {
		this.caloriesBurnt = caloriesBurnt;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "AddWorkoutModel [workoutId=" + workoutId + ", workoutTitle=" + workoutTitle + ", workoutNote="
				+ workoutNote + ", caloriesBurnt=" + caloriesBurnt + ", categoryId=" + categoryId + "]";
	}

	
	
}
