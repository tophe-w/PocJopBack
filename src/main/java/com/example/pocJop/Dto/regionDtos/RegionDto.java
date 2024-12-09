package com.example.pocJop.Dto.regionDtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class RegionDto {
    private Long id;
    private String name;
    private int nbGares;
    private int nbLieux;
    
}
