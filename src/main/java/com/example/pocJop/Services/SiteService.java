package com.example.pocJop.Services;

import java.util.List;
import java.util.Optional;

import com.example.pocJop.Dto.siteDtos.SiteDtoMapper;
import com.example.pocJop.helper.Helpers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocJop.Dto.siteDtos.SiteDto;
import com.example.pocJop.Models.Site;
import com.example.pocJop.Repository.SiteRepository;

import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SiteDtoMapper siteDtoMapper;

    public List<SiteDto> getAllSitesEvents() {
        List<Site> sites = siteRepository.findAll();
        if (sites.isEmpty()) {
            throw new RuntimeException("There ara no sites");
        }
        return sites.stream().map(siteDtoMapper::from).toList();
    }

    public Optional<SiteDto> getSiteById(Long id) {

        return siteRepository.findById(id)
                .map(this.siteDtoMapper::from);
    }

    public Site createSite(Site site) {
        return siteRepository.save(site);
    }

    public Site updateSite(Long id, Site site) {
        Site siteToUpdate = siteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le site avec l'Id n°" + id + " n'est pas trouvé"));

        Helpers.UpdateObjectFields(site, siteToUpdate);

        return siteRepository.save(siteToUpdate);
    }

    public void deleteSite(Long id) {
        siteRepository.deleteById(id);
    }
}
