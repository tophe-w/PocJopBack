package com.example.pocJop.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class CapaciteDePassage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sens;
    private String date;
    private String hour;
    private int trainsByHourCount;

    @ManyToOne
    @JoinColumn(name = "gare_id")
    @JsonIgnoreProperties("capaciteDePassages")
    private Gare gare;

}