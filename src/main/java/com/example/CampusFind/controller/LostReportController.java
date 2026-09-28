package com.example.CampusFind.controller;

import com.example.CampusFind.model.LostReport;
import com.example.CampusFind.service.LostReportService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lost")
public class LostReportController {

    private final LostReportService lostReportService;

    public LostReportController(LostReportService lostReportService) {
        this.lostReportService = lostReportService;
    }

    // CREATE LOST REPORT
    @PostMapping
    public LostReport createLostReport(
            @Valid @RequestBody LostReport report) {

        return lostReportService.createLostReport(report);
    }

    // GET ALL LOST REPORTS
    @GetMapping
    public List<LostReport> getAllLostReports() {
        return lostReportService.getAllLostReports();
    }

    // GET LOST REPORT BY ID
    @GetMapping("/{id}")
    public LostReport getLostReportById(
            @PathVariable Long id) {

        return lostReportService.getLostReportById(id);
    }

    // DELETE LOST REPORT
    @DeleteMapping("/{id}")
    public String deleteLostReport(
            @PathVariable Long id) {

        lostReportService.deleteLostReport(id);

        return "Lost report deleted successfully";
    }

    // SEARCH BY CATEGORY
    @GetMapping("/category/{categoryId}")
    public List<LostReport> findByCategory(
            @PathVariable Long categoryId) {

        return lostReportService.findByCategory(categoryId);
    }

    // SEARCH BY LOCATION
    @GetMapping("/location/{location}")
    public List<LostReport> findByLocation(
            @PathVariable String location) {

        return lostReportService.findByLocation(location);
    }
}