package com.revature.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private  PaymentRepository paymentTableRepository;

    public PaymentController(PaymentRepository paymentTableRepository){
        this.paymentTableRepository = paymentTableRepository;
    }
    
    @GetMapping
    public List<Payment> getAllPayments(){
        System.out.println(paymentTableRepository.findAll());
        return paymentTableRepository.findAll();
    }
}

