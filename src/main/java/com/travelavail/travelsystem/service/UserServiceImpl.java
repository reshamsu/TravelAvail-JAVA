package com.travelavail.travelsystem.service;

import com.travelavail.travelsystem.model.Users;
import com.travelavail.travelsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users saveUser(Users users) {
        try {
            return userRepository.save(users);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("User could not be saved due to a database integrity issue.", e);
        }
    }

    @Override
    public List<Users> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while retrieving users from the database.", e);
        }
    }
}
