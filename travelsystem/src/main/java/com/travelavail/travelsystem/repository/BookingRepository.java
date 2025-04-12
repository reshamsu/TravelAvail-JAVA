package com.travelavail.travelsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelavail.travelsystem.entity.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long> {
    List<Bookings> findByUser_UserId(Long userId);
}
