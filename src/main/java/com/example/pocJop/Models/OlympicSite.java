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
public class OlympicSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private boolean navette;
    private boolean fontaine;
    
    //  @OneToMany(mappedBy = "olympicSite")
    //  private List<Ligne> lignes = new ArrayList<>();
    //  @OneToMany(mappedBy = "olympicSite")
    //  private List<Discipline> disciplines = new ArrayList<>();
}