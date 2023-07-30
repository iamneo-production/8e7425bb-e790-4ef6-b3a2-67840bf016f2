package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
    List<Payment> findAllByUserId(Long userId);
}
