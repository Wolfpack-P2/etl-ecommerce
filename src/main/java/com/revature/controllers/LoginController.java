package com.revature.controllers;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    @PostMapping("/login")
    public String response(@RequestBody User u){
        System.out.println("inside post");
        return "hello world";
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(logRepo.findAll());
    }





}
