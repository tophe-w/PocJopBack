package com.example.pocJop.controllers;

import java.util.List;
import java.util.Optional;

import com.example.pocJop.Dto.gareDtos.GareDto;
import com.example.pocJop.Dto.ligneDtos.LigneDto;
import com.example.pocJop.Dto.regionDtos.RegionDto;
import com.example.pocJop.Dto.siteDtos.SiteDto;
import com.example.pocJop.Models.*;
import com.example.pocJop.Services.*;
import com.example.pocJop.exceptions.customException.ResourceNotFoundException;
import com.example.pocJop.helper.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class GareController {

    private final static String GARE_BASE_PATH = "/gare";
    private final static String ENDPOINT_GARE_GET_ALL = GARE_BASE_PATH + "/get/all";
    private final static String ENDPOINT_GARE_GET_BY_ID = GARE_BASE_PATH + "/get/{id}";
    private final static String ENDPOINT_GARE_CREATE = GARE_BASE_PATH + "/create";
    private final static String ENDPOINT_GARE_UPDATE = GARE_BASE_PATH + "/update/{id}";
    private final static String ENDPOINT_GARE_DELETE = GARE_BASE_PATH + "/delete/{id}";

    private final GareService gareService;

    private final LigneService ligneService;

    private final RegionService regionService;

    private final SiteService siteService;


    @Autowired
    private Messages msg;

    @GetMapping(ENDPOINT_GARE_GET_ALL)
    public ResponseEntity<List<GareDto>> getAll() {
        return new ResponseEntity<>(gareService.getAllGares(), HttpStatus.OK);
    }

    @GetMapping(ENDPOINT_GARE_GET_BY_ID)
    public ResponseEntity<GareDto> getById(@PathVariable Long id) {
        Optional<GareDto> gareDto = gareService.getGareById(id);
        return gareDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseThrow(() -> new ResourceNotFoundException(msg.getMessage("error_msg.gare_not_found", Long.toString(id))));
    }
    
    @PostMapping(path = ENDPOINT_GARE_CREATE, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<GareDto> create(@RequestPart("gare") GareDto gareDto, @RequestPart("file") MultipartFile file) {

        List<Ligne> listLignes = gareDto.getLignes() != null ?gareDto.getLignes().stream().map(ligneDto -> {
            LigneDto ligne = ligneService.getById(ligneDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            msg.getMessage("error_msg.ligne_not_found", Long.toString(ligneDto.getId()))));
            return Ligne.builder()
                    .id(ligne.getId())
                    .name(ligne.getName())
                    .code(ligne.getCode())
                    .build();
        }).toList() : null;
        RegionDto regiondto = regionService.getRegionById(gareDto.getRegion().getId());
        List<Site> listSites = gareDto.getSites() != null ? gareDto.getSites().stream().map(siteDto -> {
            SiteDto site = siteService.getSiteById(siteDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            msg.getMessage("error_msg.site_not_found", Long.toString(siteDto.getId()))));
            return Site.builder()
                    .id(site.getId())
                    .name(site.getName())
                    .town(site.getTown())
                    .description(site.getDescription())
                    .capacity(site.getCapacity())
                    .photo(site.getPhoto())
                    .planDeSite(site.getPlanDeSite())
                    .address(site.getAddress())
                    .build();
        }).toList() : null;

        System.out.println("gareDto: " + gareDto.getName());
        Gare gare = Gare.builder()
                .code(gareDto.getCode())
                .name(gareDto.getName())
                .planDeGare(gareDto.getPlanDeGare())
                .planDeGareSvg(gareDto.getPlanDeGareSvg())
                .accessibilite(gareDto.getAccessibilite())
                .region(Region.builder()
                        .id(regiondto.getId())
                        .name(regiondto.getName())
                        .build())
                .sites(listSites)
                .lignes(listLignes)
                .build();
        return new ResponseEntity<>(gareService.createGare(gare, file), HttpStatus.CREATED);
    }

    @PatchMapping(ENDPOINT_GARE_UPDATE)
    public ResponseEntity<GareDto> update(@PathVariable Long id, @RequestBody Gare gare) {
        return new ResponseEntity<>(gareService.updateGare(id, gare), HttpStatus.OK);
    }

    @DeleteMapping(ENDPOINT_GARE_DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        gareService.deleteGare(id);
        return new ResponseEntity<>("La gare avec l'Id n°" + id + " a été supprimée", HttpStatus.OK);
    }

}
