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
	    @GeneratedValue(strategy=GenerationType.AUTO)
		public int  category_id;
	    
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

		/**
		 * Gets the category id.
		 *
		 * @return the category id
		 */
		public int getCategory_id() {
			return category_id;
		}

		/**
		 * Sets the category id.
		 *
		 * @param category_id the new category id
		 */
		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "CategoryEntity [category_id=" + category_id + ", categoryName=" + categoryName + "]";
		}
			    

}
