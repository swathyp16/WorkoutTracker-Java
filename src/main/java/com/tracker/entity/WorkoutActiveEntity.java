package com.tracker.entity;



import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="workout_active")
public class WorkoutActiveEntity {

	@Id
	@Column(name="workout_id")
	public int workoutId;
	
	@Column(name="start_time")
	public Time startTime;
	
	@Column(name="start_date")
	public Date startDate;
	
	@Column(name="end_date")
	public Date endDate;
	
	@Column(name="end_time")
	public Time endTime;
	
	@Column(name="comment")
	public String comment;
	
	@Column(name="status")
	public boolean status;
	

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "WorkoutActiveEntity [startTime=" + startTime + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", endTime=" + endTime + ", comment=" + comment + ", status=" + status + "]";
	}

	
	
	
}
