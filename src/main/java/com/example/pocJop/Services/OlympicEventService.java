package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.OlympicEvent;
import com.example.pocJop.Repository.OlympicEventRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OlympicEventService {


    @Autowired
    private OlympicEventRepository olympicEventRepository;


    public List<OlympicEvent> getAllOlympicEvents() {
        List<OlympicEvent> olympicEvents = olympicEventRepository.findAll();
        if (olympicEvents.isEmpty()) {
            throw new RuntimeException("There is no olympicEvent");
        }
        return olympicEvents;
    }

    public OlympicEvent getOlympicEventById(Long id) {
        return olympicEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'événement olympique avec l'Id n°" + id + " is not found"));
    }

    public OlympicEvent createOlympicEvent(OlympicEvent olympicEvent) {
        return olympicEventRepository.save(olympicEvent);
    }

    public OlympicEvent updateOlympicEvent(Long id, OlympicEvent olympicEvent) {

        System.out.println("Tentative de mise à jour de l'événement olympique avec l'ID : " + id);

        OlympicEvent majOlympicEvent = olympicEventRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("L'événement olympique avec l'Id n°" + id + " n'est pas trouvée"));

        if (olympicEvent.getStart() != null) {
   
            majOlympicEvent.setStart(olympicEvent.getStart());
            System.out.println("Mise à jour du nom de l'événement olympique : " + olympicEvent.getStart());
        }
        if (olympicEvent.getEnd() != null) {
            majOlympicEvent.setEnd(olympicEvent.getEnd());
            System.out.println("Mise à jour du code de l'événement olympique : " + olympicEvent.getEnd());
        }
        majOlympicEvent.setEventStart(olympicEvent.isEventStart()); 
        System.out.println("Mise à jour de l'état isEventStart : " + olympicEvent.isEventStart());

        return olympicEventRepository.save(majOlympicEvent);

    }

    public void deleteOlympicEvent(Long id) {
        olympicEventRepository.deleteById(id);
    }
    
    
}
