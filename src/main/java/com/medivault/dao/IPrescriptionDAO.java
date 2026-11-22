package com.medivault.dao;

import java.util.List;

import com.medivault.model.Prescription;

public interface IPrescriptionDAO {
    Long save(Prescription prescription);
    void update(Prescription prescription);
    void delete(Prescription prescription);
    Prescription findById(Long id);
    List<Prescription> findByUserId(Long userId);
    List<Prescription> findAll();
}
