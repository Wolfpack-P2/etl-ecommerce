package com.revature.controllers;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class RegisterController {

    private UserRepository userRepo;
    @Autowired
    public RegisterController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userRepo.registerUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
    }
}
