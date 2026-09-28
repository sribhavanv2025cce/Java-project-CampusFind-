package com.example.CampusFind.repository;

import com.example.CampusFind.model.LostReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LostReportRepository extends JpaRepository<LostReport, Long> {

    List<LostReport> findByCategoryId(Long categoryId);

    List<LostReport> findByLocationContainingIgnoreCase(String location);
}