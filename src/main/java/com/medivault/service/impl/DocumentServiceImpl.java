package com.medivault.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medivault.dao.IDocumentDAO;
import com.medivault.model.Document;
import com.medivault.service.IDocumentService;

@Service
@Transactional
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    private IDocumentDAO documentDAO;

    @Override
    public Long save(Document document) {
        return documentDAO.save(document);
    }

    @Override
    public void update(Document document) {
        documentDAO.update(document);
    }

    @Override
    public void delete(Document document) {
        documentDAO.delete(document);
    }

    @Override
    public Document findById(Long id) {
        return documentDAO.findById(id);
    }

    @Override
    public List<Document> findByUserId(Long userId) {
        return documentDAO.findByUserId(userId);
    }

    @Override
    public List<Document> findAll() {
        return documentDAO.findAll();
    }
}
