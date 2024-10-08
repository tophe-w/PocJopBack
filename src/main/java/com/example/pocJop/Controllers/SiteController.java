package com.example.pocJop.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocJop.Dto.SiteDto;
import com.example.pocJop.Models.Site;
import com.example.pocJop.Services.SiteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/site")
@CrossOrigin(origins = "http://localhost:4200")
public class SiteController {

    private final SiteService siteService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Site>> getAllSitesEvents() {
        return new ResponseEntity<>(siteService.getAllSitesEvents(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Site> getSiteById(@PathVariable Long id) {
        return new ResponseEntity<>(siteService.getSiteById(id), HttpStatus.OK);
    }
    @GetMapping("/get/siteDto/{id}")
    public ResponseEntity<SiteDto> getSiteDtoById(@PathVariable Long id) {
        return new ResponseEntity<>(siteService.getSiteDtoById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Site> create(@RequestBody Site site) {
        return new ResponseEntity<>(siteService.createSite(site), HttpStatus.CREATED);
    }

    @PostMapping("/{siteId}/gares")
    public Site addGareByIdToSite(@PathVariable Long siteId, @RequestBody List<Long> garesIds) {
        return siteService.addGareByIdToSite(siteId, garesIds);
    }

    @PostMapping("/{siteId}/event/{eventId}")
    public Site addEventByIdToSite(@PathVariable Long siteId, @PathVariable Long eventId) {
        return siteService.addEventByIdToSite(siteId, eventId);
    }

}
