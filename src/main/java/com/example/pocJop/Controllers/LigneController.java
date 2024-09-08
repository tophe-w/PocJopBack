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

import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Services.LigneService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ligne")
@CrossOrigin(origins = "http://localhost:4200")
public class LigneController {

    private final LigneService ligneService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Ligne>> getAllLignes() {
        return new ResponseEntity<>(ligneService.getAllLignes(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Ligne> getLigneById(@PathVariable Long id) {
        return new ResponseEntity<>(ligneService.getLigneById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Ligne> create(@RequestBody Ligne ligne) {
        return new ResponseEntity<>(ligneService.createLigne(ligne), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Ligne> update(@PathVariable Long id, @RequestBody Ligne ligne) {
        return new ResponseEntity<>(ligneService.updateLigne(id, ligne), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ligneService.deleteLigne(id);
        return new ResponseEntity<>("La ligne avec l'Id n°" + id + " a été supprimée", HttpStatus.OK);
    }
    
}
