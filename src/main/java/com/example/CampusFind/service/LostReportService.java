package com.example.CampusFind.service;

import com.example.CampusFind.model.LostReport;
import com.example.CampusFind.repository.LostReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostReportService {

    private final LostReportRepository lostReportRepository;

    public LostReportService(LostReportRepository lostReportRepository) {
        this.lostReportRepository = lostReportRepository;
    }

    public LostReport createLostReport(LostReport report) {

        if (report.getStatus() == null) {
            report.setStatus("PENDING");
        }

        return lostReportRepository.save(report);
    }

    public List<LostReport> getAllLostReports() {
        return lostReportRepository.findAll();
    }

    public LostReport getLostReportById(Long id) {
        return lostReportRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Lost report not found with id: " + id));
    }

    public void deleteLostReport(Long id) {
        lostReportRepository.deleteById(id);
    }

    public List<LostReport> findByCategory(Long categoryId) {
        return lostReportRepository.findByCategoryId(categoryId);
    }

    public List<LostReport> findByLocation(String location) {
        return lostReportRepository.findByLocationContainingIgnoreCase(location);
    }
}