package com.medivault.service;

import java.util.List;

import com.medivault.model.LabReport;

public interface ILabReportService {
    Long save(LabReport labReport);
    void update(LabReport labReport);
    void delete(LabReport labReport);
    LabReport findById(Long id);
    List<LabReport> findByUserId(Long userId);
    List<LabReport> findAll();
}
