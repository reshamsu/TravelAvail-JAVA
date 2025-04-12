package com.travelavail.travelsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelavail.travelsystem.entity.Payments;
import com.travelavail.travelsystem.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired private PaymentService paymentService;

    @PostMapping("/payment")
    public Payments makePayment(@RequestBody Payments payment) {
        return paymentService.makePayment(payment);
    }

    @GetMapping("/booking/{bookingId}")
    public List<Payments> getPayments(@PathVariable Long bookingId) {
        return paymentService.getPaymentsByBooking(bookingId);
    }
}

