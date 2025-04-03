package com.travelavail.travelsystem.service;

import com.travelavail.travelsystem.model.Users;
import java.util.List;

public interface UserService {

    Users saveUser(Users users); // Method to save a user

    List<Users> getAllUsers(); // Method to get all users
}
