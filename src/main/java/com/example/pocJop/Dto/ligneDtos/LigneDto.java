package com.example.pocJop.Dto.ligneDtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class LigneDto {
    private Long id;
    private String name;
    private String code;

}
