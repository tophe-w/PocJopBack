package com.example.pocJop.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class OlympicDiscipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;




    @OneToMany(mappedBy = "olympicDiscipline")
    @JsonIgnoreProperties("olympicDiscipline")
    private List<OlympicEvent> olympicEvents = new ArrayList<>();





    // @ManyToMany
    // @JoinTable(name = "olympicDisciplines_olympicSites", joinColumns = @JoinColumn(name = "olympicDiscipline_id"), inverseJoinColumns = @JoinColumn(name = "olympicSite_id"))
    // @JsonIgnoreProperties("olympicDisciplines")
    // private List<OlympicSite> olympicSites = new ArrayList<>();
}