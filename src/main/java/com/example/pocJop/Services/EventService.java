package com.example.pocJop.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.pocJop.Dto.eventDtos.EventDtoMapper;
import com.example.pocJop.Models.Gare;
import com.example.pocJop.Repository.GareRepository;
import com.example.pocJop.helper.Helpers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.pocJop.Dto.eventDtos.EventDto;
import com.example.pocJop.Models.Event;
import com.example.pocJop.Repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    private final GareRepository gareRepository;

    private final EventDtoMapper eventDtoMapper;

    public List<EventDto> getAllEvents() {
        List<EventDto> events = eventRepository.findAll().stream().map(this.eventDtoMapper::from).collect(Collectors.toList());
        if (events.isEmpty()) {
            throw new RuntimeException("There is no event");
        }
        return events;
    }

    public List<EventDto> getAllEventsForGare(Long gareId) {

        Gare gare = gareRepository.findById(gareId).orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + gareId + " n'est pas trouvée"));

        return gare.getSites().stream().flatMap(site -> site.getEvents().stream()).map(this.eventDtoMapper::from).toList();
    }

    public Optional<EventDto> getById(Long id) {
        return eventRepository.findById(id).map(this.eventDtoMapper::from);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }


    public EventDto updateEvent(Long id, Event event) {
        Event eventToUpdate = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'événement avec l'Id n°" + id + " n'est pas trouvé"));

        Helpers.UpdateObjectFields(event, eventToUpdate);
        eventRepository.save(eventToUpdate);
        return eventDtoMapper.from(eventToUpdate);
    }


        public void deleteEvent(Long id) {
                eventRepository.deleteById(id);
        }

}
