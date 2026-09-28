package com.example.CampusFind.repository;

import com.example.CampusFind.model.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoundItemRepository extends JpaRepository<FoundItem, Long> {

    List<FoundItem> findByCategoryId(Long categoryId);

    List<FoundItem> findByLocationContainingIgnoreCase(String location);
}