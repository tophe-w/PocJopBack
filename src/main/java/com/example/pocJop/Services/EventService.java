package com.example.pocJop.Services;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Dto.EventCategoryCountDto;
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


    public List<EventCategoryCountDto> getEventsCountByCategory(Long regionId, String searchDate) {
        // Formatter pour parser la date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(searchDate, formatter);

        // Récupérer la liste brute Object[] depuis le repository
        List<Object[]> rawResults = eventRepository.countEventsByCategoryInRegionAndDate(regionId, date);

        // Mapper chaque Object[] en un objet EventCategoryCountDto
        return rawResults.stream()
                .map(result -> new EventCategoryCountDto(
                        (String) result[0],  // Le premier élément est la catégorie (String)
                        ((Number) result[1]).intValue()  // Le deuxième élément est le nombre d'événements (int)
                ))
                .collect(Collectors.toList());
    }
}
    

