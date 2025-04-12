// package com.travelavail.travelsystem.service;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.travelavail.travelsystem.repository.BookingRepository;
// import com.travelavail.travelsystem.entity.Bookings;
// import com.travelavail.travelsystem.exception.ResourceNotFoundException; // Assuming custom exception

// @Service
// public class BookingService {
//     @Autowired 
//     private BookingRepository bookingRepository;

//     // Create a new booking
//     public Bookings createBooking(Bookings booking) {
//         booking.setStatus(Bookings.BookingStatus.PENDING);  // Default status
//         booking.setBookingDate(LocalDateTime.now()); // Set booking date to current time
//         return bookingRepository.save(booking);
//     }

//     // Get all bookings for a user
//     public List<Bookings> getUserBookings(Long userId) {
//         return bookingRepository.findByUserId(userId);
//     }

//     // Confirm a booking
//     public Bookings confirmBooking(Long bookingId) {
//         Optional<Bookings> bookingOptional = bookingRepository.findById(bookingId);
        
//         // Check if booking exists
//         if (bookingOptional.isEmpty()) {
//             throw new ResourceNotFoundException("Booking not found for id: " + bookingId);
//         }

//         Bookings booking = bookingOptional.get();
//         booking.setStatus(Bookings.BookingStatus.COMPLETED);
//         return bookingRepository.save(booking);
//     }
// }
