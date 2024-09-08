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

import com.example.pocJop.Models.OlympicDiscipline;
import com.example.pocJop.Services.OlympicDisciplineService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/OlympicDiscipline")
@CrossOrigin(origins = "http://localhost:4200")
public class OlympicDisciplineController {

    private final OlympicDisciplineService olympicDisciplineService;


     @GetMapping("/get/all")
     public ResponseEntity<List<OlympicDiscipline>> getAllOlympicDisciplines() {
         return new ResponseEntity<>(olympicDisciplineService.getAllOlympicDisciplines(), HttpStatus.OK);
     }
        
        @GetMapping("/get/{id}")
        public ResponseEntity<OlympicDiscipline> getOlympicDisciplineById(@PathVariable Long id) {
            return new ResponseEntity<>(olympicDisciplineService.getOlympicDisciplineById(id), HttpStatus.OK);
        }

        @PostMapping("/create")
        public ResponseEntity<OlympicDiscipline> create(@RequestBody OlympicDiscipline olympicDiscipline) {
            return new ResponseEntity<>(olympicDisciplineService.createOlympicDiscipline(olympicDiscipline),
                    HttpStatus.CREATED);
        }
        
        @PostMapping("/update/{id}")
        public ResponseEntity<OlympicDiscipline> update(@PathVariable Long id,
                @RequestBody OlympicDiscipline olympicDiscipline) {
            return new ResponseEntity<>(olympicDisciplineService.updateOlympicDiscipline(id, olympicDiscipline),
                    HttpStatus.OK);
        }
        
        @GetMapping("/delete/{id}")
        public ResponseEntity<String> delete(@PathVariable Long id) {
            olympicDisciplineService.deleteOlympicDiscipline(id);
            return new ResponseEntity<>("La discipline olympique avec l'Id n°" + id + " a été supprimée", HttpStatus.OK);
        }
    
    
}
