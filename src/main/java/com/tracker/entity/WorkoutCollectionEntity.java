package com.tracker.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="workout_collection")
public class WorkoutCollectionEntity {
	
	 	@Id
	 	@Column(name="workout_id")
	    @GeneratedValue(strategy=GenerationType.AUTO)
		public int  workoutId;	    
 	
	    @Column(name="workout_title")
	    public String workoutTitle;
		
	    @Column(name="workout_note")
	    public String workoutNote;
	    
	    @Column(name="calories_burn_per_min")
	    public float caloriesBurnt;
	    
	    @Column(name="category_id")
	    public int categoryId;	    
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @PrimaryKeyJoinColumn(name = "workout_id", referencedColumnName = "workout_id")
	    WorkoutActiveEntity workoutActiveEntity;		

		public int getWorkoutId() {
			return workoutId;
		}

		public void setWorkoutId(int workoutId) {
			this.workoutId = workoutId;
		}

		public WorkoutActiveEntity getWorkoutActiveEntity() {
			return workoutActiveEntity;
		}

		public void setWorkoutActiveEntity(WorkoutActiveEntity workoutActiveEntity) {
			this.workoutActiveEntity = workoutActiveEntity;
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

		public float getCaloriesBurnt() {
			return caloriesBurnt;
		}

		public void setCaloriesBurnt(float caloriesBurnt) {
			this.caloriesBurnt = caloriesBurnt;
		}

		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		@Override
		public String toString() {
			return "WorkoutCollectionEntity [workoutId=" + workoutId + ", workoutTitle=" + workoutTitle
					+ ", workoutNote=" + workoutNote + ", caloriesBurnt=" + caloriesBurnt + ", categoryId=" + categoryId
					+ ", workoutActiveEntity=" + workoutActiveEntity + "]";
		}

		
		


}
