package com.medivault.service;

import java.util.List;

import com.medivault.model.User;

public interface IUserService {
    Long save(User user);
    void update(User user);
    void delete(User user);
    User findById(Long id);
    User findByEmail(String email);
    List<User> findAll();
}
