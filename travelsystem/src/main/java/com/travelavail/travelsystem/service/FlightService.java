package com.travelavail.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelavail.travelsystem.entity.Flights;
import com.travelavail.travelsystem.repository.FlightRepository;

    @Service
    public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flights> searchFlights(String departureAirport, String arrivalAirport) {
        return flightRepository.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport);
    }

    public Flights addFlight(Flights flight) {
        return flightRepository.save(flight);
    }

    public List<Flights> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flights getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}