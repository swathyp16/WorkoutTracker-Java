package com.tracker.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.WorkoutActiveEntity;

@Repository
public interface WorkoutActiveRepository extends JpaRepository<WorkoutActiveEntity, Integer>{
	
	@Query(value = QueryConstants.FETCH_WORKOUT_TRACKER_QUERY,nativeQuery=true)
	List<WorkoutActiveEntity> findCurrentDayWorkoutTime(String currentDate, Boolean completedStatus); 
	
	@Query(value = QueryConstants.FETCH_START_WORKOUT_DETAILS,nativeQuery=true)
	WorkoutActiveEntity findByWorkout_id(int workoutId);

	//@Query(value = QueryConstants.FETCH_CURRENT_WEEK_WORKOUTS,nativeQuery=true)
	//List<WorkoutActiveEntity> fetchCurrentWeekWorkouts(LocalDate monday, LocalDate sunday);

	
}
