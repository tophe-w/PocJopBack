package com.example.pocJop.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @ManyToMany( cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "ligne_gare", joinColumns = @JoinColumn(name = "ligne_id"), inverseJoinColumns = @JoinColumn(name = "gare_id"))
    private List<Gare> gares;
}