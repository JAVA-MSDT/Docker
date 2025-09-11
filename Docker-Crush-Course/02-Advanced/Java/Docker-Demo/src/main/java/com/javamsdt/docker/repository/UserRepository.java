package com.javamsdt.docker.repository;

import com.javamsdt.docker.modal.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository  {

    public List<User> findAll() {
        return List.of(
                new User(1, "Ahmed Samy", "sereniydiver@hotmail.com"),
                new User(2, "Alaa Gama", "alaagamalel-din@hotmail.com")
        );
    }
}
