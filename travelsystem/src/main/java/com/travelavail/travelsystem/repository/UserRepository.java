package com.travelavail.travelsystem.repository;

import com.travelavail.travelsystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmailAndPassword(String email, String password);
    Users findByUsername(String username);
    Users findByEmail(String email);
}
