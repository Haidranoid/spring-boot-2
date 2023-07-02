package com.example.springboot2.dao;

import com.example.springboot2.entities.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByID(int id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
