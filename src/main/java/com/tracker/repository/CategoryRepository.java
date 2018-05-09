package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
