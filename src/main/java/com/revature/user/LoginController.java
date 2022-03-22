package com.revature.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    private UserRepository logRepo;

    public LoginController(UserRepository logRepo) {
        this.logRepo = logRepo;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public User login(@RequestBody User u){
        // get user from db by id, check username and password, return user
        User user = logRepo.findByUsername(u.getUsername());
        System.out.println(user);
        if (user != null && u.getPassword().equals(user.getPassword())) {

            System.out.println("Login Successful");

            return user;
        }
        System.out.println("Login Failed");
        return null;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(logRepo.findAll());
    }
}
