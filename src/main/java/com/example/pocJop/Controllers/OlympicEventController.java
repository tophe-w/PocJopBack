// package com.example.pocJop.Controllers;

// import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.pocJop.Models.OlympicEvent;
// import com.example.pocJop.Services.OlympicEventService;

// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// @RestController
// @RequestMapping("/olympicEvent")
// @CrossOrigin(origins = "http://localhost:4200")
// public class OlympicEventController {

//     private final OlympicEventService olympicEventService;

//     @GetMapping("/get/all")
//     public ResponseEntity<List<OlympicEvent>> getAllOlympicEvents() {
//         return new ResponseEntity<>(olympicEventService.getAllOlympicEvents(), HttpStatus.OK);
//     }

//     @GetMapping("/get/{id}")
//     public ResponseEntity<OlympicEvent> getOlympicEventById(@PathVariable Long id) {
//         return new ResponseEntity<>(olympicEventService.getOlympicEventById(id), HttpStatus.OK);
//     }

//     @PostMapping("/create")
//     public ResponseEntity<OlympicEvent> create(@RequestBody OlympicEvent olympicEvent,
//             @RequestParam String disciplinesNames) {
//         return new ResponseEntity<>(olympicEventService.createOlympicEvent(olympicEvent, disciplinesNames),
//                 HttpStatus.CREATED);
//     }

//     // @PostMapping("/create/{siteId}/{olympicDisciplineId}")
//     // public ResponseEntity<OlympicEvent> create(@RequestBody OlympicEvent
//     // olympicEvent, @PathVariable Long siteId,
//     // @PathVariable Long olympicDisciplineId) {
//     // return new
//     // ResponseEntity<>(olympicEventService.createOlympicEvent(olympicEvent, siteId,
//     // olympicDisciplineId), HttpStatus.CREATED);
//     // }

//     @PostMapping("/update/{id}")
//     public ResponseEntity<OlympicEvent> update(@PathVariable Long id, @RequestBody OlympicEvent olympicEvent) {
//         return new ResponseEntity<>(olympicEventService.updateOlympicEvent(id, olympicEvent), HttpStatus.OK);
//     }

//     @GetMapping("/delete/{id}")
//     public ResponseEntity<String> delete(@PathVariable Long id) {
//         olympicEventService.deleteOlympicEvent(id);
//         return new ResponseEntity<>("L'événement olympique avec l'Id n°" + id + " a été supprimé", HttpStatus.OK);
//     }

// }
