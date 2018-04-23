package tracker.entity;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="workout_id")
	private int workoutId;
	
	@Column(name="workout_title")
	private String workoutTitle;
	
	@Column(name="workout_note")
	private String workoutNote;
	
	@Column(name="calories_burn_per_min")
	private float caloriesBurnt;
	
	@Column(name="category_id")
	private int categoryId;

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
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
	
	


}
