package com.travelavail.travelsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_bookings")
public class Hotels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotel_id;

    private String destinationHotelName;
    private LocalDateTime checkin_date;
    private LocalDateTime checkout_date;
    private String location;
    private int available_rooms;
    private double pricePerNight;
    private int guests;
    private Float rating;
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Bookings booking;

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getDestinationHotelName() {
        return destinationHotelName;
    }

    public void getDestinationHotelName(String destinationHotelName) {
        this.destinationHotelName = destinationHotelName;
    }

    public LocalDateTime getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(LocalDateTime checkin_date) {
        this.checkin_date = checkin_date;
    }

    public LocalDateTime getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(LocalDateTime checkout_date) {
        this.checkout_date = checkout_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAvailable_rooms() {
        return available_rooms;
    }

    public void setAvailable_rooms(int available_rooms) {
        this.available_rooms = available_rooms;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
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
