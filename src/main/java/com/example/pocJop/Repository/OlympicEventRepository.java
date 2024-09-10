package com.example.pocJop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocJop.Models.OlympicEvent;

public interface OlympicEventRepository extends JpaRepository<OlympicEvent, Long> {

    List<OlympicEvent> findByIdIn(List<String> olympicEventIds);


    
}
