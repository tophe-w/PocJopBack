package com.example.pocJop.Models;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = { CascadeType.PERSIST, CascadeType.ALL })
    //@JsonIgnoreProperties("category")
    private List<Event> events = new ArrayList<>();

}
