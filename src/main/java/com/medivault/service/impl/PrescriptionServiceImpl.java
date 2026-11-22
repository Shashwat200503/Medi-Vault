package com.medivault.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medivault.dao.IPrescriptionDAO;
import com.medivault.model.Prescription;
import com.medivault.service.IPrescriptionService;

@Service
@Transactional
public class PrescriptionServiceImpl implements IPrescriptionService {

    @Autowired
    private IPrescriptionDAO prescriptionDAO;

    @Override
    public Long save(Prescription prescription) {
        return prescriptionDAO.save(prescription);
    }

    @Override
    public void update(Prescription prescription) {
        prescriptionDAO.update(prescription);
    }

    @Override
    public void delete(Prescription prescription) {
        prescriptionDAO.delete(prescription);
    }

    @Override
    public Prescription findById(Long id) {
        return prescriptionDAO.findById(id);
    }

    @Override
    public List<Prescription> findByUserId(Long userId) {
        return prescriptionDAO.findByUserId(userId);
    }

    @Override
    public List<Prescription> findAll() {
        return prescriptionDAO.findAll();
    }
}
