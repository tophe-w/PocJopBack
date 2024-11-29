package com.example.pocJop.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class HourForFlux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hour;

    @OneToMany(mappedBy = "hourForFlux", cascade = { CascadeType.PERSIST, CascadeType.ALL })
    private List<DateHourForFlux> dateHourForFlux = new ArrayList<>();

}
