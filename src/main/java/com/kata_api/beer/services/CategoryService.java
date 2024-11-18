package com.kata_api.beer.services;

import com.kata_api.beer.DTO.CategoryDTO;
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

    public Page<CategoryDTO> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(this::convertirADTO);
    }

    public Category getCategory(Integer id) {
        return categoryRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Category with id " + id + " not found")
        );
    }

    private CategoryDTO convertirADTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setCatName(category.getCatName());
        dto.setLastMod(category.getLastMod());
        return dto;
    }
}
