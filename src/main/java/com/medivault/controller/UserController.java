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

import com.medivault.dao.IUserDAO;
import com.medivault.exception.ResourceNotFoundException;
import com.medivault.model.User;
import com.medivault.util.ResponseUtil;

@RestController
@RequestMapping("/users") // ✅ Removed redundant /api prefix
public class UserController {

    @Autowired
    private IUserDAO userDAO;

    // ✅ Fetch all users
    @GetMapping
    public ResponseEntity<?> listAll() {
        List<User> users = userDAO.findAll();
        return ResponseEntity.ok(ResponseUtil.success(users));
    }

    // ✅ Fetch user by ID (explicit param name)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        User user = userDAO.findById(id);
        if (user == null) throw new ResourceNotFoundException("User not found with id: " + id);
        return ResponseEntity.ok(ResponseUtil.success(user));
    }

    // ✅ Register a new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        Long id = userDAO.save(user);
        user.setId(id);
        return ResponseEntity.ok(ResponseUtil.success(user));
    }

    // ✅ Update user by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User payload) {
        User user = userDAO.findById(id);
        if (user == null) throw new ResourceNotFoundException("User not found with id: " + id);

        user.setFullName(payload.getFullName());
        user.setPhone(payload.getPhone());
        user.setAddress(payload.getAddress());
        user.setGender(payload.getGender());
        user.setEmergencyContact(payload.getEmergencyContact());

        userDAO.update(user);
        return ResponseEntity.ok(ResponseUtil.success(user));
    }

    // ✅ Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        User user = userDAO.findById(id);
        if (user == null) throw new ResourceNotFoundException("User not found with id: " + id);
        userDAO.delete(user);
        return ResponseEntity.ok(ResponseUtil.success("Deleted"));
    }
}
