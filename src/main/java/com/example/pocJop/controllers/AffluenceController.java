package com.example.pocJop.controllers;

import java.util.List;

import com.example.pocJop.Dto.affluenceDtos.AffluenceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.pocJop.Models.Affluence;
import com.example.pocJop.Services.AffluenceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class AffluenceController {

    private final static String AFFLUENCE_BASE_PATH = "/affluence";
    private final static String ENDPOINT_AFFLUENCE_GET_ALL = AFFLUENCE_BASE_PATH + "/get/all";
    private final static String ENDPOINT_AFFLUENCE_GET_BY_ID = AFFLUENCE_BASE_PATH + "/get/{id}";
    private final static String ENDPOINT_AFFLUENCE_CREATE = AFFLUENCE_BASE_PATH + "/create";
    private final static String ENDPOINT_AFFLUENCE_UPDATE = AFFLUENCE_BASE_PATH + "/update/{id}";
    private final static String ENDPOINT_AFFLUENCE_DELETE = AFFLUENCE_BASE_PATH + "/delete/{id}";
    private final static String ENDPOINT_AFFLUENCE_FOR_GARE = AFFLUENCE_BASE_PATH + "/get/gare/{gareId}";
    private final static String ENDPOINT_AFFLUENCE_FOR_GARE_BETWEEN_DATE = AFFLUENCE_BASE_PATH + "/get/gare/{gareId}/{startDate}/{endDate}";
    private final static String ENDPOINT_AFFLUENCE_FOR_GARE_AT_DATE = AFFLUENCE_BASE_PATH + "/get/gare/{gareId}/{date}";

    private final static String RESSOURCE_DELETED_MSG = "L'affluence avec l'Id n° %s a été supprimée";

    private final AffluenceService affluenceService;


    @GetMapping(ENDPOINT_AFFLUENCE_GET_ALL)
    public ResponseEntity<List<Affluence>> getAll() {
        return new ResponseEntity<>(affluenceService.getAll(), HttpStatus.OK);
    }


    @GetMapping(ENDPOINT_AFFLUENCE_GET_BY_ID)
    public ResponseEntity<AffluenceDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(affluenceService.getById(id), HttpStatus.OK);
    }

    @PostMapping(ENDPOINT_AFFLUENCE_CREATE)
    public ResponseEntity<Affluence> create(@RequestBody AffluenceDto affluenceDto) {
        return new ResponseEntity<>(affluenceService.create(affluenceDto), HttpStatus.CREATED);
    }

    @DeleteMapping(ENDPOINT_AFFLUENCE_DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        affluenceService.deleteAffluence(id);
        return new ResponseEntity<>(String.format(RESSOURCE_DELETED_MSG, id), HttpStatus.OK);
    }

    @PostMapping(ENDPOINT_AFFLUENCE_UPDATE)
    public ResponseEntity<AffluenceDto> update(@PathVariable Long id, @RequestBody Affluence affluence) {
        return new ResponseEntity<>(affluenceService.update(id, affluence), HttpStatus.OK);
    }

    @GetMapping(ENDPOINT_AFFLUENCE_FOR_GARE)
    public ResponseEntity<List<AffluenceDto>> getAffluencesForGare(@PathVariable Long gareId) {
        return new ResponseEntity<>(affluenceService.getAffluencesForGare(gareId), HttpStatus.OK);
    }

    @GetMapping(ENDPOINT_AFFLUENCE_FOR_GARE_BETWEEN_DATE)
    public ResponseEntity<List<AffluenceDto>> getAffluencesForGareBetweenDates(@PathVariable Long gareId, @PathVariable String startDate, @PathVariable String endDate) {
        return new ResponseEntity<>(affluenceService.getGareAffluencesBetwenDates(gareId, startDate, endDate), HttpStatus.OK);
    }

    @GetMapping(ENDPOINT_AFFLUENCE_FOR_GARE_AT_DATE)
    public ResponseEntity<AffluenceDto> getAffluencesForGareAtDate(@PathVariable Long gareId, @PathVariable String date) {
        return new ResponseEntity<>(affluenceService.getGareAffluencesAtDate(gareId, date), HttpStatus.OK);
    }


}
