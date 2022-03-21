package com.revature.research;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/research")
public class ResearchController {

    private ResearchRepository researchRepository;

    public ResearchController(ResearchRepository researchRepository) {
        this.researchRepository = researchRepository;
    }

    @RequestMapping
    public List<Research> getAllResearch() {
        return researchRepository.findAll();
    }
}
