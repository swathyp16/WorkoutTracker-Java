package com.tracker.model;

/**
 * The Class StartEndWorkoutModel.
 */
public class StartEndWorkoutModel extends AddWorkoutModel{

	/** The start date. */
	public String startDate;
	
	/** The start time. */
	public String startTime;
	
	/** The end date. */
	public String endDate;
	
	/** The end time. */
	public String endTime;

	
	/* (non-Javadoc)
	 * @see com.tracker.model.AddWorkoutModel#getStartDate()
	 */
	public String getStartDate() {
		return startDate;
	}

	/* (non-Javadoc)
	 * @see com.tracker.model.AddWorkoutModel#setStartDate(java.lang.String)
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/* (non-Javadoc)
	 * @see com.tracker.model.AddWorkoutModel#getStartTime()
	 */
	public String getStartTime() {
		return startTime;
	}

	/* (non-Javadoc)
	 * @see com.tracker.model.AddWorkoutModel#setStartTime(java.lang.String)
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/* (non-Javadoc)
	 * @see com.tracker.model.AddWorkoutModel#getEndDate()
	 */
	public String getEndDate() {
		return endDate;
	}

	/* (non-Javadoc)
	 * @see com.tracker.model.AddWorkoutModel#setEndDate(java.lang.String)
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/* (non-Javadoc)
	 * @see com.tracker.model.AddWorkoutModel#getEndTime()
	 */
	public String getEndTime() {
		return endTime;
	}

	/* (non-Javadoc)
	 * @see com.tracker.model.AddWorkoutModel#setEndTime(java.lang.String)
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/* (non-Javadoc)
	 * @see com.tracker.model.AddWorkoutModel#toString()
	 */
	@Override
	public String toString() {
		return "StartEndWorkoutModel [startDate=" + startDate + ", startTime=" + startTime + ", endDate=" + endDate
				+ ", endTime=" + endTime + "]";
	}
	
	

}
