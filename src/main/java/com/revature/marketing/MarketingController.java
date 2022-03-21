package com.revature.marketing;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/marketing")
public class MarketingController {

    private MarketingRepository marketingRepository;

    public MarketingController(MarketingRepository marketingRepository) {
        this.marketingRepository = marketingRepository;
    }

    @GetMapping
    public List<Marketing> getAllMarkets() {
        System.out.println(marketingRepository.findAll());
        return marketingRepository.findAll();
    }
}
