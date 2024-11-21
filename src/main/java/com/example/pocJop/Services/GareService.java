package com.example.pocJop.Services;

import java.util.ArrayList;


import java.util.List;

import com.example.pocJop.Dto.AffluenceDtos.AffluenceDto;
import com.example.pocJop.Dto.GareDtos.GareDTOb;
import com.example.pocJop.Dto.GareDtos.GareDto;
import com.example.pocJop.Dto.LigneDto;
import com.example.pocJop.Dto.RegionDtos.RegionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import com.example.pocJop.Dto.SiteDto;
import com.example.pocJop.Dto.GareDtos.GareDtoPagePrincipale;
import com.example.pocJop.Dto.GareDtos.GareDtoSelectedGare;
import com.example.pocJop.Models.Gare;
import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Models.Region;
import com.example.pocJop.Repository.AffluenceRepository;
import com.example.pocJop.Repository.GareRepository;
import com.example.pocJop.Repository.LigneRepository;
import com.example.pocJop.Repository.RegionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GareService {

    @Autowired
    private GareRepository gareRepository;

    @Autowired
    private LigneRepository ligneRepository;


    @Autowired
    private AffluenceRepository affluenceRepository;

    @Autowired
    private RegionRepository regionRepository;

    public List<Gare> getAllGares() {
        List<Gare> gares = gareRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        if (gares.isEmpty()) {
            throw new RuntimeException("There is no gare");
        }
        return gares;
    }

    public List<GareDtoPagePrincipale> getAllGaresDtos() {
        List<Gare> gares = gareRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        List<GareDtoPagePrincipale> gareDtos = new ArrayList<>();
        for (Gare gare : gares) {
            GareDtoPagePrincipale gareDto = new GareDtoPagePrincipale();
            gareDto.setId(gare.getId());
            gareDto.setName(gare.getName());
            gareDto.setCode(gare.getCode());
            if (gare.getRegion() != null) {
                gareDto.setRegion(gare.getRegion().getName());
            }
            gareDto.setNbLieux(gare.getSites().size());
            gareDtos.add(gareDto);
        }
        return gareDtos;
    }

    public GareDTOb getGareById(Long id) {
        //Gare gare =  gareRepository.findById(id)
        //      .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + id + " is not found"));
        Optional<Gare> gareTmp = gareRepository.findById(id);
        GareDTOb gareDto = new GareDTOb();

        if(gareTmp.isPresent()) {
            Gare gareFound =  gareTmp.get();

            List<LigneDto> lignesDto = gareFound.getLignes().stream()
                    .map(ligne -> {
                        LigneDto ligneDto = new LigneDto();
                        ligneDto.setId(ligne.getId());
                        ligneDto.setName(ligne.getName());
                        return ligneDto;
                    })
                    .toList();

            List<AffluenceDto> affluences = gareFound.getAffluences().stream()
                    .map(affluence -> {
                        AffluenceDto affluenceDto = new AffluenceDto();
                        affluenceDto.setId(affluence.getId());;
                        affluenceDto.setEstimationUp(affluence.getEstimationUp());
                        affluenceDto.setEstimationDown(affluence.getEstimationDown());
                        affluenceDto.setAffluenceHabituelleUp(affluence.getAffluenceHabituelleUp());
                        affluenceDto.setAffluenceHabituelleDown(affluence.getAffluenceHabituelleDown());
                        return affluenceDto;
                    })
                    .toList();

            RegionDto region = new RegionDto();
            region.setId(gareFound.getRegion().getId());
            region.setName(gareFound.getRegion().getName());


            List<SiteDto> sites = gareFound.getSites().stream()
                    .map(site -> {
                        SiteDto siteDto = new SiteDto();
                        siteDto.setId(site.getId());
                        siteDto.setName(site.getName());
                        siteDto.setDescription(site.getDescription());
                        siteDto.setTown(site.getTown());
                        siteDto.setCapacity(site.getCapacity());
                        siteDto.setPhoto(site.getPhoto());
                        return siteDto;
                    })
                    .toList();


            gareDto.setId(gareFound.getId());
            gareDto.setPlanDeGare(gareFound.getPlanDeGare());
            gareDto.setPlanDeGareSvg(gareFound.getPlanDeGareSvg());
            gareDto.setAccessibilite(gareFound.getAccessibilite());
            gareDto.setCode(gareFound.getCode());
            gareDto.setName(gareFound.getName());


            gareDto.setLignes(lignesDto);
            gareDto.setAffluences(affluences);
            gareDto.setRegion(region);
            gareDto.setSites(sites);
        }

        return gareDto;
    }

    public GareDtoSelectedGare getSelectedGareById(Long id) {
        Gare gare = gareRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + id + " is not found"));
        GareDtoSelectedGare gareDto = new GareDtoSelectedGare();
        gareDto.setId(gare.getId());
        gareDto.setName(gare.getName());
        gareDto.setPlanDeGare(gare.getPlanDeGare());
        gareDto.setPlanDeGareSvg(gare.getPlanDeGareSvg());
       List<SiteDto> siteDtos = gare.getSites().stream()
                .map(site -> {
                    SiteDto siteDto = new SiteDto();
                    siteDto.setId(site.getId());
                    siteDto.setName(site.getName());
                    siteDto.setDescription(site.getDescription());
                    siteDto.setTown(site.getTown());
                    siteDto.setCapacity(site.getCapacity());
                    siteDto.setPhoto(site.getPhoto());
                    return siteDto;
                })
                .collect(Collectors.toList());

        gareDto.setSites(siteDtos);
        return gareDto;
    }
            

    public Gare createGare(Gare gare) {
        return gareRepository.save(gare);
    }

    public Gare addLignesByNameToGare(Long gareId, List<String> ligneNames) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));
        List<Ligne> lignes = ligneRepository.findByNameIn(ligneNames);
        if (lignes.isEmpty()) {
            throw new RuntimeException("Aucune ligne trouvée avec les noms fournis : " + ligneNames);
        }
        gare.getLignes().addAll(lignes);
        for (Ligne ligne : lignes) {
            if (!ligne.getGares().contains(gare)) {
                ligne.getGares().add(gare);
            }
        }
        gareRepository.save(gare);
        ligneRepository.saveAll(lignes);
        return gare;
    }


   
    

    public Gare updateGare(Long id, Gare gare) {
        System.out.println("Tentative de mise à jour de la gare avec l'ID : " + id);
        Gare majGare = gareRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + id + " n'est pas trouvée"));

        if (gare.getName() != null) {
            majGare.setName(gare.getName());
            System.out.println("Mise à jour du nom de la gare : " + gare.getName());
        }
        if (gare.getCode() != null) {
            majGare.setCode(gare.getCode());
            System.out.println("Mise à jour du code de la gare : " + gare.getCode());
        }
        if (gare.getPlanDeGare() != null) {
            majGare.setPlanDeGare(gare.getPlanDeGare());
            System.out.println("Mise à jour du plan de gare");
        }
        if (gare.getPlanDeGareSvg() != null) {
            majGare.setPlanDeGareSvg(gare.getPlanDeGareSvg());
            System.out.println("Mise à jour du plan SVG de gare");
        }
        if (gare.getAccessibilite() != null) {
            majGare.setAccessibilite(gare.getAccessibilite());
            System.out.println("Mise à jour de l'accessibilité : " + gare.getAccessibilite());
        }
        if (gare.getLignes() != null) {
            majGare.getLignes().clear();
            for (Ligne ligne : gare.getLignes()) {

                Ligne lignePersisted = ligneRepository.findById(ligne.getId())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Ligne avec l'Id n°" + ligne.getId() + " n'est pas trouvée"));
                majGare.getLignes().add(lignePersisted);
                // Mettre à jour l'association bidirectionnelle
                if (!lignePersisted.getGares().contains(majGare)) {
                    lignePersisted.getGares().add(majGare);
                }
            }
            System.out.println("Mise à jour des lignes associées à la gare");
        }

        majGare = gareRepository.save(majGare);
        System.out.println("Gare mise à jour et sauvegardée.");
        return majGare;
    }

    public void deleteGare(Long id) {
        gareRepository.deleteById(id);
    }

    public Gare addRegionByIdToGare(Long gareId, Long regionId) {
        Gare gare = gareRepository.findById(gareId)
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("La région avec l'Id n°" + regionId + " n'est pas trouvée"));
        gare.setRegion(region);
        region.getGares().add(gare);
        gareRepository.save(gare);
        regionRepository.save(region);
        return gare;
    }

}