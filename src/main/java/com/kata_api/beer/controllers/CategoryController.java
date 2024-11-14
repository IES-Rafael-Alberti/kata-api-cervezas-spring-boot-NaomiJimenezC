package com.kata_api.beer.controllers;

import com.kata_api.beer.entities.Category;
import com.kata_api.beer.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://example.com")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryRepository) {
        this.categoryService = categoryRepository;
    }

    @GetMapping
    @CrossOrigin(origins = "http://example.com")
    public ResponseEntity<Page<Category>> listarCategorias(Pageable pageable) {
            Page<Category> categorias = categoryService.getAllCategories(pageable);
            return ResponseEntity.ok(categorias);
    }

    @GetMapping("/categorie/{id}")
    public ResponseEntity<Category> buscarCategoriaPorId(@PathVariable int id) {
        Category categoria = categoryService.getCategory(id);
        return ResponseEntity.ok(categoria);
    }


}
