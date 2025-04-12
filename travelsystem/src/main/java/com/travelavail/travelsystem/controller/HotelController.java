package com.travelavail.travelsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelavail.travelsystem.entity.Hotels;
import com.travelavail.travelsystem.repository.HotelRepository;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    // Get all hotels
    @GetMapping("/all")
    public ResponseEntity<List<Hotels>> getAllHotels() {
        List<Hotels> hotels = hotelRepository.findAll();
        if (hotels.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(hotels);
    }

    // Search hotels based on location (no mood filter if not in model)
    @GetMapping("/search")
    public ResponseEntity<List<Hotels>> searchHotels(@RequestParam(required = false) String destination_hotel_name) {
        List<Hotels> hotels;
        if (destination_hotel_name != null) {
            hotels = hotelRepository.findByDestinationHotelName(destination_hotel_name);
        } else {
            hotels = hotelRepository.findAll();
        }
        if (hotels.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(hotels);
    }

    // Add a new hotel
    @PostMapping("/add")
    public ResponseEntity<Hotels> addHotel(@RequestBody Hotels hotel) {
        try {
            Hotels savedHotel = hotelRepository.save(hotel);
            return ResponseEntity.status(201).body(savedHotel); // Created response
        } catch (Exception e) {
            return ResponseEntity.status(400).build(); // Bad request
        }
    }

    // Update a hotel (Optional, you may want to add this if necessary)
    @PutMapping("/{hotel_id}")
    public ResponseEntity<Hotels> updateHotel(@PathVariable Long hotel_id, @RequestBody Hotels hotel) {
        if (!hotelRepository.existsById(hotel_id)) {
            return ResponseEntity.notFound().build();
        }
        hotel.setHotel_id(hotel_id);
        Hotels updatedHotel = hotelRepository.save(hotel);
        return ResponseEntity.ok(updatedHotel);
    }

    // Delete a hotel by ID
    @DeleteMapping("/{hotel_id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long hotel_id) {
        if (!hotelRepository.existsById(hotel_id)) {
            return ResponseEntity.notFound().build();
        }
        hotelRepository.deleteById(hotel_id);
        return ResponseEntity.noContent().build(); // No content on successful deletion
    }
}
