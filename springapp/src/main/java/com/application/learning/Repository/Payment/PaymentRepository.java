package main.java.com.application.learning.Repository.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.com.application.learning.Models.Payment.PaymentModel;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel,Long> {
    
}
