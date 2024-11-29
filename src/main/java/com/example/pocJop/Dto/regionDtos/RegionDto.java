package com.example.pocJop.Dto.regionDtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RegionDto {
    private Long id;
    private String name;
    private int nbGares;
    private int nbLieux;
    
}
