package com.example.demo.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Troncon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String gareCode;
    private String ligneCode;
    private String sens;
    private int ordre;
    
    // @ManyToOne
    // private Gare gare;
    // @ManyToOne
    // private Ligne ligne;
}