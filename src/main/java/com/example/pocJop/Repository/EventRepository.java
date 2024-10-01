package com.example.pocJop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocJop.Models.Event;

public interface EventRepository extends JpaRepository<Event , Long>{

    List<Event> findByIdIn(List<Long> eventsIds);

}
