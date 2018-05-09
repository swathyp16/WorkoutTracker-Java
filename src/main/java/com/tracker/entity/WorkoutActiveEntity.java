package com.tracker.entity;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class WorkoutActiveEntity.
 */
@Entity
@Table(name="workout_active")
public class WorkoutActiveEntity {

	/** The workout id. */
	@Id
	@Column(name="workout_id")
	public int workoutId;
	
	/** The start time. */
	@Column(name="start_time")
	public Time startTime;
	
	/** The start date. */
	@Column(name="start_date")
	public Date startDate;
	
	/** The end date. */
	@Column(name="end_date")
	public Date endDate;
	
	/** The end time. */
	@Column(name="end_time")
	public Time endTime;
	
	/** The comment. */
	@Column(name="comment")
	public String comment;
	
	/** The status. */
	@Column(name="status")
	public boolean status;
	

	/**
	 * Gets the workout id.
	 *
	 * @return the workout id
	 */
	public int getWorkoutId() {
		return workoutId;
	}

	/**
	 * Sets the workout id.
	 *
	 * @param workoutId the new workout id
	 */
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public Time getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime the new start time
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public Time getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime the new end time
	 */
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Checks if is status.
	 *
	 * @return true, if is status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkoutActiveEntity [startTime=" + startTime + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", endTime=" + endTime + ", comment=" + comment + ", status=" + status + "]";
	}

	
	
	
}
