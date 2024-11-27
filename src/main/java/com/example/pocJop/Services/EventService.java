package com.example.pocJop.Services;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Dto.SiteNameDto;
import com.example.pocJop.Dto.EventDtos.EventCategoryCountDto;
import com.example.pocJop.Dto.EventDtos.EventDto;
import com.example.pocJop.Dto.GareDtos.GareDto;
import com.example.pocJop.Models.Category;
import com.example.pocJop.Models.Event;
import com.example.pocJop.Models.Ligne;
import com.example.pocJop.Repository.CategoryRepository;
import com.example.pocJop.Repository.EventRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Event> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        if (events.isEmpty()) {
            throw new RuntimeException("There is no event");
        }
        return events;
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no event"));
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event addCategoryByIdToEvent(Long eventId, Long categoryId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("L'événement avec l'Id n°" + eventId + " n'est pas trouvé"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(
                        () -> new RuntimeException("L'événement avec l'Id n°" + categoryId + " n'est pas trouvée"));
        event.setCategory(category);
        return eventRepository.save(event);
    }


    
    public List<EventCategoryCountDto> getEventsCountByCategory(Long regionId, String searchDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(searchDate, formatter);

        // Récupérer la liste des événements par région et date
        List<Event> events = eventRepository.findEventsByRegionAndDate(regionId, date);

        // Grouper les événements par catégorie et compter
        Map<String, List<EventDto>> eventsByCategory = events.stream()
                .collect(Collectors.groupingBy(
                        event -> event.getCategory().getName(),
                        Collectors.mapping(event -> {
                            List<GareDto> gareDtos = event.getSite().getGares().stream()
                                    .map(gare -> new GareDto(gare.getId(), gare.getName(), gare.getLignes().stream()
                                            .map(Ligne::getName)
                                            .collect(Collectors.toList())))
                                    .collect(Collectors.toList());

                            SiteNameDto siteDto = new SiteNameDto(event.getSite().getId(), event.getSite().getName());

                            return new EventDto(
                                    event.getId(),
                                    event.getName(),
                                    event.getStartEvent(),
                                    event.getEndEvent(),
                                    event.getDescription(),
                                    event.getNbPeopleExpected(),
                                    gareDtos,
                                    siteDto);
                        }, Collectors.toList())));

        return eventsByCategory.entrySet().stream()
                .map(entry -> new EventCategoryCountDto(
                        entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue()))
                .collect(Collectors.toList());
    }

    public Event updateEvent(Long id, Event event) {
        Event majEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'événement avec l'Id n°" + id + " n'est pas trouvé"));
   
        if (event.getName() != null) {
            majEvent.setName(event.getName());
            System.out.println("Mise à jour de la date de début de l'événement : " + event.getStartEvent());
        }
        if (event.getStartEvent() != null) {
                majEvent.setStartEvent(event.getStartEvent());
                System.out.println("Mise à jour de la date de début de l'événement : " + event.getStartEvent());
            }
        if (event.getEndEvent() != null) {
            majEvent.setEndEvent(event.getEndEvent());
            System.out.println("Mise à jour de la date de fin de l'événement : " + event.getEndEvent());
        }
        if (event.getDescription() != null) {
            majEvent.setDescription(event.getDescription());
            System.out.println("Mise à jour de la description de l'événement : " + event.getDescription());
        }
        if (event.getNbPeopleExpected() > 0) {
            majEvent.setNbPeopleExpected(event.getNbPeopleExpected());
            System.out.println("Mise à jour du nombre de personnes attendues à l'événement : " + event.getNbPeopleExpected());
        }

       

        return eventRepository.save(majEvent);
    }
   



        public void deleteEvent(Long id) {
                eventRepository.deleteById(id);
        }



}
