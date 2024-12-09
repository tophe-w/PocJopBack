package com.example.pocJop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pocJop.Models.Affluence;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AffluenceRepository extends JpaRepository<Affluence, Long> {

    @Query("SELECT a FROM Affluence a WHERE a.gare.id = :gareId")
    List<Affluence> getAffluencesForGare(Long gareId);

    @Query("SELECT a FROM Affluence a WHERE a.gare.id = :gareId AND a.dateCalendar.date BETWEEN :startDate AND :endDate")
    List<Affluence> getGareAffluencesBetwenDates(Long gareId, LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT a FROM Affluence a WHERE a.gare.id = :gareId AND a.dateCalendar.date = :date")
    Affluence getGareAffluencesAtDate(Long gareId, LocalDateTime date);

}
