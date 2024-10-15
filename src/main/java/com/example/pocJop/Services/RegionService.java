package com.example.pocJop.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Dto.GareDtos.GareDtoListNameAndSites;
import com.example.pocJop.Dto.RegionDtos.RegionDtoPagePrincipale;
import com.example.pocJop.Dto.RegionDtos.RegionWithGareAndSites;
import com.example.pocJop.Models.Gare;
import com.example.pocJop.Models.Region;
import com.example.pocJop.Repository.RegionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        List<Region> regions = regionRepository.findAll();
        if (regions.isEmpty()) {
            throw new RuntimeException("There is no region");
        }
        return regions;
    }

    public List<RegionDtoPagePrincipale> getAllRegionsDtos() {
        List<Region> regions = regionRepository.findAll();
        List<RegionDtoPagePrincipale> regionsDto = new ArrayList<>();
        if (regions.isEmpty()) {
            throw new RuntimeException("There is no region");
        }
        for (Region region : regions) {
            RegionDtoPagePrincipale regionDto = new RegionDtoPagePrincipale();
            regionDto.setId(region.getId());
            regionDto.setName(region.getName());
            List<Gare> gares = region.getGares();
            regionDto.setNbGares(gares.size());
            int totalLieux = 0;

            for (Gare gare : gares) {
                totalLieux += gare.getSites().size();
            }

            regionDto.setNbLieux(totalLieux);
            regionsDto.add(regionDto);

        }

        return regionsDto;
    }

    public Region getRegionById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Region not found with id: " + id));
    }

    public RegionWithGareAndSites getRegionByIdGaresListAndNbLieux(Long regionId) {
            Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("Region not found with id: " + regionId));

      
            RegionWithGareAndSites regionDto = new RegionWithGareAndSites();
        regionDto.setId(region.getId());
        regionDto.setName(region.getName());
        List<GareDtoListNameAndSites> gareDtos = region.getGares().stream()
                .map(gare -> {
                    GareDtoListNameAndSites gareDto = new GareDtoListNameAndSites();
                    gareDto.setId(gare.getId());
                    gareDto.setName(gare.getName());
                    gareDto.setSiteName(gare.getSites().stream().map(site -> site.getName()).collect(Collectors.toList()));   
                    gareDto.setSiteId(gare.getSites().stream().map(site -> site.getId()).collect(Collectors.toList()));
                    gareDto.setSiteTown(gare.getSites().stream().map(site -> site.getTown()).collect(Collectors.toList()));
                    gareDto.setNbSites(gare.getSites().size()); 
                    return gareDto;
                })
                .collect(Collectors.toList()); 
        regionDto.setGares(gareDtos);

        return regionDto;
    }


    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }

}
