package com.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workout_collection")
public class WorkoutCollectionEntity {
	
	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		public int  workout_id;	    
 	
	    @Column(name="workout_title")
	    public String workoutTitle;
		
	    @Column(name="workout_note")
	    public String workoutNote;
	    
	    @Column(name="calories_burn_per_min")
	    public float caloriesBurnt;
	    
	    @Column(name="category_id")
	    public int categoryId;

		public int getWorkout_id() {
			return workout_id;
		}

		public void setWorkout_id(int workout_id) {
			this.workout_id = workout_id;
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
			return "WorkoutCollectionEntity [workout_id=" + workout_id + ", workoutTitle=" + workoutTitle
					+ ", workoutNote=" + workoutNote + ", caloriesBurnt=" + caloriesBurnt + ", categoryId=" + categoryId
					+ "]";
		}

		


}
