package com.travelavail.travelsystem.controller;

import com.travelavail.travelsystem.model.Users;
import com.travelavail.travelsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Users users) {
        userService.saveUser(users);  // Ensure save method works correctly
        return ResponseEntity.ok("New User Added");  // Return HTTP 200 OK with a success message
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);  // Return the list of users with HTTP 200 OK
    }
}
