package com.example.pocJop.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class OlympicEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String start;
    private String end;
    private boolean isEventStart;
    
    // @ManyToOne
    // private OlympicSite olympicSite;
    // @ManyToOne
    // private OlympicDiscipline olympicDiscipline;
}