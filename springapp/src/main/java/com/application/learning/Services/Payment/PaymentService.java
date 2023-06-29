package main.java.com.application.learning.Services.Payment;
import main.java.com.application.learning.Exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;
import main.java.com.application.learning.Repository.Payment.PaymentRepository;
import main.java.com.application.learning.Models.Payment.PaymentModel;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository=paymentRepository;
    }

    public PaymentModel savePayment(PaymentModel paymentModel){
        return paymentRepository.save(paymentModel);
    }

    public PaymentModel getPaymentById(Long id){
        Optional<PaymentModel> paymentModel = paymentRepository.findById(id);
        if(paymentModel.isEmpty()){
            throw new ResourceNotFoundException("Employee Not Found With Id :"+id);
        }
        else{
            return paymentModel.get();
        }
    }
}
