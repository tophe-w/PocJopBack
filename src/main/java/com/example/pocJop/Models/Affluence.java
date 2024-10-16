package com.example.pocJop.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "gares_id")
    @JsonIgnoreProperties("affluence")
    private Gare gares;
}