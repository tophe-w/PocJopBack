package com.example.pocJop.controllers;

import java.util.List;
import java.util.Optional;

import com.example.pocJop.Models.Gare;
import com.example.pocJop.exceptions.customException.ResourceNotFoundException;
import com.example.pocJop.helper.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pocJop.Dto.siteDtos.SiteDto;
import com.example.pocJop.Models.Site;
import com.example.pocJop.Services.SiteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class SiteController {

    private final static String SITE_BASE_PATH = "/site";
    private final static String ENDPOINT_SITE_GET_ALL = SITE_BASE_PATH + "/get/all";
    private final static String ENDPOINT_SITE_GET_BY_ID = SITE_BASE_PATH + "/get/{id}";
    private final static String ENDPOINT_SITE_CREATE = SITE_BASE_PATH + "/create";
    private final static String ENDPOINT_SITE_UPDATE = SITE_BASE_PATH + "/update/{id}";
    private final static String ENDPOINT_SITE_DELETE = SITE_BASE_PATH + "/delete/{id}";

    private final SiteService siteService;

    @Autowired
    private Messages msg;

    @GetMapping(ENDPOINT_SITE_GET_ALL)
    public ResponseEntity<List<SiteDto>> getAllSitesEvents() {
        return new ResponseEntity<>(siteService.getAllSitesEvents(), HttpStatus.OK);
    }

    @GetMapping(ENDPOINT_SITE_GET_BY_ID)
    public ResponseEntity<SiteDto> getSiteById(@PathVariable Long id) {
        Optional<SiteDto> siteDto = siteService.getSiteById(id);
        return siteDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseThrow(() -> new ResourceNotFoundException(msg.getMessage("error_msg.site_not_found", Long.toString(id))));
    }

    @PostMapping(path=ENDPOINT_SITE_CREATE, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Site> create(@RequestPart("site") SiteDto siteDto,
                                       @RequestPart("photo") List<MultipartFile> photo,
                                       @RequestPart("plan") MultipartFile plan) {
        Site site = Site.builder()
                .name(siteDto.getName())
                .description(siteDto.getDescription())
                .town(siteDto.getTown())
                .capacity(siteDto.getCapacity())
                .address(siteDto.getAddress())
                .photo("photo")
                .planDeSite("plan")
                .gares(siteDto.getGares() != null ? siteDto.getGares().stream().map(gareDto -> Gare.builder()
                        .id(gareDto.getId())
                        .build()).toList(): null)

                .build();
        return new ResponseEntity<>(siteService.createSite(site, photo, plan), HttpStatus.CREATED);
    }

    @PostMapping(ENDPOINT_SITE_UPDATE)
    public ResponseEntity<Site> update(@PathVariable Long id, @RequestBody Site site) {
        return new ResponseEntity<>(siteService.updateSite(id, site), HttpStatus.OK);
    }

    @DeleteMapping(ENDPOINT_SITE_DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        siteService.deleteSite(id);
        return new ResponseEntity<>(msg.getMessage("confirm_msg.delete.site", Long.toString(id)), HttpStatus.OK);
    }

}
