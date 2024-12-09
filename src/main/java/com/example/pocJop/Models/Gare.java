package com.example.pocJop.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.CascadeType;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Gare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String planDeGare;
    private String planDeGareSvg;
    private String accessibilite;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "ligne_gare", joinColumns = @JoinColumn(name = "gare_id"), inverseJoinColumns = @JoinColumn(name = "ligne_id"))
    private List<Ligne> lignes;
   

    @OneToMany(mappedBy = "gare", cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private List<Affluence> affluences;

    @ManyToOne(fetch = FetchType.LAZY)
    private DateCalendar dateCalendar;
  

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;


    @ManyToMany( cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "site_gare", joinColumns = @JoinColumn(name = "gare_id"), inverseJoinColumns = @JoinColumn(name = "site_id"))
    private List<Site> sites;

}