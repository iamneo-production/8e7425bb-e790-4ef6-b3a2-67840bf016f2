package com.example.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Payment;
import com.example.springapp.service.PaymentService;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
//santhosh
@CrossOrigin(origins = "https://8081-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io")

//ramesh
//@CrossOrigin(origins = "https://8081-febcaabfefeacfadcdddffaedcbcabfdfafdade.project.examly.io")

//rithick
//@CrossOrigin(origins = "https://8081-ccfbbdadfbadcdddffaedcbcabfdfafdade.project.examly.io")

//oviya
//@CrossOrigin(origins = "https://8081-bfbbbeacbadcdddffaedcbcabfdfafdade.project.examly.io")

//joshika
//@CrossOrigin(origins = "https://8081-fdfedfdaaaacfedbadcdddffaedcbcabfdfafdade.project.examly.io")

//sumanth
//@CrossOrigin(origins = "https://8081-daeacaadbcfaeadcdddffaedcbcabfdfafdade.project.examly.io")

//mrinal
//@CrossOrigin(origins = "https://8081-fbbfbccabebadcdddffaedcbcabfdfafdade.project.examly.io")

//muskan
//@CrossOrigin(origins = "https://8081-ddefcefdabfbdadcdddffaeeaeaadbdbabf.project.examly.io")

//rishik
//@CrossOrigin(origins = "https://8081-caccdedfdbdccefeadcdddffaedcbcabfdfafdade.project.examly.io")

@RequestMapping("/payment")
public class PaymentController {
    public PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping()
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment){
        return new ResponseEntity<Payment>(paymentService.savePayment(payment), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long paymentId){
        return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<List<Payment>> getPaymentsByUserId(@PathVariable Long id) {
        List<Payment> payments = paymentService.getPaymentsByUserId(id);
        return ResponseEntity.ok(payments);
    }
    
}
