package com.example.pocJop.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class OlympicSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private boolean navette;
    private boolean fontaine;
    
    //  @OneToMany(mappedBy = "olympicSite")
    //  private List<Ligne> lignes = new ArrayList<>();
    //  @OneToMany(mappedBy = "olympicSite")
    //  private List<Discipline> disciplines = new ArrayList<>();
}