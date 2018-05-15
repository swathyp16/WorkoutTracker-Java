package com.tracker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.constants.QueryConstants;
import com.tracker.entity.CategoryEntity;

/**
 * The Interface CategoryRepository.
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{

	/**
	 * Delete by category name.
	 *
	 * @param categoryName the category name
	 */
	void deleteByCategoryName(String categoryName);
	
	/**
	 * Find by category id.
	 *
	 * @param category_id the category id
	 * @return the category entity
	 */
	@Query(value= QueryConstants.FETCH_CATEGORY)
	CategoryEntity findByCategoryId(int category_id);
	
}
