package com.arifhoque.main.controller;

import com.arifhoque.main.model.CandidateJdbc;
import com.arifhoque.main.service.CandidateServiceJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/filter")
    public List<CandidateJdbc> filterCandidate(@RequestBody Map<String,String> request) {
        return candidateServiceJdbc.filterCandidate(request.get("country"),request.get("name"), request.get("gender"));
    }
}
