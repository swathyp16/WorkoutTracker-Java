package com.tracker.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.entity.CategoryEntity;
import com.tracker.entity.WorkoutActiveEntity;
import com.tracker.entity.WorkoutCollectionEntity;
import com.tracker.model.AddWorkoutModel;
import com.tracker.model.CategoryModel;
import com.tracker.repository.CategoryRepository;
import com.tracker.repository.WorkoutActiveRepository;
import com.tracker.repository.WorkoutCollectionRepository;

@Component("workoutDao")
public class WorkoutDao {
	
	@Autowired
	private WorkoutCollectionRepository workoutCollectionRepository;
	
	@Autowired
	private WorkoutActiveRepository workoutActiveRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	
	public void insertInfo(WorkoutCollectionEntity collectionEntity) {
		System.out.println("Calling workoutCollectionRepo SAVE");
		workoutCollectionRepository.save(collectionEntity);
	}
	
	public List<WorkoutCollectionEntity> fetchWorkoutInfo(){
		System.out.println("Calling workoutCollectionRepo FETCH");
		List<WorkoutCollectionEntity> workoutList = (List<WorkoutCollectionEntity>) workoutCollectionRepository.findAll();
		return workoutList;
	}
	
	public void deleteWorkout(String workoutTitle) {
		System.out.println("Calling workoutCollectionRepo DELETE : " + workoutTitle);
		workoutCollectionRepository.deleteByWorkoutTitle(workoutTitle);
	}
	
	public List<WorkoutCollectionEntity> fetchEditWorkoutDetails(String workoutId){
		WorkoutCollectionEntity workoutCollectionEntity= workoutCollectionRepository.findById(Integer.parseInt(workoutId)).get();
		List<WorkoutCollectionEntity> editDetailsList = new ArrayList<WorkoutCollectionEntity>();
		editDetailsList.add(workoutCollectionEntity);
		return editDetailsList;
	}
	
	public void startWorkout(WorkoutActiveEntity workoutActiveEntity,boolean isStartWorkout) {
		System.out.println("Calling workoutCollectionRepo SAVE");
		workoutActiveRepository.save(workoutActiveEntity);
	}
	
	public void addCategory(CategoryEntity categoryEntity) {
		categoryRepository.save(categoryEntity);
	}
	
	public List<CategoryEntity> getCategoryList(){
		List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
		return categoryEntityList;
	}
	
	public void deleteCategory(String categoryId) {
		System.out.println("Calling categoryRepository DELETE : " + categoryId);
		categoryRepository.deleteById(Integer.parseInt(categoryId));
		//categoryRepository.deleteByCategoryName(categoryName);
	}
	
}
