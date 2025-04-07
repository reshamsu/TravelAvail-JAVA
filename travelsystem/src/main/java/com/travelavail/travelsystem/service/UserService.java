package com.travelavail.travelsystem.service;

import com.travelavail.travelsystem.model.Users;
import com.travelavail.travelsystem.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Optional<Users> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            var userObj = user.get();
            // Builds user details object with roles and other required information
            return User.builder()
                    .username(userObj.getUsername()) 
                    .password(userObj.getPassword())
                    .roles(userObj.getRole().name()) 
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}