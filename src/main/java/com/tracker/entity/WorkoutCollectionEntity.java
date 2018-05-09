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

/**
 * The Class WorkoutCollectionEntity.
 */
@Entity
@Table(name="workout_collection")
public class WorkoutCollectionEntity {
	
	 	/** The workout id. */
	 	@Id
	 	@Column(name="workout_id")
	    @GeneratedValue(strategy=GenerationType.AUTO)
		public int  workoutId;	    
 	
	    /** The workout title. */
    	@Column(name="workout_title")
	    public String workoutTitle;
		
	    /** The workout note. */
    	@Column(name="workout_note")
	    public String workoutNote;
	    
	    /** The calories burnt. */
    	@Column(name="calories_burn_per_min")
	    public float caloriesBurnt;
	    
	    /** The category id. */
    	@Column(name="category_id")
	    public int categoryId;	    
	    
	    /** The workout active entity. */
    	@OneToOne(cascade = CascadeType.ALL)
	    @PrimaryKeyJoinColumn(name = "workout_id", referencedColumnName = "workout_id")
	    WorkoutActiveEntity workoutActiveEntity;		

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
		 * Gets the workout active entity.
		 *
		 * @return the workout active entity
		 */
		public WorkoutActiveEntity getWorkoutActiveEntity() {
			return workoutActiveEntity;
		}

		/**
		 * Sets the workout active entity.
		 *
		 * @param workoutActiveEntity the new workout active entity
		 */
		public void setWorkoutActiveEntity(WorkoutActiveEntity workoutActiveEntity) {
			this.workoutActiveEntity = workoutActiveEntity;
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
		public float getCaloriesBurnt() {
			return caloriesBurnt;
		}

		/**
		 * Sets the calories burnt.
		 *
		 * @param caloriesBurnt the new calories burnt
		 */
		public void setCaloriesBurnt(float caloriesBurnt) {
			this.caloriesBurnt = caloriesBurnt;
		}

		/**
		 * Gets the category id.
		 *
		 * @return the category id
		 */
		public int getCategoryId() {
			return categoryId;
		}

		/**
		 * Sets the category id.
		 *
		 * @param categoryId the new category id
		 */
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "WorkoutCollectionEntity [workoutId=" + workoutId + ", workoutTitle=" + workoutTitle
					+ ", workoutNote=" + workoutNote + ", caloriesBurnt=" + caloriesBurnt + ", categoryId=" + categoryId
					+ ", workoutActiveEntity=" + workoutActiveEntity + "]";
		}

		
		


}
