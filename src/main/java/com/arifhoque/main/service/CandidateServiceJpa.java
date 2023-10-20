package com.arifhoque.main.service;
import com.arifhoque.main.model.CandidateJpa;
import com.arifhoque.main.repository.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceJpa {

    @Autowired
    private CandidateRepo candidateRepo;

    public void addCandidate(CandidateJpa candidateJpa) {
        candidateRepo.save(candidateJpa);
    }

    public void updateCandidate(CandidateJpa candidateJpa) {
        candidateRepo.save(candidateJpa);
    }

    public List<CandidateJpa> getAllCandidate() {
        return candidateRepo.findAll();
    }

    public CandidateJpa getById(Integer id) {
        return candidateRepo.findById(id).orElse(null);
    }

    public List<CandidateJpa> getByCountry(String country) {
        return candidateRepo.findByCountry(country);
    }

    public List<CandidateJpa> filterCandidate(String country, String name, String gender) {
        return candidateRepo.findByArifsQuery(country,name,gender);
    }
}
