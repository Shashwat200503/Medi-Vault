package com.medivault.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medivault.dao.ILabReportDAO;
import com.medivault.model.LabReport;
import com.medivault.service.ILabReportService;

@Service
@Transactional
public class LabReportServiceImpl implements ILabReportService {

    @Autowired
    private ILabReportDAO labReportDAO;

    @Override
    public Long save(LabReport labReport) {
        return labReportDAO.save(labReport);
    }

    @Override
    public void update(LabReport labReport) {
        labReportDAO.update(labReport);
    }

    @Override
    public void delete(LabReport labReport) {
        labReportDAO.delete(labReport);
    }

    @Override
    public LabReport findById(Long id) {
        return labReportDAO.findById(id);
    }

    @Override
    public List<LabReport> findByUserId(Long userId) {
        return labReportDAO.findByUserId(userId);
    }

    @Override
    public List<LabReport> findAll() {
        return labReportDAO.findAll();
    }
}
