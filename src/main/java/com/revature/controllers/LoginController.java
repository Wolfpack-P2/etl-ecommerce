package com.revature.controllers;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    private UserRepository logRepo;

    @Autowired
    public LoginController(UserRepository logRepo) {
        this.logRepo = logRepo;
    }


   /* @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> loginUser (@RequestBody User u){
        return ResponseEntity.ok(logRepo.save(u));
    }*/


    @PostMapping(consumes = "application/json", produces = "application/json")
    public User response(@RequestBody User u){
        System.out.println("inside post");
        // get user from db by id, check username and password, return user
        User user = logRepo.findByUsername(u.getUsername());
        System.out.println(user);
        if (user != null && u.getPassword().equals(user.getPassword())) {

            System.out.println("login success");

            return user;
        }
        System.out.println("Login failed");
        return null;
    }


    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(logRepo.findAll());
    }





}
