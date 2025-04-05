package com.travelavail.travelsystem.model;

import java.time.LocalDateTime;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id; 

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.TRAVELER; // Default role as TRAVELER

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING; // Default status as PENDING

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    private String image_url;

    public Users() {
        this.created_at = LocalDateTime.now(); // Automatically set creation time
    }

    @PrePersist
    public void prePersist() {
        if (this.created_at == null) {
            this.created_at = LocalDateTime.now();
        }
    }

    public enum Role {
        ADMIN, TRAVELER
    }

    public enum Status {
        DEFAULT, APPROVED, PENDING, REJECTED
    }

    // Getters and Setters

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    // Password Hashing for Better Security
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void setPassword(String password) {
        this.password = encoder.encode(password);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
