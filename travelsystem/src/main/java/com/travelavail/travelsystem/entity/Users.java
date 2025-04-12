package com.travelavail.travelsystem.entity;

import java.time.LocalDateTime;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

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
    private Role role = Role.USER; // Default role as USER

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING; // Default status as PENDING

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private String imageUrl;

   public Users(Long userId, String username, String firstname, String lastname, String email, String password,
            Role role, Status status, LocalDateTime createdAt, String imageUrl) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
    }

    public Users() {

    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    // Automatic Password Encoding
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
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public enum Role {
        ADMIN, USER
    }

    public enum Status {
        DEFAULT, APPROVED, PENDING, REJECTED
    }

    @Override
    public String toString() {
        return "Users [userId=" + userId + ", username=" + username + ", firstname=" + firstname + ", lastname="
                + lastname + ", email=" + email + ", password=" + password + ", role=" + role + ", status=" + status
                + ", createdAt=" + createdAt + ", imageUrl=" + imageUrl + "]";
    }

}
