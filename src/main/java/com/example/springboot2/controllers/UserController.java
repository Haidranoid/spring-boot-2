package com.example.springboot2.controllers;

import com.example.springboot2.entities.User;
import com.example.springboot2.exceptions.UserNotFoundException;
import com.example.springboot2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        User user = userService.findByID(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> getUsers(@Valid @RequestBody User user) {
        User userSaved = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> getUsers(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
