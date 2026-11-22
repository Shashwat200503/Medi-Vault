package com.medivault.service;

import java.util.List;

import com.medivault.model.Document;

public interface IDocumentService {
    Long save(Document document);
    void update(Document document);
    void delete(Document document);
    Document findById(Long id);
    List<Document> findByUserId(Long userId);
    List<Document> findAll();
}
