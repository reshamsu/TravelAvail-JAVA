package com.travelavail.travelsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int booking_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key referencing Users
    private Users user;

    @Column(nullable = false)
    private String booking_type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.UPCOMING; // Default status

    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") // Correct format for JSON serialization
    private LocalDateTime booking_date;

    @Column(nullable = false)
    private double total_amount;

    // Constructor with automatic date-time setting
    public Bookings() {
        this.booking_date = LocalDateTime.now(); // Sets created date and time automatically
    }

    public enum Status {
        UPCOMING, COMPLETED, CANCELLED, RESCHEDULED
    }

    // Getters and Setters
    public int getBookingId() {
        return booking_id;
    }

    public void setBookingId(int booking_id) {
        this.booking_id = booking_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getBookingType() {
        return booking_type;
    }

    public void setBookingType(String booking_type) {
        this.booking_type = booking_type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getBookingDate() {
        return booking_date;
    }

    public void setBookingDate(LocalDateTime booking_date) {
        this.booking_date = booking_date;
    }

    public double getTotalAmount() {
        return total_amount;
    }

    public void setTotalAmount(double total_amount) {
        this.total_amount = total_amount;
    }
}
