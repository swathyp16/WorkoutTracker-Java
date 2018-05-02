package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.WorkoutCollectionEntity;

@Repository
public interface WorkoutCollectionRepository extends JpaRepository<WorkoutCollectionEntity, Integer>{
	
	@Query(value=QueryConstants.DELETE_WORKOUT_QUERY)
	void deleteByWorkoutTitle(String workoutTitle);

}