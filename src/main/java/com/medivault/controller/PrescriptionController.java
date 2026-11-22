package com.medivault.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medivault.dao.IPrescriptionDAO;
import com.medivault.exception.ResourceNotFoundException;
import com.medivault.model.Prescription;
import com.medivault.util.ResponseUtil;

@RestController
@RequestMapping("/prescriptions") // ✅ Removed redundant /api prefix
public class PrescriptionController {

    @Autowired
    private IPrescriptionDAO prescriptionDAO;

    // ✅ Fetch all prescriptions
    @GetMapping
    public ResponseEntity<?> listAll() {
        List<Prescription> list = prescriptionDAO.findAll();
        return ResponseEntity.ok(ResponseUtil.success(list));
    }

    // ✅ Fetch by ID (added explicit name to avoid reflection error)
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Prescription p = prescriptionDAO.findById(id);
        if (p == null) throw new ResourceNotFoundException("Prescription not found: " + id);
        return ResponseEntity.ok(ResponseUtil.success(p));
    }

    // ✅ Create new prescription
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Prescription prescription) {
        Long id = prescriptionDAO.save(prescription);
        prescription.setId(id);
        return ResponseEntity.ok(ResponseUtil.success(prescription));
    }

    // ✅ Update existing prescription
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Prescription payload) {
        Prescription p = prescriptionDAO.findById(id);
        if (p == null) throw new ResourceNotFoundException("Prescription not found: " + id);

        p.setDoctorName(payload.getDoctorName());
        p.setHospital(payload.getHospital());
        p.setMedications(payload.getMedications());
        p.setDiagnosis(payload.getDiagnosis());
        p.setDosage(payload.getDosage());
        p.setDuration(payload.getDuration());
        p.setNotes(payload.getNotes());
        p.setStatus(payload.getStatus());

        prescriptionDAO.update(p);
        return ResponseEntity.ok(ResponseUtil.success(p));
    }

    // ✅ Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Prescription p = prescriptionDAO.findById(id);
        if (p == null) throw new ResourceNotFoundException("Prescription not found: " + id);
        prescriptionDAO.delete(p);
        return ResponseEntity.ok(ResponseUtil.success("Deleted"));
    }

    // ✅ Fetch by user ID (added explicit param name)
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> byUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(ResponseUtil.success(prescriptionDAO.findByUserId(userId)));
    }
}
