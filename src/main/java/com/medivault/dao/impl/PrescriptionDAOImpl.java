package com.medivault.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medivault.dao.IPrescriptionDAO;
import com.medivault.model.Prescription;

@Repository
@Transactional
public class PrescriptionDAOImpl implements IPrescriptionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(Prescription prescription) {
        return (Long) currentSession().save(prescription);
    }

    @Override
    public void update(Prescription prescription) {
        currentSession().update(prescription);
    }

    @Override
    public void delete(Prescription prescription) {
        currentSession().delete(prescription);
    }

    @Override
    public Prescription findById(Long id) {
        return currentSession().get(Prescription.class, id);
    }

    @Override
    public List<Prescription> findByUserId(Long userId) {
        Query<Prescription> q = currentSession().createQuery(
            "from Prescription p where p.user.id = :uid", Prescription.class);
        q.setParameter("uid", userId);
        return q.list();
    }

    @Override
    public List<Prescription> findAll() {
        return currentSession().createQuery("from Prescription", Prescription.class).list();
    }
}
