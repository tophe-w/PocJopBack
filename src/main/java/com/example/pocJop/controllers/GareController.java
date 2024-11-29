package com.example.pocJop.controllers;

import java.util.List;
import java.util.Optional;
import com.example.pocJop.Dto.gareDtos.GareDto;
import com.example.pocJop.exceptions.customException.ResourceNotFoundException;
import com.example.pocJop.helper.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pocJop.Models.Gare;
import com.example.pocJop.Services.GareService;
import lombok.RequiredArgsConstructor;

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
    
    @PostMapping(ENDPOINT_GARE_CREATE)
    public ResponseEntity<Gare> create(@RequestBody Gare gare) {
        return new ResponseEntity<>(gareService.createGare(gare), HttpStatus.CREATED);
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
