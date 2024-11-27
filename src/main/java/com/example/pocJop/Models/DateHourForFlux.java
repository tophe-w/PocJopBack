package com.example.pocJop.Models;

import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class DateHourForFlux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calendar_date_for_flux_id")
    private CalendarDateForFlux calendarDateForFlux;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hour_for_flux_id")
    private HourForFlux hourForFlux;
    

    @OneToMany(mappedBy = "dateHourForFlux", cascade = CascadeType.ALL) 
    private List<Affluence> affluence = new ArrayList<>();
}
