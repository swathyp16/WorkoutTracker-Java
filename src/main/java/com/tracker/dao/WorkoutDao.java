package com.tracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.Exception.BusinessException;
import com.tracker.entity.CategoryEntity;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.entity.WorkoutCollectionEntity;
import com.tracker.repository.CategoryRepository;
import com.tracker.repository.WorkoutActiveRepository;
import com.tracker.repository.WorkoutCollectionRepository;

/**
 * The Class WorkoutDao.
 */
@Component("workoutDao")
public class WorkoutDao {
	
	/** The workout collection repository. */
	@Autowired
	private WorkoutCollectionRepository workoutCollectionRepository;
	
	/** The workout active repository. */
	@Autowired
	private WorkoutActiveRepository workoutActiveRepository;
	
	/** The category repository. */
	@Autowired
	private CategoryRepository categoryRepository;

	
	/**
	 * Insert info.
	 *
	 * @param collectionEntity the collection entity
	 */
	public void insertInfo(WorkoutCollectionEntity collectionEntity) {
		workoutCollectionRepository.save(collectionEntity);
	}
	
	/**
	 * Fetch workout info.
	 *
	 * @return the list
	 */
	public List<WorkoutCollectionEntity> fetchWorkoutInfo(){
		List<WorkoutCollectionEntity> workoutList = (List<WorkoutCollectionEntity>) workoutCollectionRepository.findAll();
		return workoutList;
	}
	
	/**
	 * Delete workout.
	 *
	 * @param workoutId the workout id
	 * @throws BusinessException the business exception
	 */
	public void deleteWorkout(String workoutId) throws BusinessException {
		try {
			workoutCollectionRepository.deleteById(Integer.parseInt(workoutId));
		}catch(IllegalArgumentException e) {
			throw new BusinessException(e.toString());
		}		
	}
	
	/**
	 * Fetch edit workout details.
	 *
	 * @param workoutId the workout id
	 * @return the list
	 */
	public List<WorkoutCollectionEntity> fetchEditWorkoutDetails(String workoutId){
		WorkoutCollectionEntity workoutCollectionEntity= workoutCollectionRepository.findById(Integer.parseInt(workoutId)).get();
		List<WorkoutCollectionEntity> editDetailsList = new ArrayList<WorkoutCollectionEntity>();
		editDetailsList.add(workoutCollectionEntity);
		return editDetailsList;
	}
	
	/**
	 * Start workout.
	 *
	 * @param workoutActiveEntity the workout active entity
	 */
	public void startWorkout(WorkoutActiveEntity workoutActiveEntity) {
		workoutActiveRepository.save(workoutActiveEntity);
	}
	
	/**
	 * Adds the category.
	 *
	 * @param categoryEntity the category entity
	 */
	public void addCategory(CategoryEntity categoryEntity) {
		categoryRepository.save(categoryEntity);
	}
	
	/**
	 * Gets the category list.
	 *
	 * @return the category list
	 */
	public List<CategoryEntity> getCategoryList(){
		List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
		return categoryEntityList;
	}
	
	/**
	 * Delete category.
	 *
	 * @param categoryId the category id
	 */
	public void deleteCategory(String categoryId) {
		categoryRepository.deleteById(Integer.parseInt(categoryId));
	}
	
	/**
	 * Fetch start workout details.
	 *
	 * @param workoutId the workout id
	 * @return the workout active entity
	 */
	public WorkoutActiveEntity fetchStartWorkoutDetails(String workoutId) {
		WorkoutActiveEntity workoutActiveEntity = workoutActiveRepository.findByWorkout_id(Integer.parseInt(workoutId));
		return workoutActiveEntity;
	}
	
	/**
	 * Find by category id.
	 *
	 * @param categoryId the category id
	 * @return the category entity
	 */
	public CategoryEntity findByCategoryId(int categoryId) {
		CategoryEntity categoryEntity = categoryRepository.findByCategoryId(categoryId);
		return categoryEntity;		
	}
	
}
