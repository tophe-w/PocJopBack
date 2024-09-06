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
public class CapaciteArret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String sens;
    private String hour;
    private String premierTrain;
    private String dernierTrain;
    
    // @ManyToOne
    // private Gare gare;
    // @ManyToOne
    // private Ligne ligne;
}