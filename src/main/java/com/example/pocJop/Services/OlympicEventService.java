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

    



    
// public OlympicEvent createOlympicEvent(OlympicEvent olympicEvent, Long siteId,Long olympicDisciplineId) {
//     // Trouver le site associé à l'ID donné
//     OlympicSite olympicSite = olympicSiteRepository.findById(siteId)
//             .orElseThrow(() -> new RuntimeException("Site olympique non trouvé avec l'ID: " + siteId));
    
//     // Associer le site à l'événement
//     olympicEvent.setOlympicSite(olympicSite);

//     // Trouver la discipline olympique associée à l'ID donné
//     OlympicDiscipline olympicDiscipline = olympicDisciplineRepository.findById(olympicDisciplineId)
//             .orElseThrow(
//                     () -> new RuntimeException("Discipline olympique non trouvée avec l'ID: " + olympicDisciplineId));
//    olympicEvent.setOlympicDiscipline(olympicDiscipline);         
    
//     // Sauvegarder l'événement avec le site associé
//     return olympicEventRepository.save(olympicEvent);
// }


    public OlympicEvent updateOlympicEvent(Long id, OlympicEvent olympicEvent) {
        System.out.println("Tentative de mise à jour de l'événement olympique avec l'ID : " + id);
        OlympicEvent majOlympicEvent = olympicEventRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("L'événement olympique avec l'Id n°" + id + " n'est pas trouvée"));
        if (olympicEvent.getStartEvent() != null) {
            majOlympicEvent.setStartEvent(olympicEvent.getStartEvent());
            System.out.println("Mise à jour du nom de l'événement olympique : " + olympicEvent.getStartEvent());
        }
        if (olympicEvent.getEndEvent() != null) {
            majOlympicEvent.setEndEvent(olympicEvent.getEndEvent());
            System.out.println("Mise à jour du code de l'événement olympique : " + olympicEvent.getEndEvent());
        }
        majOlympicEvent.setIsEventStart(olympicEvent.getIsEventStart());
        System.out.println("Mise à jour de l'état isEventStart : " + olympicEvent.getIsEventStart());
        return olympicEventRepository.save(majOlympicEvent);
    }

   

    public void deleteOlympicEvent(Long id) {
        olympicEventRepository.deleteById(id);
    }
    
    
}
