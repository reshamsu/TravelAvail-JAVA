package com.travelavail.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelavail.travelsystem.entity.Hotels;
import com.travelavail.travelsystem.repository.HotelRepository;

    @Service
    public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotels> searchHotels(String destinationHotelName) {
        return hotelRepository.findByDestinationHotelName(destinationHotelName);
    }

    public Hotels addFlight(Hotels hotels) {
        return hotelRepository.save(hotels);
    }

    public List<Hotels> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotels getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}