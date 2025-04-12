package com.travelavail.travelsystem.dto;

import com.travelavail.travelsystem.entity.Users.Role;
import com.travelavail.travelsystem.entity.Users.Status;

public class UserDTO {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role = Role.USER;  
    private Status status = Status.PENDING; 
    private String imageUrl;

    // Constructors
    public UserDTO(String username, String firstname, String lastname, String email, String password, Role role, Status status, String imageUrl) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = Role.USER;
        this.status = Status.PENDING;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
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

    public void setPassword(String password) {
        this.password = password;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
