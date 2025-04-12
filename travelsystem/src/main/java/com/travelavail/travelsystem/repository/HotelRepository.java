package com.travelavail.travelsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelavail.travelsystem.entity.Hotels;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
    List<Hotels> findByDestinationHotelName(String destinationHotelName);
}


