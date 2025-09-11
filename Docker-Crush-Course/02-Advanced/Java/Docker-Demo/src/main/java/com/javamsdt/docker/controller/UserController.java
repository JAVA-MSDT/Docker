package com.javamsdt.docker.controller;

import com.javamsdt.docker.modal.User;
import com.javamsdt.docker.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

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
        System.out.println("Find all users.....");
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        System.out.println("Running from within docker...");
        System.out.println("Find user by id " + id);
        return userRepository.findAll().stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst().
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found ....."));
    }
}
