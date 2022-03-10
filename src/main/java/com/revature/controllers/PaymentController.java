package com.revature.controllers;

import com.revature.models.OrderEntity;
import com.revature.models.PayementEntity;
import com.revature.repositories.PaymentTableRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    PaymentTableRepository paymentTableRepository;
    public PaymentController(PaymentTableRepository paymentTableRepository){
        this.paymentTableRepository=paymentTableRepository;
    }
    @GetMapping
    public List<PayementEntity> getAllPayments(){
        System.out.println(paymentTableRepository.findAll());
        return paymentTableRepository.findAll();
    }
}

