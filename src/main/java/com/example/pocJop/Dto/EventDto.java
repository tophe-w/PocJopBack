package com.example.pocJop.Dto;
import java.time.LocalDateTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@RequiredArgsConstructor
@Getter
@Setter
public class EventDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startEvent;
    private LocalDateTime endEvent;
    private String description;
    private int nbPeopleExpected;

    public EventDto(Long id, String name, LocalDateTime startEvent, LocalDateTime endEvent, String description, int nbPeopleExpected) {
        this.id = id;
        this.name = name;
        this.startEvent = startEvent;
        this.endEvent = endEvent;
        this.description = description;
        this.nbPeopleExpected = nbPeopleExpected;
    }

}