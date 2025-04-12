package com.travelavail.travelsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelavail.travelsystem.dto.LoginDTO;
import com.travelavail.travelsystem.dto.UserDTO;
import com.travelavail.travelsystem.entity.Users;
import com.travelavail.travelsystem.response.LoginResponse;
import com.travelavail.travelsystem.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/api/register/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Users getUsers(@PathVariable("id") Long user_id) {
        return userService.getUsers(user_id);
    }

    @PutMapping("/users/{id}")
    public Users updateUser(@RequestBody() Users user, @PathVariable("id") Long user_id) {
        return userService.updateUser(user);
    }

    @PostMapping("/register")
    public ResponseEntity<?> newUser(@RequestBody Users user) {
        Users newUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED.body(newUser));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long user_id) {
        return userService.deleteUser(user_id);
    }


    // @PostMapping(path = "/save")
    // public String saveUser(@RequestBody UserDTO userDTO)
    // {
    // String id = userService.addUser(userDTO);
    // return id;
    // }

    // @PostMapping(path = "/login")
    // public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    // {
    // LoginResponse LoginResponse = userService.loginUser(loginDTO);
    // return ResponseEntity.ok(LoginResponse);
    // }

}
