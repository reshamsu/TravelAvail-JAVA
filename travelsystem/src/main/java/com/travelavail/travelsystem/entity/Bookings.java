package com.travelavail.travelsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "booking_date")
    private LocalDateTime booking_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_type")
    private BookingType bookingType = BookingType.NOT_SET;

    @Column(name = "total_amount")
    private double totalAmount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "mood_id", referencedColumnName = "mood_id")
    private Moods mood;

    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private Payments payments;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private Flights flight;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
    private Hotels hotel;

    @ManyToOne
    @JoinColumn(name = "carRental_id", referencedColumnName = "carRental_id")
    private CarRentals carRental;

    public enum BookingType {
        NOT_SET, FLIGHT, HOTEL, CAR_RENTAL
    }

    public enum BookingStatus {
        PENDING, COMPLETED, CANCELLED
    }

    // Getters and Setters

    public Long getBooking_id() {
        return bookingId;
    }

    public void setBooking_id(Long booking_id) {
        this.bookingId = booking_id;
    }

    public LocalDateTime getBooking_date() {
        return booking_date;
    }

    public void setBookingDate(LocalDateTime booking_date) {
        this.booking_date = booking_date;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Moods getMood() {
        return mood;
    }

    public void setMood(Moods mood) {
        this.mood = mood;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public Hotels getHotel() {
        return hotel;
    }

    public void setHotel(Hotels hotel) {
        this.hotel = hotel;
    }

    public CarRentals getCarRental() {
        return carRental;
    }

    public void setCarRental(CarRentals carRental) {
        this.carRental = carRental;
    }
}
