package com.travelavail.travelsystem.service;

import com.travelavail.travelsystem.model.Bookings;
import java.util.List;

public interface BookingService {

    void saveBooking(Bookings bookings); // Method to save a bookings

    List<Bookings> getAllBookings(); // Method to get all bookings
}
