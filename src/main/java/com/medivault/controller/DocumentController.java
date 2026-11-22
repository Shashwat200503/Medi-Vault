package com.medivault.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medivault.dao.IDocumentDAO;
import com.medivault.exception.ResourceNotFoundException;
import com.medivault.model.Document;
import com.medivault.util.FileUploadUtil;
import com.medivault.util.ResponseUtil;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private IDocumentDAO documentDAO;

    @Autowired
    private Environment env;

    // ✅ Fetch all documents
    @GetMapping
    public ResponseEntity<?> listAll() {
        List<Document> docs = documentDAO.findAll();
        return ResponseEntity.ok(ResponseUtil.success(docs));
    }

    // ✅ Fetch a document by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Document d = documentDAO.findById(id);
        if (d == null) throw new ResourceNotFoundException("Document not found: " + id);
        return ResponseEntity.ok(ResponseUtil.success(d));
    }

    // ✅ Upload a document
    @PostMapping("/upload")
    public ResponseEntity<?> upload(
            @RequestParam("userId") Long userId,
            @RequestParam("file") MultipartFile file
    ) throws Exception {

        String uploadDir = env.getProperty("file.upload.dir", "uploads/");
        String storedPath = FileUploadUtil.saveFile(uploadDir, file);

        Document doc = new Document();
        doc.setUser(new com.medivault.model.User());
        doc.getUser().setId(userId);
        doc.setFileName(file.getOriginalFilename());
        doc.setFilePath(storedPath);
        doc.setFileType(file.getContentType());
        doc.setFileSize(file.getSize());

        Long id = documentDAO.save(doc);
        doc.setId(id);
        return ResponseEntity.ok(ResponseUtil.success(doc));
    }

    // ✅ Delete a document by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Document d = documentDAO.findById(id);
        if (d == null) throw new ResourceNotFoundException("Document not found: " + id);
        documentDAO.delete(d);
        return ResponseEntity.ok(ResponseUtil.success("Deleted"));
    }

    // ✅ Fetch all documents by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> byUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(ResponseUtil.success(documentDAO.findByUserId(userId)));
    }
}
