package com.example.CampusFind.controller;

import com.example.CampusFind.model.Category;
import com.example.CampusFind.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // CREATE CATEGORY
    @PostMapping
    public Category createCategory(
            @Valid @RequestBody Category category) {

        return categoryRepository.save(category);
    }

    // GET ALL CATEGORIES
    @GetMapping
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    // GET CATEGORY BY ID
    @GetMapping("/{id}")
    public Category getCategoryById(
            @PathVariable Long id) {

        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Category not found with id: " + id));
    }

    // DELETE CATEGORY
    @DeleteMapping("/{id}")
    public String deleteCategory(
            @PathVariable Long id) {

        categoryRepository.deleteById(id);

        return "Category deleted successfully";
    }
}