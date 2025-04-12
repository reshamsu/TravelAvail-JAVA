package com.travelavail.travelsystem.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.travelavail.travelsystem.entity.Users;
import com.travelavail.travelsystem.repository.UserRepository;

public class MyUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("This user does not exist in the database");
        }
        return user;
    }
}
