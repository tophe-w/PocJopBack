package com.example.pocJop.Services;

import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Category;
import com.example.pocJop.Models.Event;
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
                .orElseThrow(() -> new RuntimeException("There is no category"));
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event addCategoryByIdToEvent(Long eventId, Long categoryId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("L'événement avec l'Id n°" + eventId + " n'est pas trouvé"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(
                        () -> new RuntimeException("La catégorie avec l'Id n°" + categoryId + " n'est pas trouvée"));
        event.setCategory(category);
        return eventRepository.save(event);
    }


    public List<Object[]> getEventsCountByCategory(Long regionId, String searchDate) {
        // Formatter pour parser la date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        // Conversion de la chaîne en LocalDateTime
        LocalDateTime date = LocalDateTime.parse(searchDate, formatter);

        // Appel au repository avec un LocalDateTime
        return eventRepository.countEventsByCategoryInRegionAndDate(regionId, date);
    }

}