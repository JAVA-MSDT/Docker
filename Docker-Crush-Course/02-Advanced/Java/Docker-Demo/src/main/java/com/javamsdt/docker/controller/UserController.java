package com.javamsdt.docker.controller;

import com.javamsdt.docker.modal.User;
import com.javamsdt.docker.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        System.out.println("Running from within docker...");
        System.out.println("Caching Docker.....");
        return userRepository.findAll();
    }
}
