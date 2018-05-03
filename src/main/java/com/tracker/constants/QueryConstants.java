package com.tracker.constants;

public class QueryConstants {
	
	public static final String VIEW_WORKOUTS_QUERY = "select * from workout_collection";
	
	public static final String VIEW_CATEGORY_QUERY = "select * from workout_category";
	
	public static final String DELETE_WORKOUT_QUERY = "delete from WorkoutCollectionEntity A where A.workoutTitle = ?1";
	
	public static final String DELETE_CATEGORY_QUERY = "delete from CategoryEntity A where A.categoryName = ?1";
	
	public static final String FETCH_WORKOUT_TRACKER_QUERY = "select * from workout_active A where A.start_date = ?1 and A.status= 1";

}
