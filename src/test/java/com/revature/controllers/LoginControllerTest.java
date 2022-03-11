package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.revature.models.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

    @Autowired
    private LoginController lc;

    @Test
    public void getUsers() {
        ResponseEntity<List<User>> users = lc.getUsers();
        assertEquals(200, users.getStatusCodeValue());
    }

    @Test
    public void testResponse() {
    }
}
