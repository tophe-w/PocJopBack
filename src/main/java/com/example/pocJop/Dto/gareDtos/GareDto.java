package com.example.pocJop.Dto.gareDtos;

import java.util.List;

import com.example.pocJop.Dto.affluenceDtos.AffluenceDto;
import com.example.pocJop.Dto.ligneDtos.LigneDto;

import com.example.pocJop.Dto.regionDtos.RegionDto;
import com.example.pocJop.Dto.siteDtos.SiteDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
//@RequiredArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class GareDto {

    private Long id;
    private String name;
    private List<LigneDto> lignes;
    private String code;
    private String planDeGare;
    private String planDeGareSvg;
    private String accessibilite;

    private List<AffluenceDto> affluences;
    private RegionDto region;
    private List<SiteDto> sites;

}