package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pocJop.Models.Gare;
import com.example.pocJop.Models.OlympicDiscipline;
import com.example.pocJop.Models.OlympicEvent;
import com.example.pocJop.Models.OlympicSite;
import com.example.pocJop.Repository.GareRepository;
import com.example.pocJop.Repository.OlympicDisciplineRepository;
import com.example.pocJop.Repository.OlympicEventRepository;
import com.example.pocJop.Repository.OlympicSiteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OlympicEventService {


    @Autowired
    private OlympicEventRepository olympicEventRepository;

    @Autowired
    private GareRepository gareRepository;

    @Autowired
    private OlympicSiteRepository olympicSiteRepository;
  
    @Autowired
    private OlympicDisciplineRepository olympicDisciplineRepository;


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

    public OlympicEvent createOlympicEvent(OlympicEvent olympicEvent, String disciplinesNames) {
        
        OlympicDiscipline olympicDiscipline = olympicDisciplineRepository.findByName(disciplinesNames);
        if (olympicDiscipline == null) {
            throw new RuntimeException("Discipline olympique non trouvée avec le nom: " + disciplinesNames);
        }
        olympicEvent.setOlympicDiscipline(olympicDiscipline);
        
        return olympicEventRepository.save(olympicEvent);
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
