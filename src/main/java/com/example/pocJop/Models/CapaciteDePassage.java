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
public class CapaciteDePassage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sens;
    private String date;
    private String hour;
    private int trainsByHourCount;
    
    // @ManyToOne
    // private Gare gare;
    // @ManyToOne
    // private Ligne ligne;
}