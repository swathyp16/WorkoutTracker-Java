package com.tracker.intf;

import java.util.List;

import com.tracker.model.CategoryModel;

/**
 * The Interface ICategoryService.
 */
public interface ICategoryService {
	
	/**
	 * Adds the category.
	 *
	 * @param categoryModel the category model
	 * @return the string
	 */
	public String addCategory(CategoryModel categoryModel);
	
	/**
	 * View all categories.
	 *
	 * @return the list
	 */
	public List<CategoryModel> viewAllCategories();
	
	/**
	 * Delete category.
	 *
	 * @param categoryId the category id
	 * @return the string
	 */
	public String deleteCategory(String categoryId);

}
