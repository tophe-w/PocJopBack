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
public class Affluence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String hourOfDay;
    private int estimationParisUp;
    private int estimationParisDown;
    private int affluenceHabituelleUp;
    private int affluenceHabituelleDown;
    
    // @ManyToOne
    // private Gare gare;
}