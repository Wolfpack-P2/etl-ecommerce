package com.revature.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerTableRepository;

    public CustomerController(CustomerRepository customerTableRepository){
        this.customerTableRepository = customerTableRepository;
    }
    
    @GetMapping
    public List<Customer> getAllCustomers(){
        System.out.println(customerTableRepository.findAll());
        return customerTableRepository.findAll();
    }
}


