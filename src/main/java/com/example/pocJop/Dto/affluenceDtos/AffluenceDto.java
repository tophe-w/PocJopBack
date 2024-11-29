package com.example.pocJop.Dto.affluenceDtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AffluenceDto {
    private Long id;
    private int estimationUp;
    private int estimationDown;
    private int affluenceHabituelleUp;
    private int affluenceHabituelleDown;
}
