package com.example.pocJop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.DateHourForFlux;
import com.example.pocJop.Repository.DateHourForFluxRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DateHourForFluxService {
    
    @Autowired
    private DateHourForFluxRepository dateHourForFluxRepository;

    public List<DateHourForFlux> getAllDates() {
        List<DateHourForFlux> dateHourForFlux = dateHourForFluxRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        if (dateHourForFlux.isEmpty()) {
            throw new RuntimeException("There is no data");
        }
        return dateHourForFlux;
    }
    
    public DateHourForFlux getDateById(Long id) {
        return dateHourForFluxRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("La data avec l'Id n°" + id + " is not found"));
    }

    public DateHourForFlux createDate(DateHourForFlux dateHourForFlux) {
        return dateHourForFluxRepository.save(dateHourForFlux);
    }

    public void deleteDate(Long id) {
        dateHourForFluxRepository.deleteById(id);
    }
}
