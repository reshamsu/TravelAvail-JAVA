package com.travelavail.travelsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "flight_bookings")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long flight_id;

    private String airline_name;
    private String airline_class;
    private String flight_number;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departure_date;
    private LocalDateTime return_date;
    private int passengers;
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Bookings booking;

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getAirline_class() {
        return airline_class;
    }

    public void setAirline_class(String airline_class) {
        this.airline_class = airline_class;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getDeparture_airport() {
        return departureAirport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departureAirport = departure_airport;
    }

    public String getArrival_airport() {
        return arrivalAirport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrivalAirport = arrival_airport;
    }

    public LocalDateTime getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(LocalDateTime departure_date) {
        this.departure_date = departure_date;
    }

    public LocalDateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        this.return_date = return_date;
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
