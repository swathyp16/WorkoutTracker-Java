package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.WorkoutActiveEntity;

@Repository
public interface WorkoutActiveRepository extends JpaRepository<WorkoutActiveEntity, Integer>{

}
