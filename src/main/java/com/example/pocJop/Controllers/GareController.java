package com.example.pocJop.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocJop.Models.Gare;
import com.example.pocJop.Services.GareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/gare")
@CrossOrigin(origins = "http://localhost:4200")

public class GareController {

    private final GareService gareService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Gare>> getAllGares() {
        return new ResponseEntity<>(gareService.getAllGares(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Gare> getGareById(@PathVariable Long id) {
        return new ResponseEntity<>(gareService.getGareById(id), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<Gare> create(@RequestBody Gare gare) {
        return new ResponseEntity<>(gareService.createGare(gare), HttpStatus.CREATED);
    }
    
    @PostMapping("/{gareId}/lignes")
    public Gare addLignesByNameToGare(@PathVariable Long gareId, @RequestBody List<String> ligneNames) {
        return gareService.addLignesByNameToGare(gareId, ligneNames);
    }

    @PostMapping("/{gareId}/olympicSites")
    public Gare addOlympicSitesByNameToGare(@PathVariable Long gareId, @RequestBody List<String> olympicSiteCodes) {
        return gareService.addOlympicSitesByNameToGare(gareId, olympicSiteCodes);
    }

    @PostMapping("/{gareId}/olympicEvents")
      public Gare addOlympicEventsByNameToGare(@PathVariable Long gareId, @RequestBody List<String> olympicEventIds) {
          return gareService.addOlympicEventsByNameToGare(gareId, olympicEventIds);
      }

    @PostMapping("/update/{id}")
    public ResponseEntity<Gare> update(@PathVariable Long id, @RequestBody Gare gare) {
        return new ResponseEntity<>(gareService.updateGare(id, gare), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        gareService.deleteGare(id);
        return new ResponseEntity<>("La gare avec l'Id n°" + id + " a été supprimée", HttpStatus.OK);
    }

}
