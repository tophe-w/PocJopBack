package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Event;
import com.example.pocJop.Models.Gare;
import com.example.pocJop.Models.OlympicSite;
import com.example.pocJop.Models.Region;
import com.example.pocJop.Models.Site;
import com.example.pocJop.Repository.EventRepository;
import com.example.pocJop.Repository.GareRepository;
import com.example.pocJop.Repository.SiteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private GareRepository gareRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Site> getAllSitesEvents() {
        List<Site> sites = siteRepository.findAll();
        if (sites.isEmpty()) {
            throw new RuntimeException("There is no region");
        }
        return sites;
    }

    public Site getSiteById(Long id) {
        return siteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Site not found with id: " + id));
    }

    public Site createSite(Site site) {
        return siteRepository.save(site);
    }

    public Site addGareByIdToSite(Long siteId, List<Long> gareIds) {
        Site site = siteRepository.findById(siteId)
                .orElseThrow(
                        () -> new RuntimeException("Le site avec l'id n°" + siteId + "n'est pas trouvé"));
        List<Gare> gares = gareRepository.findByIdIn(gareIds);
        if (gares.isEmpty()) {
            throw new RuntimeException("Aucun site olympique trouvé avec les IDs fournis : " + gareIds);
        }
        site.getGares().addAll(gares);

        for (Gare gare : gares) {
            if (!gare.getSites().contains(site)) {
                gare.getSites().add(site);
            }
        }
        siteRepository.save(site);
        gareRepository.saveAll(gares);

        return site;
    }

    public Site addEventByIdToSite(Long siteId, Long eventId) {
        Site site = siteRepository.findById(siteId)
                .orElseThrow(
                        () -> new RuntimeException("Le site avec l'id n°" + siteId + " n'est pas trouvé"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("L'événement avec l'Id n°" + eventId + " n'est pas trouvé"));

        event.setSite(site);

        eventRepository.save(event);

        return site;
    }

    public void deleteSite(Long id) {
        siteRepository.deleteById(id);
    }

}
