package com.example.pocJop.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String code;
    
    // @ManyToOne
    // private Gare gare;
    // @ManyToOne
    // private OlympicSite olympicSite;
}