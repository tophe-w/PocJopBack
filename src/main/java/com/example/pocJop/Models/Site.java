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
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String town;
    private String description;

    @ManyToMany
    @JoinTable(name = "site_gare", joinColumns = @JoinColumn(name = "site_id"), inverseJoinColumns = @JoinColumn(name = "gare_id"))
    @JsonIgnoreProperties("site")
    private List<Gare> gares = new ArrayList<>();

    @OneToMany(mappedBy = "site")
    @JsonIgnoreProperties("site")
    private List<Event> events = new ArrayList<>();

}
