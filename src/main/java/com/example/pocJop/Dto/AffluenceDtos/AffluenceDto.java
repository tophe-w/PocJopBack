package com.example.pocJop.Dto.AffluenceDtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AffluenceDto {
    private Long id;
    private int estimationUp;
    private int estimationDown;
    private int affluenceHabituelleUp;
    private int affluenceHabituelleDown;
}
