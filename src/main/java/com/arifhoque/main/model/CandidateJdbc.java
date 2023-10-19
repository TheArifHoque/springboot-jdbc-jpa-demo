package com.arifhoque.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CandidateJdbc {
    private Integer id;
    private String name;
    private String gender;
    private String country;
}
