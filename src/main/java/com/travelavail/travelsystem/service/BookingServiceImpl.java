package com.travelavail.travelsystem.service;

import com.travelavail.travelsystem.model.Bookings;
import com.travelavail.travelsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void saveBooking(Bookings bookings) {
        if (bookings.getUser() == null) {
            throw new IllegalArgumentException("User must be provided");
        }
        bookingRepository.save(bookings);  // Save booking to DB
    }

    public List<Bookings> getAllBookings() {
        return bookingRepository.findAll();
    }
}
