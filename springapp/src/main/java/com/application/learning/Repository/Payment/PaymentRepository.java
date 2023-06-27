package main.java.com.application.learning.Repository.Payment;

import main.java.com.application.learning.Models.Payment.PaymentModel;

public interface PaymentRepository extends JpaRepository<PaymentModel,Long> {
    
}
