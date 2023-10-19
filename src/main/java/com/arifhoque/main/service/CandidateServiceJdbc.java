package com.arifhoque.main.service;

import com.arifhoque.main.model.CandidateJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCandidate(CandidateJdbc candidateJdbc) {
        //insert into candidate_table(id, name, country) values (101,'ABC','Bangladesh');
        jdbcTemplate.update("insert into candidate_table(id,name,country,gender) values(?,?,?,?)",
                candidateJdbc.getId(),candidateJdbc.getName(),candidateJdbc.getCountry(),candidateJdbc.getGender());
    }

    public void updateCandidate(CandidateJdbc candidateJdbc) {
        //update candidate_table set name='ABC', country='India', gender='Male' where id=102
        jdbcTemplate.update("update candidate_table set name=?, country=?, gender=? where id=?",
                candidateJdbc.getName(),candidateJdbc.getCountry(),candidateJdbc.getGender(),candidateJdbc.getId());
    }

    public List<CandidateJdbc> getAllCandidate() {
        //select * from candidate_table
        return jdbcTemplate.query("select * from candidate_table",
                (rs, rowNum) -> new CandidateJdbc(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getString("gender")
                )
        );
    }
}
