package main.java.com.example.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.example.springapp.model.Payment;
import main.java.com.example.springapp.service.PaymentService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    public PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment){
        return new ResponseEntity<Payment>(paymentService.savePayment(payment), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long paymentId){
        return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
    }
    
}
