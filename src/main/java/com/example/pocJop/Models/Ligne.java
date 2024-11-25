package com.example.pocJop.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ligne_gare", joinColumns = @JoinColumn(name = "ligne_id"), inverseJoinColumns = @JoinColumn(name = "gare_id"))
    @JsonIgnoreProperties("lignes")  
    private List<Gare> gares = new ArrayList<>();

    // @ManyToMany
    // @JoinTable(name = "ligne_olympicSite", joinColumns = @JoinColumn(name = "ligne_id"), inverseJoinColumns = @JoinColumn(name = "olympicSite_id"))
    // @JsonIgnoreProperties("lignes")
    // private List<OlympicSite> olympicSites = new ArrayList<>();
}