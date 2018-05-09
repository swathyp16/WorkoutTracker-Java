package com.tracker.constants;

/**
 * The Class QueryConstants.
 */
public class QueryConstants {
	
	/** The Constant VIEW_WORKOUTS_QUERY. */
	public static final String VIEW_WORKOUTS_QUERY = "select * from workout_collection";
	
	/** The Constant VIEW_CATEGORY_QUERY. */
	public static final String VIEW_CATEGORY_QUERY = "select * from workout_category";
	
	/** The Constant FETCH_START_WORKOUT_DETAILS. */
	public static final String FETCH_START_WORKOUT_DETAILS = "select * from workout_active where workout_id = ?1";
	
	/** The Constant DELETE_WORKOUT_QUERY. */
	public static final String DELETE_WORKOUT_QUERY = "delete from WorkoutCollectionEntity A where A.workoutTitle = ?1";
	
	/** The Constant DELETE_CATEGORY_QUERY. */
	public static final String DELETE_CATEGORY_QUERY = "delete from CategoryEntity A where A.categoryName = ?1";
	
	/** The Constant FETCH_WORKOUT_TRACKER_QUERY. */
	public static final String FETCH_WORKOUT_TRACKER_QUERY = "select * from workout_active A where A.start_date = ?1 and A.status= 1";
			
	/** The Constant FETCH_CURRENT_WORKOUTS. */
	public static final String FETCH_CURRENT_WORKOUTS = "SELECT A FROM WorkoutCollectionEntity A WHERE A.workoutActiveEntity.startDate >= ?1 and A.workoutActiveEntity.startDate <= ?2 and A.workoutActiveEntity.status= 1";
	
	/** The Constant FETCH_CURRENT_YEAR_WORKOUTS. */
	public static final String FETCH_CURRENT_YEAR_WORKOUTS = "SELECT A FROM WorkoutCollectionEntity A WHERE YEAR(A.workoutActiveEntity.startDate) = ?1  and A.workoutActiveEntity.status= 1";
	
}
