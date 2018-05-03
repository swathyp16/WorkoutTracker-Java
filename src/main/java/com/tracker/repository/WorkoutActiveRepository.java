package com.tracker.repository;

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

}
