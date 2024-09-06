package com.example.pocJop.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Gare{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String code;
    private String plan_de_gare;
    private String plan_de_gare_svg;
    private String accessible;
    
    // @OneToMany(mappedBy = "gare")
    // private List<Ligne> lignes = new ArrayList<>();
    // @OneToMany(mappedBy = "gare")
    // private List<OlympicSite> olympicSites = new ArrayList<>();

}