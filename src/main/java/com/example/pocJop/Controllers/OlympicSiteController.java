package com.example.pocJop.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocJop.Models.OlympicSite;
import com.example.pocJop.Services.OlympicSiteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/olympicSite")
@CrossOrigin(origins = "http://localhost:4200")
public class OlympicSiteController {

    private final OlympicSiteService olympicSiteService;

    @GetMapping("/get/all")
    public ResponseEntity<List<OlympicSite>> getAllOlympicSites() {
        return new ResponseEntity<>(olympicSiteService.getAllOlympicSites(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OlympicSite> getOlympicSiteById(@PathVariable Long id) {
        return new ResponseEntity<>(olympicSiteService.getOlympicSiteById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<OlympicSite> create(@RequestBody OlympicSite olympicSite) {
        return new ResponseEntity<>(olympicSiteService.createOlympicSite(olympicSite), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<OlympicSite> update(@PathVariable Long id, @RequestBody OlympicSite olympicSite) {
        return new ResponseEntity<>(olympicSiteService.updateOlympicSite(id, olympicSite), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        olympicSiteService.deleteOlympicSite(id);
        return new ResponseEntity<>("Le site olympique avec l'Id n°" + id + " a été supprimé", HttpStatus.OK);
    }
    
}
