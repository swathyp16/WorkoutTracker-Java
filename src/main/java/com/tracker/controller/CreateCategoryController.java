package com.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.AddWorkoutModel;
import com.tracker.model.CategoryModel;
import com.tracker.service.CategoryServiceImpl;
import com.tracker.service.WorkoutServiceImpl;

@RestController
public class CreateCategoryController {

	@Autowired
	CategoryServiceImpl categoryServiceImpl;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/createCategory",method=RequestMethod.POST)
	public String createCategory(@RequestBody CategoryModel categoryModel) {
		System.out.println("***********************************************");
		System.out.println("Inside CREATE CATEGORY");
		System.out.println("***********************************************");
		String responseString = null;
		try {
			responseString = categoryServiceImpl.addCategory(categoryModel);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseString;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/viewAllCategory",method=RequestMethod.GET)
	public List<CategoryModel> viewAllCategories() {
		System.out.println("***********************************************");
		System.out.println("Inside VIEW ALL CATEGORY");
		System.out.println("***********************************************");
		List<CategoryModel> categoryList = new ArrayList<CategoryModel>() ;
		try {
			categoryList = categoryServiceImpl.viewAllCategories();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return categoryList;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/deleteCategory",method=RequestMethod.POST)
	public String deleteCategory(@RequestBody CategoryModel categoryModel) {
		System.out.println("***********************************************");
		System.out.println("Inside DELETE CATEGORY" + categoryModel.toString());
		System.out.println("***********************************************");
		String respStr = null;
		try {
			respStr = categoryServiceImpl.deleteCategory(categoryModel.getCategoryName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return respStr;
		
	}
}
