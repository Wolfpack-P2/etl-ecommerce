package com.revature.controllers;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private UserRepository logRepo;
    @Autowired
    public LoginController(UserRepository logRepo) {
        this.logRepo = logRepo;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> loginUser (@RequestBody User u){
        return ResponseEntity.ok(logRepo.save(u));
    }
}
