package com.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.Exception.BusinessException;
import com.tracker.model.CategoryModel;
import com.tracker.service.CategoryServiceImpl;


/**
 * The Class CreateCategoryController.
 */
@RestController
public class CreateCategoryController {

	/** The category service impl. */
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	/**
	 * Creates the category.
	 *
	 * @param categoryModel the category model
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/createCategory",method=RequestMethod.POST)
	public String createCategory(@RequestBody CategoryModel categoryModel) throws BusinessException {
		String responseString = null;
		try {
			responseString = categoryServiceImpl.addCategory(categoryModel);
		}catch(Exception e) {
			throw new BusinessException(e.toString());
		}
		return responseString;
		
	}
	
	/**
	 * View all categories.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/viewAllCategory",method=RequestMethod.GET)
	public List<CategoryModel> viewAllCategories() throws BusinessException {
		List<CategoryModel> categoryList = new ArrayList<CategoryModel>() ;
		try {
			categoryList = categoryServiceImpl.viewAllCategories();
		}catch(Exception e) {
			throw new BusinessException(e.toString());
		}
		return categoryList;
		
	}
	
	/**
	 * Delete category.
	 *
	 * @param categoryModel the category model
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/deleteCategory",method=RequestMethod.POST)
	public String deleteCategory(@RequestBody CategoryModel categoryModel) throws BusinessException {
		String respStr = null;
		try {
			respStr = categoryServiceImpl.deleteCategory(categoryModel.getCategoryId());
		}catch(Exception e) {
			throw new BusinessException(e.toString());
		}
		return respStr;
		
	}
}
