package com.example.pocJop.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class OlympicSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private boolean navette;
    private boolean fontaine;
    

    @ManyToMany
    @JoinTable(name = "olympicSite_gare", joinColumns= @JoinColumn(name = "olympicSite_id"), inverseJoinColumns = @JoinColumn(name = "gare_id"))
    @JsonIgnoreProperties("olympicSites")
    private List<Gare> gares = new ArrayList<>();
    
    // @ManyToMany(mappedBy = "olympicSites")
    // @JsonIgnoreProperties({ "olympicSites", "lignes" })
    // private List<Ligne> lignes = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "olympicSite_olympicDiscipline", joinColumns= @JoinColumn(name = "olympicSite_id"), inverseJoinColumns = @JoinColumn(name = "olympicDiscipline_id"))
    @JsonIgnoreProperties("olympicSites")
    private List<OlympicDiscipline> olympicDisciplines = new ArrayList<>();


}