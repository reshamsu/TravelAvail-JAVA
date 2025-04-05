package com.travelavail.travelsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long booking_id;

    @Column(name = "booking_date")
    private LocalDateTime booking_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_type")
    private BookingType bookingType = BookingType.NOT_SET;

    @Column(name = "total_amount")
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "mood_id", referencedColumnName = "mood_id")
    private Moods mood;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private FlightBookings flight;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
    private HotelBookings hotel;

    @ManyToOne
    @JoinColumn(name = "carRental_id", referencedColumnName = "carRental_id")
    private CarRentalBookings carRental;

    public enum BookingType {
        NOT_SET, FLIGHT, HOTEL, CAR_RENTAL
    }

    // Getters and Setters

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }

    public LocalDateTime getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(LocalDateTime booking_date) {
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

    public FlightBookings getFlight() {
        return flight;
    }

    public void setFlight(FlightBookings flight) {
        this.flight = flight;
    }

    public HotelBookings getHotel() {
        return hotel;
    }

    public void setHotel(HotelBookings hotel) {
        this.hotel = hotel;
    }

    public CarRentalBookings getCarRental() {
        return carRental;
    }

    public void setCarRental(CarRentalBookings carRental) {
        this.carRental = carRental;
    }
}
