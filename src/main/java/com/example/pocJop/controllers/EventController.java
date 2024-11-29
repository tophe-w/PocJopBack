package com.example.pocJop.controllers;

import java.util.List;
import java.util.Optional;
import com.example.pocJop.Dto.eventDtos.EventDto;
import com.example.pocJop.exceptions.customException.ResourceNotFoundException;
import com.example.pocJop.helper.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pocJop.Models.Event;
import com.example.pocJop.Services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping; 



@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {

    private final static String EVENT_BASE_PATH = "/event";
    private final static String ENDPOINT_EVENT_GET_ALL = EVENT_BASE_PATH + "/get/all";
    private final static String ENDPOINT_EVENT_GET_BY_ID = EVENT_BASE_PATH + "/get/{id}";
    private final static String ENDPOINT_EVENT_CREATE = EVENT_BASE_PATH + "/create";
    private final static String ENDPOINT_EVENT_UPDATE = EVENT_BASE_PATH + "/update/{id}";
    private final static String ENDPOINT_EVENT_DELETE = EVENT_BASE_PATH + "/delete/{id}";

    private final EventService eventService;

    @Autowired
    private Messages msg;

    @GetMapping(ENDPOINT_EVENT_GET_ALL)
    public ResponseEntity<List<EventDto>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }
 
    @GetMapping(ENDPOINT_EVENT_GET_BY_ID)
    public ResponseEntity<EventDto> getEventById(@PathVariable Long id) {
        Optional<EventDto> eventDto= eventService.getById(id);
        return eventDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseThrow(() -> new ResourceNotFoundException(msg.getMessage("error_msg.event_not_found", Long.toString(id))));
    }
    @PostMapping(ENDPOINT_EVENT_CREATE)
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.CREATED);
    }

    @PostMapping(ENDPOINT_EVENT_UPDATE)
    public ResponseEntity<EventDto> update(@PathVariable Long id, @RequestBody Event event) {
        return new ResponseEntity<>(eventService.updateEvent(id, event), HttpStatus.OK);
    }

    @DeleteMapping(ENDPOINT_EVENT_DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(msg.getMessage("confirm_msg.delete.event", Long.toString(id)), HttpStatus.OK);
    }
}
