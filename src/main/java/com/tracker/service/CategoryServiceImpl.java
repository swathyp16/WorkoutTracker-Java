package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.constants.CommonConstants;
import com.tracker.dao.WorkoutDao;
import com.tracker.entity.CategoryEntity;
import com.tracker.intf.ICategoryService;
import com.tracker.model.CategoryModel;

/**
 * The Class CategoryServiceImpl.
 */
@Component
public class CategoryServiceImpl implements ICategoryService{
	
	/** The workout dao. */
	@Autowired
	private WorkoutDao workoutDao;

	/* (non-Javadoc)
	 * @see com.tracker.intf.ICategoryService#addCategory(com.tracker.model.CategoryModel)
	 */
	@Override
	public String addCategory(CategoryModel categoryModel) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryName(categoryModel.getCategoryName());
		if(categoryModel.getCategoryId()!= null) {
			categoryEntity.setCategoryId(Integer.parseInt(categoryModel.getCategoryId()));
		}
		workoutDao.addCategory(categoryEntity);
		return CommonConstants.SUCCESS_RESPONSE;
		
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.intf.ICategoryService#viewAllCategories()
	 */
	@Override
	public List<CategoryModel> viewAllCategories() {
		List<CategoryEntity> categoryList = workoutDao.getCategoryList();
		CategoryModel categoryModel= null;
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		for(CategoryEntity category : categoryList) {
			categoryModel = new CategoryModel();
			categoryModel.setCategoryId(Integer.toString(category.getCategoryId()));
			categoryModel.setCategoryName(category.getCategoryName());
			categoryModelList.add(categoryModel);
		}
		return categoryModelList;
		
	}
	
	/* (non-Javadoc)
	 * @see com.tracker.intf.ICategoryService#deleteCategory(java.lang.String)
	 */
	@Override
	public String deleteCategory(String categoryId) {
		workoutDao.deleteCategory(categoryId);
		return CommonConstants.SUCCESS_RESPONSE;
	}
}
