package com.kata_api.beer.services;

import com.kata_api.beer.entities.Category;
import com.kata_api.beer.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category getCategory(Integer id) {
        return categoryRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Category with id " + id + " not found")
        );
    }
}
