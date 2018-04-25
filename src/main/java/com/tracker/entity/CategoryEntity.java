package com.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workout_category")
public class CategoryEntity {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		public int  category_id;
	    
	    @Column(name="category_name")
	    public String categoryName;
		

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public int getCategory_id() {
			return category_id;
		}

		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}

		@Override
		public String toString() {
			return "CategoryEntity [category_id=" + category_id + ", categoryName=" + categoryName + "]";
		}
			    

}
