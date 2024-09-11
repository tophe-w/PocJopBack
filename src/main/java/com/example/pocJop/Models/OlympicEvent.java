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
public class OlympicEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String start;
    private String end;
    private boolean isEventStart;


    @ManyToOne  
    @JoinColumn(name = "olympicDiscipline_id")
    @JsonIgnoreProperties("olympicEvents")
    private OlympicDiscipline olympicDiscipline;

    // @ManyToMany
    // @JoinTable(name = "olympicEvent_gare", joinColumns = @JoinColumn(name = "olympicEvent_id"), inverseJoinColumns = @JoinColumn(name = "gare_id"))
    // @JsonIgnoreProperties("olympicEvents")
    // private List<Gare> gares = new ArrayList<>();

    // @OneToOne
    // @JoinColumn(name = "olympicSite_id")
    // @JsonIgnoreProperties("olympicEvents")
    // private OlympicSite olympicSite;

    // @OneToOne
    // @JoinColumn(name = "olympicDiscipline_id")
    // @JsonIgnoreProperties("olympicEvents")
    // private OlympicDiscipline olympicDiscipline;

}