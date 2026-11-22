package com.medivault.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medivault.dao.IDocumentDAO;
import com.medivault.model.Document;

@Repository
@Transactional
public class DocumentDAOImpl implements IDocumentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(Document document) {
        return (Long) currentSession().save(document);
    }

    @Override
    public void update(Document document) {
        currentSession().update(document);
    }

    @Override
    public void delete(Document document) {
        currentSession().delete(document);
    }

    @Override
    public Document findById(Long id) {
        return currentSession().get(Document.class, id);
    }

    @Override
    public List<Document> findByUserId(Long userId) {
        Query<Document> q = currentSession().createQuery(
            "from Document d where d.user.id = :uid", Document.class);
        q.setParameter("uid", userId);
        return q.list();
    }

    @Override
    public List<Document> findAll() {
        return currentSession().createQuery("from Document", Document.class).list();
    }
}
