package com.travelavail.travelsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "carrental_bookings")
public class CarRentals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carRental_id")
    private Long carRental_id;

    private String car_model;
    private String pickup_location;
    private String drop_location;
    private LocalDateTime pickup_date;
    private LocalDateTime dropoff_date;
    private int rental_days;
    private int passengers;
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Bookings booking;

    // Getters and Setters

    public Long getCarRental_id() {
        return carRental_id;
    }

    public void setCarRental_id(Long carRental_id) {
        this.carRental_id = carRental_id;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getPickup_location() {
        return pickup_location;
    }

    public void setPickup_location(String pickup_location) {
        this.pickup_location = pickup_location;
    }

    public String getDrop_location() {
        return drop_location;
    }

    public void setDrop_location(String drop_location) {
        this.drop_location = drop_location;
    }

    public LocalDateTime getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(LocalDateTime pickup_date) {
        this.pickup_date = pickup_date;
    }

    public LocalDateTime getDropoff_date() {
        return dropoff_date;
    }

    public void setDropoff_date(LocalDateTime dropoff_date) {
        this.dropoff_date = dropoff_date;
    }

    public int getRental_days() {
        return rental_days;
    }

    public void setRental_days(int rental_days) {
        this.rental_days = rental_days;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Bookings getBooking() {
        return booking;
    }

    public void setBooking(Bookings booking) {
        this.booking = booking;
    }

}
