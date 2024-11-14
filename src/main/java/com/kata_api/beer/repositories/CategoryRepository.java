package com.kata_api.beer.repositories;

import com.kata_api.beer.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(Integer idCategory);
    Page<Category> findCategoriesByCatNameContainingIgnoreCase(String categoryName, Pageable pageable);
}
