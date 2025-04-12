package com.travelavail.travelsystem.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.travelavail.travelsystem.dto.LoginDTO;
import com.travelavail.travelsystem.dto.UserDTO;
import com.travelavail.travelsystem.entity.Users;
import com.travelavail.travelsystem.response.LoginResponse;
import com.travelavail.travelsystem.repository.UserRepository;
import com.travelavail.travelsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUsers(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override Users addUser(Users user) {
        user.getPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public String addUser(UserDTO userDTO) {

        Users user = new Users();
        user.setUsername(userDTO.getUsername());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());
        user.setCreatedAt(LocalDateTime.now());
        user.setImageUrl(userDTO.getImageUrl());

        userRepository.save(user);

        return user.getEmail();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        Users user = userRepository.findByEmail(loginDTO.getEmail());
        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Users> users = userRepository.findByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (users.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password does not match", false);
            }
        } else {
            return new LoginResponse("Email does not Exist", false);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
