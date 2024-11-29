package com.example.pocJop.Services;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.HourForFlux;
import com.example.pocJop.Repository.HourForFluxRepository;

import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class HourForFluxService {
    
    @Autowired
    private final HourForFluxRepository hourForFluxRepository;

    public List<HourForFlux> getAllHour() {
        List<HourForFlux> hourForFluxs = hourForFluxRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        if (hourForFluxs.isEmpty()) {
            throw new RuntimeException("There is no hour");
        }
        return hourForFluxs;
    }
}
