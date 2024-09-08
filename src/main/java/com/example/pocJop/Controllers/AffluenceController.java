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

import com.example.pocJop.Models.Affluence;
import com.example.pocJop.Services.AffluenceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/affluence")
@CrossOrigin(origins = "http://localhost:4200")
public class AffluenceController {

    private final AffluenceService affluenceService;


    @GetMapping("/get/all")
    public ResponseEntity<List<Affluence>> getAllAffluences() {
        return new ResponseEntity<>(affluenceService.getAllAffluences(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Affluence> getAffluenceById(@PathVariable Long id) {
        return new ResponseEntity<>(affluenceService.getAffluenceById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Affluence> create(@RequestBody Affluence affluence) {
        return new ResponseEntity<>(affluenceService.createAffluence(affluence), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        affluenceService.deleteAffluence(id);
        return new ResponseEntity<>("L'affluence avec l'Id n°" + id + " a été supprimée", HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Affluence> update(@PathVariable Long id, @RequestBody Affluence affluence) {
        return new ResponseEntity<>(affluenceService.updateAffluence(id, affluence), HttpStatus.OK);
    }
            
    
}
