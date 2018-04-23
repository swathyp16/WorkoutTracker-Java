package tracker.model;

public class AddWorkoutModel {

	private int workoutId;
	
	private String workoutTitle;
	
	private String workoutNote;
	
	private float caloriesBurnt;
	
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

	@Override
	public String toString() {
		return "AddWorkoutModel [workoutId=" + workoutId + ", workoutTitle=" + workoutTitle + ", workoutNote="
				+ workoutNote + ", caloriesBurnt=" + caloriesBurnt + ", categoryId=" + categoryId + "]";
	}

	
	
}
