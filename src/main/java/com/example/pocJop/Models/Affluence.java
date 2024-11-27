package com.example.pocJop.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private int estimationUp;
    private int estimationDown;
    private int affluenceHabituelleUp;
    private int affluenceHabituelleDown;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gare_id")
    private Gare gare;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "date_hour_for_flux_id")
    private DateHourForFlux dateHourForFlux;

    
   
}

