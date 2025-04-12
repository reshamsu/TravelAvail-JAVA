package com.travelavail.travelsystem.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelavail.travelsystem.entity.Payments;
import com.travelavail.travelsystem.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Process payment
    public Payments makePayment(Payments payment) {
        // Set payment status and transaction date
        payment.setStatus(Payments.PaymentStatus.COMPLETED);
        payment.setTransaction_date(LocalDateTime.now()); // Correct way to set the transaction date
        return paymentRepository.save(payment);
    }

    // Retrieve payments by booking ID
    public List<Payments> getPaymentsByBooking(Long paymentId) {
        return paymentRepository.findByPaymentId(paymentId);
    }

    // You could add more methods for other payment operations if needed
}
