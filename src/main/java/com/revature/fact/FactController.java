package com.revature.fact;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facts")
public class FactController {

    private FactRepository factTableRepository;

    public FactController(FactRepository factTableRepository){
        this.factTableRepository = factTableRepository;
    }

    @GetMapping
    public List<Fact> getAllFacts(){
        System.out.println(factTableRepository.findAll());
        return factTableRepository.findAll();
    }
}
