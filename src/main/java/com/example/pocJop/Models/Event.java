package com.example.pocJop.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startEvent;
    private LocalDateTime endEvent;
    private String description;
    private int nbPeopleExpected;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "site_id")
    // @JsonIgnoreProperties("events")
    private Site site;

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    // @JsonIgnoreProperties("events")
    private Category category;
}
