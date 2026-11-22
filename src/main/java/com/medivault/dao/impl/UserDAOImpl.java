package com.medivault.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medivault.dao.IUserDAO;
import com.medivault.model.User;

@Repository
@Transactional
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(User user) {
        return (Long) currentSession().save(user);
    }

    @Override
    public void update(User user) {
        currentSession().update(user);
    }

    @Override
    public void delete(User user) {
        currentSession().delete(user);
    }

    @Override
    public User findById(Long id) {
        return currentSession().get(User.class, id);
    }

    @Override
    public User findByEmail(String email) {
        Query<User> q = currentSession().createQuery("from User where email = :email", User.class);
        q.setParameter("email", email);
        return q.uniqueResult();
    }

    @Override
    public List<User> findAll() {
        return currentSession().createQuery("from User", User.class).list();
    }
}
