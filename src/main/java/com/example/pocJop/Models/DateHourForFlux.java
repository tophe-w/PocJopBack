package com.example.pocJop.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class DateHourForFlux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "calendar_date_for_flux_id")
    private CalendarDateForFlux calendarDateForFlux;

    @ManyToOne
    @JoinColumn(name = "hour_for_flux_id")
    private HourForFlux hourForFlux;
    

    @OneToMany(mappedBy = "dateHourForFlux", cascade = { CascadeType.PERSIST, CascadeType.ALL })
    private List<Affluence> affluence = new ArrayList<>();
}
