package com.tracker.model;

/**
 * The Class AddWorkoutModel.
 */
public class AddWorkoutModel {

	/** The workout id. */
	private String workoutId;
	
	/** The workout title. */
	private String workoutTitle;
	
	/** The workout note. */
	private String workoutNote;
	
	/** The calories burnt. */
	private String caloriesBurnt;
	
	/** The category id. */
	private String categoryId;
	
	/** The start date. */
	public String startDate;
	
	/** The start time. */
	public String startTime;
	
	/** The end date. */
	public String endDate;
	
	/** The end time. */
	public String endTime;
	
	/** The start workout flag. */
	public boolean startWorkoutFlag;
	
	/** The category name. */
	public String categoryName;
	

	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Checks if is start workout flag.
	 *
	 * @return true, if is start workout flag
	 */
	public boolean isStartWorkoutFlag() {
		return startWorkoutFlag;
	}

	/**
	 * Sets the start workout flag.
	 *
	 * @param startWorkoutFlag the new start workout flag
	 */
	public void setStartWorkoutFlag(boolean startWorkoutFlag) {
		this.startWorkoutFlag = startWorkoutFlag;
	}

	/**
	 * Gets the workout id.
	 *
	 * @return the workout id
	 */
	public String getWorkoutId() {
		return workoutId;
	}

	/**
	 * Sets the workout id.
	 *
	 * @param workoutId the new workout id
	 */
	public void setWorkoutId(String workoutId) {
		this.workoutId = workoutId;
	}

	/**
	 * Gets the workout title.
	 *
	 * @return the workout title
	 */
	public String getWorkoutTitle() {
		return workoutTitle;
	}

	/**
	 * Sets the workout title.
	 *
	 * @param workoutTitle the new workout title
	 */
	public void setWorkoutTitle(String workoutTitle) {
		this.workoutTitle = workoutTitle;
	}

	/**
	 * Gets the workout note.
	 *
	 * @return the workout note
	 */
	public String getWorkoutNote() {
		return workoutNote;
	}

	/**
	 * Sets the workout note.
	 *
	 * @param workoutNote the new workout note
	 */
	public void setWorkoutNote(String workoutNote) {
		this.workoutNote = workoutNote;
	}

	/**
	 * Gets the calories burnt.
	 *
	 * @return the calories burnt
	 */
	public String getCaloriesBurnt() {
		return caloriesBurnt;
	}

	/**
	 * Sets the calories burnt.
	 *
	 * @param caloriesBurnt the new calories burnt
	 */
	public void setCaloriesBurnt(String caloriesBurnt) {
		this.caloriesBurnt = caloriesBurnt;
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the category id.
	 *
	 * @param categoryId the new category id
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime the new start time
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime the new end time
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddWorkoutModel [workoutId=" + workoutId + ", workoutTitle=" + workoutTitle + ", workoutNote="
				+ workoutNote + ", caloriesBurnt=" + caloriesBurnt + ", categoryId=" + categoryId + ", startDate="
				+ startDate + ", startTime=" + startTime + ", endDate=" + endDate + ", endTime=" + endTime
				+ ", startWorkoutFlag=" + startWorkoutFlag + "]";
	}

	
	
}
