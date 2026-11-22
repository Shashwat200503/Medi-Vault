package com.medivault.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medivault.dao.ILabReportDAO;
import com.medivault.model.LabReport;

@Repository
@Transactional
public class LabReportDAOImpl implements ILabReportDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(LabReport labReport) {
        return (Long) currentSession().save(labReport);
    }

    @Override
    public void update(LabReport labReport) {
        currentSession().update(labReport);
    }

    @Override
    public void delete(LabReport labReport) {
        currentSession().delete(labReport);
    }

    @Override
    public LabReport findById(Long id) {
        return currentSession().get(LabReport.class, id);
    }

    @Override
    public List<LabReport> findByUserId(Long userId) {
        Query<LabReport> q = currentSession().createQuery(
            "from LabReport lr where lr.user.id = :uid", LabReport.class);
        q.setParameter("uid", userId);
        return q.list();
    }

    @Override
    public List<LabReport> findAll() {
        return currentSession().createQuery("from LabReport", LabReport.class).list();
    }
}
