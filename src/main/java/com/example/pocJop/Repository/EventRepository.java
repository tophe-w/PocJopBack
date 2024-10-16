package com.example.pocJop.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pocJop.Models.Event;

public interface EventRepository extends JpaRepository<Event , Long>{

    List<Event> findByIdIn(List<Long> eventsIds);
    
    @Query("SELECT e FROM Event e " +
       "JOIN e.site s " +
       "JOIN s.gares g " +
       "JOIN g.region r " +
       "WHERE r.id = :regionId " +
       "AND :searchDate BETWEEN e.startEvent AND e.endEvent " +
       "ORDER BY e.category.name")
List<Event> findEventsByRegionAndDate(@Param("regionId") Long regionId,
                                      @Param("searchDate") LocalDateTime searchDate);


}
