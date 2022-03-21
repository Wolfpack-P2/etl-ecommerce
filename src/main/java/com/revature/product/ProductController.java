package com.revature.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productTableRepository;

    public ProductController(ProductRepository productTableRepository){
        this.productTableRepository=productTableRepository;
    }
    
    @GetMapping
    public List<Product> getAllProducts(){
        System.out.println(productTableRepository.findAll());
        return productTableRepository.findAll();
    }
}
