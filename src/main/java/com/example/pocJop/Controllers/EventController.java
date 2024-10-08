package com.example.pocJop.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.pocJop.Models.Event;
import com.example.pocJop.Repository.EventRepository;
import com.example.pocJop.Services.EventService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {

    private final EventService eventService;
    private final EventRepository eventRepository;

    @GetMapping("/get/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return new ResponseEntity<>(eventService.getEventById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.CREATED);
    }
    

    @GetMapping("/countByCategory")
    public List<Object[]> getEventsCountByCategory(Long regionId, String searchDate) {
        // Formatter pour parser la chaîne de date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        // Conversion de la chaîne en LocalDateTime
        LocalDateTime date = LocalDateTime.parse(searchDate, formatter);

        // Appel à la méthode du repository avec un LocalDateTime
        return eventRepository.countEventsByCategoryInRegionAndDate(regionId, date);
    }

}
