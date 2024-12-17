package com.example.pocJop.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Affluence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int estimationUp;
    private int estimationDown;
    private int affluenceHabituelleUp;
    private int affluenceHabituelleDown;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Gare gare;

    @ManyToOne(fetch = FetchType.LAZY)
    private DateCalendar dateCalendar;

}

