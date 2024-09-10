package com.example.pocJop.Models;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Gare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String plan_de_gare;
    private String plan_de_gare_svg;
    private String accessibilite;

    @ManyToMany(mappedBy = "gares")
    @JsonIgnoreProperties("gares")
    private List<Ligne> lignes = new ArrayList<>();

    @ManyToMany(mappedBy = "gares")
    @JsonIgnoreProperties("gares")
    private List<OlympicSite> olympicSites = new ArrayList<>();

    // @ManyToMany(mappedBy = "gares")
    // @JsonIgnoreProperties("gares")
    // private List<OlympicEvent> olympicEvents = new ArrayList<>();

    
}