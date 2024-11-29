package com.example.pocJop.Models;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Gare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String planDeGare;
    private String planDeGareSvg;
    private String accessibilite;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "ligne_gare", joinColumns = @JoinColumn(name = "gare_id"), inverseJoinColumns = @JoinColumn(name = "ligne_id"))
    private List<Ligne> lignes;
   

    @OneToMany(mappedBy = "gare", cascade = { CascadeType.PERSIST, CascadeType.ALL })
    private List<Affluence> affluences;
  

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "site_gare", joinColumns = @JoinColumn(name = "gare_id"), inverseJoinColumns = @JoinColumn(name = "site_id"))
    private List<Site> sites;

}