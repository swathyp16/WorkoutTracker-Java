package com.tracker.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tracker.constants.CommonConstants;
import com.tracker.entity.CategoryEntity;
import com.tracker.intf.ICategoryService;
import com.tracker.model.AddWorkoutModel;
import com.tracker.model.CategoryModel;
import com.tracker.util.HibernateUtil;

@Component
public class CategoryServiceImpl implements ICategoryService{

	@Override
	public String addCategory(CategoryModel categoryModel) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryName(categoryModel.getCategoryName());
		HibernateUtil.addCategory(categoryEntity);
		return CommonConstants.SUCCESS_RESPONSE;
		
	}
	
	@Override
	public List<CategoryModel> viewAllCategories() {
		List<CategoryModel> categoryList = HibernateUtil.getCategoryList();
		return categoryList;
		
	}
	
	@Override
	public String deleteCategory(String categoryName) {
		HibernateUtil.deleteCategory(categoryName);
		return CommonConstants.SUCCESS_RESPONSE;
	}
}
