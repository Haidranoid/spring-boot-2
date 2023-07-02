package com.example.springboot2.service;

import com.example.springboot2.dao.UserDAO;
import com.example.springboot2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserServiceImpl implements UserService {

    public static List<User> users = new ArrayList<>();
    public static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Edward", LocalDate.now().minusYears(30)));
    }

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findByID(int id) {
        Predicate<User> predicate = user -> user.getId() == id;
        User userFound = users.stream().filter(predicate).findFirst().orElse(null);

        return userFound;
    }

    @Override
    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    @Override
    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
