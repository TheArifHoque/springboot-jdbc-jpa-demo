package com.arifhoque.main.controller;
import com.arifhoque.main.model.CandidateJpa;
import com.arifhoque.main.service.CandidateServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jpa")
public class MainControllerJpa {

    @Autowired
    private CandidateServiceJpa candidateServiceJpa;

    @PostMapping("/add")
    public void addCandidate(@RequestBody CandidateJpa candidateJpa) {
        candidateServiceJpa.addCandidate(candidateJpa);
    }

    @PostMapping("/update")
    public void updateCandidate(@RequestBody CandidateJpa candidateJpa) {
        candidateServiceJpa.updateCandidate(candidateJpa);
    }

    @GetMapping("/all")
    public List<CandidateJpa> getAllCandidate() {
        return candidateServiceJpa.getAllCandidate();
    }

    @GetMapping("/{id}")
    public CandidateJpa getCandidateById(@PathVariable Integer id) {
        return candidateServiceJpa.getById(id);
    }

    @GetMapping("/country/{country}")
    public List<CandidateJpa> getCandidateByCountry(@PathVariable String country) {
        return candidateServiceJpa.getByCountry(country);
    }

    @PostMapping("/filter")
    public List<CandidateJpa> filterCandidate(@RequestBody Map<String, String> request) {
        return candidateServiceJpa.filterCandidate(request.get("country"),request.get("name"),request.get("gender"));
    }
}
