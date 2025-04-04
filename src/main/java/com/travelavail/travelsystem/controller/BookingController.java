package com.travelavail.travelsystem.controller;

import com.travelavail.travelsystem.model.Bookings;
import com.travelavail.travelsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Bookings bookings) {
        try {
            bookingService.saveBooking(bookings);
            return ResponseEntity.ok("New Booking Added");
        } catch (Exception e) {
            logger.error("Error adding booking: ", e); // Log error details
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Bookings>> getAllBookings() {
        List<Bookings> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}
