package com.tracker.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class CategoryModel {
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String categoryId;
	
	private String categoryName;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryModel [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	

}
