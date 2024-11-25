package com.example.pocJop.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Gare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String planDeGare;
    private String planDeGareSvg;
    private String accessibilite;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ligne_gare", joinColumns = @JoinColumn(name = "gare_id"), inverseJoinColumns = @JoinColumn(name = "ligne_id"))
    @JsonIgnoreProperties("gares")
    private List<Ligne> lignes = new ArrayList<>();
   

    @OneToMany(mappedBy = "gare")
    @JsonIgnoreProperties("gare")
    private List<Affluence> affluences = new ArrayList<>();
  

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "site_gare", joinColumns = @JoinColumn(name = "gare_id"), inverseJoinColumns = @JoinColumn(name = "site_id"))
    @JsonIgnoreProperties("gares")
    private List<Site> sites = new ArrayList<>();

}