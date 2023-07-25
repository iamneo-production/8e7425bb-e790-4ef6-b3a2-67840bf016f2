package com.example.springapp.service;

import java.util.Optional;
import com.example.springapp.model.Payment;
import com.example.springapp.repository.PaymentRepository;
import com.example.springapp.security.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }

   public Payment getPaymentById(Long id){
    Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isEmpty()){
            throw new ResourceNotFoundException("Employee Not Found With Id :"+id);
        }
        else{
            return payment.get();
        }
    }
}
    



