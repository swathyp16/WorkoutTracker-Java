package com.tracker.intf;

import java.util.List;

import com.tracker.model.AddWorkoutModel;
import com.tracker.model.CategoryModel;

public interface ICategoryService {
	
	public String addCategory(CategoryModel categoryModel);
	
	public List<CategoryModel> viewAllCategories();
	
	public String deleteCategory(String categoryId);

}
