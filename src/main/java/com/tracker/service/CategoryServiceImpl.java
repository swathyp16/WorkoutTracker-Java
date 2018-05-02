package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.constants.CommonConstants;
import com.tracker.dao.WorkoutDao;
import com.tracker.entity.CategoryEntity;
import com.tracker.intf.ICategoryService;
import com.tracker.model.AddWorkoutModel;
import com.tracker.model.CategoryModel;
import com.tracker.util.HibernateUtil;

@Component
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	WorkoutDao workoutDao;

	@Override
	public String addCategory(CategoryModel categoryModel) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryName(categoryModel.getCategoryName());
		//HibernateUtil.addCategory(categoryEntity);
		workoutDao.addCategory(categoryEntity);
		return CommonConstants.SUCCESS_RESPONSE;
		
	}
	
	@Override
	public List<CategoryModel> viewAllCategories() {
		List<CategoryEntity> categoryList = workoutDao.getCategoryList();
				//HibernateUtil.getCategoryList();
		CategoryModel categoryModel= null;
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		for(CategoryEntity category : categoryList) {
			categoryModel = new CategoryModel();
			categoryModel.setCategoryId(Integer.toString(category.getCategory_id()));
			categoryModel.setCategoryName(category.getCategoryName());
			categoryModelList.add(categoryModel);
		}
		return categoryModelList;
		
	}
	
	@Override
	public String deleteCategory(String categoryId) {
		//HibernateUtil.deleteCategory(categoryName);
		workoutDao.deleteCategory(categoryId);
		return CommonConstants.SUCCESS_RESPONSE;
	}
}
