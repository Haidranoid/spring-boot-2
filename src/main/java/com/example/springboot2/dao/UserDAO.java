package com.example.springboot2.dao;

import com.example.springboot2.entities.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();

    User findByID(int id);

    User save(User user);

    void deleteById(int id);
}
