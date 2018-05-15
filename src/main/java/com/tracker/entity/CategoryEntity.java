package com.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class CategoryEntity.
 */
@Entity
@Table(name="workout_category")
public class CategoryEntity {
	
	    /** The category id. */
    	@Id
    	@Column(name="category_id")
	    @GeneratedValue(strategy=GenerationType.AUTO)
		public int  categoryId;
	    
	    /** The category name. */
    	@Column(name="category_name")
	    public String categoryName;
		

		/**
		 * Gets the category name.
		 *
		 * @return the category name
		 */
		public String getCategoryName() {
			return categoryName;
		}

		/**
		 * Sets the category name.
		 *
		 * @param categoryName the new category name
		 */
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

				
		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		@Override
		public String toString() {
			return "CategoryEntity [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
		}

		
}
