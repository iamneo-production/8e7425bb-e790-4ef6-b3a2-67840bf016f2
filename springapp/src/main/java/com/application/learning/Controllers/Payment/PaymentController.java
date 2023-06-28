package main.java.com.application.learning.Controllers.Payment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import main.java.com.application.learning.Models.Payment.PaymentModel;
import main.java.com.application.learning.Services.Payment.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    public PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping()
    public ResponseEntity<PaymentModel> savePayment(@RequestBody PaymentModel paymentModel){
        return new ResponseEntity<PaymentModel>(paymentService.savePayment(paymentModel), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PaymentModel> getPaymentById(@PathVariable("id") Long paymentId){
        return new ResponseEntity<PaymentModel>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
    }

}
