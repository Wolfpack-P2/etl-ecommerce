package com.revature.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderTableRepository;

    public OrderController(OrderRepository orderTableRepository){
        this.orderTableRepository=orderTableRepository;
    }
    
    @GetMapping
    public List<Order> getAllOrders(){
        System.out.println(orderTableRepository.findAll());
        return orderTableRepository.findAll();
    }
}
