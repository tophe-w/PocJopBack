package com.example.pocJop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocJop.Models.OlympicSite;

public interface OlympicSiteRepository extends JpaRepository<OlympicSite, Long> {

    public List<OlympicSite> findByCodeIn(List<String> olympicSiteCodes);

    public List<OlympicSite> findByIdIn(List<Long> olympicSiteIds);
    
}
