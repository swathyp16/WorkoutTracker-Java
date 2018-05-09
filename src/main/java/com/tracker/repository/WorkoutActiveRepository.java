package com.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.WorkoutActiveEntity;

/**
 * The Interface WorkoutActiveRepository.
 */
@Repository
public interface WorkoutActiveRepository extends JpaRepository<WorkoutActiveEntity, Integer>{
	
	/**
	 * Find current day workout time.
	 *
	 * @param currentDate the current date
	 * @param completedStatus the completed status
	 * @return the list
	 */
	@Query(value = QueryConstants.FETCH_WORKOUT_TRACKER_QUERY,nativeQuery=true)
	List<WorkoutActiveEntity> findCurrentDayWorkoutTime(String currentDate, Boolean completedStatus); 
	
	/**
	 * Find by workout id.
	 *
	 * @param workoutId the workout id
	 * @return the workout active entity
	 */
	@Query(value = QueryConstants.FETCH_START_WORKOUT_DETAILS,nativeQuery=true)
	WorkoutActiveEntity findByWorkout_id(int workoutId);
	
}
