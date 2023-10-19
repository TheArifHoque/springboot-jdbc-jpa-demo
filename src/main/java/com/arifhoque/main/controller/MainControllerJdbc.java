package com.arifhoque.main.controller;

import com.arifhoque.main.model.CandidateJdbc;
import com.arifhoque.main.service.CandidateServiceJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbc")
public class MainControllerJdbc {

    @Autowired
    private CandidateServiceJdbc candidateServiceJdbc;

    @PostMapping("/add")
    public void addCandidate(@RequestBody CandidateJdbc candidateJdbc) {
        candidateServiceJdbc.addCandidate(candidateJdbc);
    }

    @PostMapping("/update")
    public void updateCandidate(@RequestBody CandidateJdbc candidateJdbc) {
        candidateServiceJdbc.updateCandidate(candidateJdbc);
    }

    @GetMapping("/all")
    public List<CandidateJdbc> getAllCandidate() {
        return candidateServiceJdbc.getAllCandidate();
    }
}
