package com.example.pocJop.Dto.GareDtos;

import java.util.ArrayList;
import java.util.List;

import com.example.pocJop.Dto.AffluenceDtos.AffluenceDto;
import com.example.pocJop.Dto.LigneDto;
import com.example.pocJop.Dto.RegionDtos.RegionDto;
import com.example.pocJop.Dto.SiteDto;
import com.example.pocJop.Models.Affluence;
import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Models.Region;
import com.example.pocJop.Models.Site;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GareDTOb {
    private Long id;
    private String name;
    private String code;
    private String planDeGare;
    private String planDeGareSvg;
    private String accessibilite;

    private List<LigneDto> lignes = new ArrayList<>();
    private List<AffluenceDto> affluences = new ArrayList<>();
    private RegionDto region;
    private List<SiteDto> sites = new ArrayList<>();
}
