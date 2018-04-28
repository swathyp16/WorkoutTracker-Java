package com.tracker.model;

public class AddWorkoutModel {

	private String workoutId;
	
	private String workoutTitle;
	
	private String workoutNote;
	
	private String caloriesBurnt;
	
	private String categoryId;
	
	public String startDate;
	
	public String startTime;
	
	public String endDate;
	
	public String endTime;
	
	public boolean startWorkoutFlag;	
	

	public boolean isStartWorkoutFlag() {
		return startWorkoutFlag;
	}

	public void setStartWorkoutFlag(boolean startWorkoutFlag) {
		this.startWorkoutFlag = startWorkoutFlag;
	}

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "AddWorkoutModel [workoutId=" + workoutId + ", workoutTitle=" + workoutTitle + ", workoutNote="
				+ workoutNote + ", caloriesBurnt=" + caloriesBurnt + ", categoryId=" + categoryId + ", startDate="
				+ startDate + ", startTime=" + startTime + ", endDate=" + endDate + ", endTime=" + endTime
				+ ", startWorkoutFlag=" + startWorkoutFlag + "]";
	}

	
	
}
