package com.example.pocJop.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Region {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "region", cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private List<Gare> gares = new ArrayList<>();
    
}
