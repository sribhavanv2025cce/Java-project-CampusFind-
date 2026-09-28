package com.example.CampusFind.repository;

import com.example.CampusFind.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}