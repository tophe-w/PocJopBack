package com.example.pocJop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocJop.Models.OlympicDiscipline;

public interface OlympicDisciplineRepository extends JpaRepository<OlympicDiscipline, Long> {

    List<OlympicDiscipline> findByNameIn(List<String> disciplinesNames);

    OlympicDiscipline findByName(String disciplinesNames);

}
