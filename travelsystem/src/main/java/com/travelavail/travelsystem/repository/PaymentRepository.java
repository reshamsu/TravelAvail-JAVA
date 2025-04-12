package com.travelavail.travelsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelavail.travelsystem.entity.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {
    List<Payments> findByPaymentId(Long paymentId);
}