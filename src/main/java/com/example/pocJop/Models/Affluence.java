package com.example.pocJop.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Affluence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String hourOfDay;
    private int estimationParisUp;
    private int estimationParisDown;
    private int affluenceHabituelleUp;
    private int affluenceHabituelleDown;
    
    // @ManyToOne
    // private Gare gare;
}