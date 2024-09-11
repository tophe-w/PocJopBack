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
import jakarta.persistence.OneToOne;
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
    private String idGareIdfm;
    private String planDeGare;
    private String planDeGareSvg;
    private String accessibilite;

    @ManyToMany(mappedBy = "gares")
    @JsonIgnoreProperties("gares")
    private List<Ligne> lignes = new ArrayList<>();

    @ManyToMany
    @JsonIgnoreProperties("gares")
    private List<OlympicSite> olympicSites = new ArrayList<>();

    @OneToMany(mappedBy = "gare") 
    @JsonIgnoreProperties("gare")
    private List<CapaciteDePassage> capaciteDePassages = new ArrayList<>();


    @OneToMany(mappedBy = "gare") 
    @JsonIgnoreProperties("gare")
    private List<CapaciteArret> capaciteArrets = new ArrayList<>();

    @OneToMany(mappedBy = "gare")
    @JsonIgnoreProperties("gare")
    private List<Troncon> troncons = new ArrayList<>();

    @OneToOne(mappedBy = "gares")
    @JsonIgnoreProperties("gares")
    private Affluence affluence;

}