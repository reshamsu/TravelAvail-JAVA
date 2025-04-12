// package com.travelavail.travelsystem.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.travelavail.travelsystem.entity.Bookings;
// import com.travelavail.travelsystem.service.BookingService;

// @RestController
// @RequestMapping("/api/bookings")
// @CrossOrigin(origins = "*")
// public class BookingController {
//     @Autowired private BookingService bookingService;

//     @PostMapping("/create")
//     public Bookings createBooking(@RequestBody Bookings booking) {
//         return bookingService.createBooking(booking);
//     }

//     @GetMapping("/user/{userId}")
//     public List<Bookings> getUserBookings(@PathVariable Long userId) {
//         return bookingService.getUserBookings(userId);
//     }

//     @PostMapping("/confirm/{booking_id}")
//     public Bookings confirmBooking(@PathVariable Long bookingId) {
//         return bookingService.confirmBooking(bookingId);
//     }
// }

