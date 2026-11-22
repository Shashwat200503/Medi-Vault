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

import com.medivault.dao.ILabReportDAO;
import com.medivault.exception.ResourceNotFoundException;
import com.medivault.model.LabReport;
import com.medivault.util.ResponseUtil;

@RestController
@RequestMapping("/lab-reports")
public class LabReportController {

    @Autowired
    private ILabReportDAO labReportDAO;

    // ✅ Fetch all lab reports
    @GetMapping
    public ResponseEntity<?> listAll() {
        List<LabReport> list = labReportDAO.findAll();
        return ResponseEntity.ok(ResponseUtil.success(list));
    }

    // ✅ Fetch by ID (added explicit param name)
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        LabReport r = labReportDAO.findById(id);
        if (r == null) throw new ResourceNotFoundException("LabReport not found: " + id);
        return ResponseEntity.ok(ResponseUtil.success(r));
    }

    // ✅ Create a new lab report
    @PostMapping
    public ResponseEntity<?> create(@RequestBody LabReport payload) {
        Long id = labReportDAO.save(payload);
        payload.setId(id);
        return ResponseEntity.ok(ResponseUtil.success(payload));
    }

    // ✅ Update existing lab report (added explicit param name)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody LabReport payload) {
        LabReport r = labReportDAO.findById(id);
        if (r == null) throw new ResourceNotFoundException("LabReport not found: " + id);

        r.setTestName(payload.getTestName());
        r.setLaboratory(payload.getLaboratory());
        r.setTestResults(payload.getTestResults());
        r.setDoctorComments(payload.getDoctorComments());
        r.setNormalRange(payload.getNormalRange());
        r.setPatientValue(payload.getPatientValue());
        r.setReportStatus(payload.getReportStatus());

        labReportDAO.update(r);
        return ResponseEntity.ok(ResponseUtil.success(r));
    }

    // ✅ Delete lab report (added explicit param name)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        LabReport r = labReportDAO.findById(id);
        if (r == null) throw new ResourceNotFoundException("LabReport not found: " + id);
        labReportDAO.delete(r);
        return ResponseEntity.ok(ResponseUtil.success("Deleted"));
    }

    // ✅ Fetch lab reports by user ID (added explicit param name)
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> byUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(ResponseUtil.success(labReportDAO.findByUserId(userId)));
    }
}
