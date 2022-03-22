package com.revature.question3;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question3")
public class Question3Controller {
    
    private Question3Repository question3Repository;
    
    public Question3Controller(Question3Repository question3Repository) {
        this.question3Repository = question3Repository;
    }
    
    @RequestMapping
    public List<Question3> getAllQuestion() {
        return question3Repository.findAll();
    }
}
