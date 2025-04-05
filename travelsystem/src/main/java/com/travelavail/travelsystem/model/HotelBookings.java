package com.travelavail.travelsystem.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_bookings")
public class HotelBookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotel_id;

    private String hotel_name;
    private String located_city;
    private LocalDateTime checkin_date;
    private LocalDateTime checkout_date;
    private int rooms;
    private int guests;
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Bookings booking;

    // Getters and Setters

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getLocated_city() {
        return located_city;
    }

    public void setLocated_city(String located_city) {
        this.located_city = located_city;
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

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
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
