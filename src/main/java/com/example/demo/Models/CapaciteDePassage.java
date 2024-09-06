package com.example.demo.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CapaciteDePassage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sens;
    private String date;
    private String hour;
    private int trainsByHourCount;
    
    // @ManyToOne
    // private Gare gare;
    // @ManyToOne
    // private Ligne ligne;
}