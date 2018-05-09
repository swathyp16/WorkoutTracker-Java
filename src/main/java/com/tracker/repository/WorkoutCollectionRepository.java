package com.tracker.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.WorkoutCollectionEntity;

/**
 * The Interface WorkoutCollectionRepository.
 */
@Repository
public interface WorkoutCollectionRepository extends JpaRepository<WorkoutCollectionEntity, Integer>{
	
	/**
	 * Delete by workout title.
	 *
	 * @param workoutTitle the workout title
	 */
	@Query(value=QueryConstants.DELETE_WORKOUT_QUERY)
	void deleteByWorkoutTitle(String workoutTitle);
	
	/**
	 * Fetch current week workouts.
	 *
	 * @param monday the monday
	 * @param sunday the sunday
	 * @return the list
	 */
	@Query(value = QueryConstants.FETCH_CURRENT_WORKOUTS)
	List<WorkoutCollectionEntity> fetchCurrentWeekWorkouts(Date monday, Date sunday);
	
	/**
	 * Fetch current month workouts.
	 *
	 * @param firstDayOfMonth the first day of month
	 * @param lastDayOfMonth the last day of month
	 * @return the list
	 */
	@Query(value = QueryConstants.FETCH_CURRENT_WORKOUTS)
	List<WorkoutCollectionEntity> fetchCurrentMonthWorkouts(Date firstDayOfMonth,Date lastDayOfMonth);
	
	/**
	 * Fetch current year workouts.
	 *
	 * @param currentYear the current year
	 * @return the list
	 */
	@Query(value = QueryConstants.FETCH_CURRENT_YEAR_WORKOUTS)
	List<WorkoutCollectionEntity> fetchCurrentYearWorkouts(Integer currentYear);

}
