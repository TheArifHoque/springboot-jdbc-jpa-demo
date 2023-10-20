package com.arifhoque.main.repository;

import com.arifhoque.main.model.CandidateJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepo extends JpaRepository<CandidateJpa,Integer> {
    List<CandidateJpa> findByCountry(String country);
    @Query("select candidate from CandidateJpa candidate where candidate.name=?2 and candidate.country=?1 or candidate.gender=?3")
    List<CandidateJpa> findByArifsQuery(String country, String name, String gender);
}
