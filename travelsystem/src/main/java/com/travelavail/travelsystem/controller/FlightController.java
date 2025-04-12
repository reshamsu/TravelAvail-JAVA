package com.travelavail.travelsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelavail.travelsystem.entity.Flights;
import com.travelavail.travelsystem.service.FlightService;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "*")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/search")
    public List<Flights> searchFlights(@RequestBody Map<String, String> searchParams) {
        return flightService.searchFlights(
                searchParams.get("departure_airport"),
                searchParams.get("arrival_airport"));
    }

    @PostMapping("/add")
    public ResponseEntity<Flights> addFlight(@RequestBody Flights flight) {
        return ResponseEntity.ok(flightService.addFlight(flight));
    }

    @GetMapping("/all")
    public List<Flights> getAllFlights() {
        return flightService.getAllFlights();
    }
}
