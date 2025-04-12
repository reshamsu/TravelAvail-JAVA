package com.travelavail.travelsystem.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.travelavail.travelsystem.dto.LoginDTO;
import com.travelavail.travelsystem.dto.UserDTO;
import com.travelavail.travelsystem.entity.Users;
import com.travelavail.travelsystem.repository.UserRepository;
import com.travelavail.travelsystem.response.LoginResponse;

@Service
public interface UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
}

    public List<Users> getUser() {
        return userRepository.findAll();
    }

    public Users getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    Users updateUser(Users user);

    void deleteUser(Long id);

    // Other
    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
}
