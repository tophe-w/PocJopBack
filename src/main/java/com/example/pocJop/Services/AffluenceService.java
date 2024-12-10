package com.example.pocJop.Services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.pocJop.Dto.affluenceDtos.AffluenceDto;
import com.example.pocJop.Dto.affluenceDtos.AffluenceDtoMapper;
import com.example.pocJop.Dto.dateCalendarDtos.DateCalendarDto;
import com.example.pocJop.Models.DateCalendar;
import com.example.pocJop.Models.Gare;
import com.example.pocJop.Repository.DateCalendarRepository;
import com.example.pocJop.Repository.GareRepository;
import com.example.pocJop.helper.Helpers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Affluence;
import com.example.pocJop.Repository.AffluenceRepository;

import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class AffluenceService {

    private final AffluenceRepository affluenceRepository;

    private final AffluenceDtoMapper affluenceDtoMapper;

    private final GareRepository gareRepository;

    private final DateCalendarRepository DateCalendarRepository;

    public List<Affluence> getAll() {

        List<Affluence> affluences = affluenceRepository.findAll();
        if (affluences.isEmpty()) {
            throw new RuntimeException("There is no affluence");
        }
        return affluences;
    }

    public AffluenceDto getById(Long id) {
        return affluenceRepository.findById(id).map(affluence -> AffluenceDto.builder()
                        .id(affluence.getId())
                        .affluenceHabituelleDown(affluence.getAffluenceHabituelleDown())
                        .affluenceHabituelleUp(affluence.getAffluenceHabituelleUp())
                        .estimationDown(affluence.getEstimationDown())
                        .estimationUp(affluence.getEstimationUp())
                        .dateCalendar(DateCalendarDto.builder()
                                .dateId(affluence.getDateCalendar().getDateId())
                                .date(affluence.getDateCalendar().getDate())
                                .dayName(affluence.getDateCalendar().getDayName())
                                .dayNameAbbr(affluence.getDateCalendar().getDayNameAbbr())
                                .monthName(affluence.getDateCalendar().getMonthName())
                                .monthNameAbbr(affluence.getDateCalendar().getMonthNameAbbr())
                                .year(affluence.getDateCalendar().getYear())
                                .build())
                        .build())
                .orElseThrow(() -> new RuntimeException("L'affluence avec l'Id n°" + id + " n'existe pas"));
    }

    public List<AffluenceDto> getAffluencesForGare(Long gareId) {

        return affluenceRepository.getAffluencesForGare(gareId)
                .stream()
                .map(affluence -> AffluenceDto.builder()
                        .id(affluence.getId())
                        .affluenceHabituelleDown(affluence.getAffluenceHabituelleDown())
                        .affluenceHabituelleUp(affluence.getAffluenceHabituelleUp())
                        .estimationDown(affluence.getEstimationDown())
                        .estimationUp(affluence.getEstimationUp())
                        .dateCalendar(DateCalendarDto.builder()
                                .dateId(affluence.getDateCalendar().getDateId())
                                .date(affluence.getDateCalendar().getDate())
                                .dayName(affluence.getDateCalendar().getDayName())
                                .dayNameAbbr(affluence.getDateCalendar().getDayNameAbbr())
                                .monthName(affluence.getDateCalendar().getMonthName())
                                .monthNameAbbr(affluence.getDateCalendar().getMonthNameAbbr())
                                .year(affluence.getDateCalendar().getYear())
                                .build())
                        .build())
                .toList();


    }


    public List<AffluenceDto> getGareAffluencesBetwenDates(Long gareId, String startDate, String endDate) {
        LocalDateTime startDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);
        return affluenceRepository.getGareAffluencesBetwenDates(gareId, startDateTime, endDateTime)
                .stream()
                .map(affluence -> AffluenceDto.builder()
                        .id(affluence.getId())
                        .affluenceHabituelleDown(affluence.getAffluenceHabituelleDown())
                        .affluenceHabituelleUp(affluence.getAffluenceHabituelleUp())
                        .estimationDown(affluence.getEstimationDown())
                        .estimationUp(affluence.getEstimationUp())
                        .dateCalendar(DateCalendarDto.builder()
                                .dateId(affluence.getDateCalendar().getDateId())
                                .date(affluence.getDateCalendar().getDate())
                                .dayName(affluence.getDateCalendar().getDayName())
                                .dayNameAbbr(affluence.getDateCalendar().getDayNameAbbr())
                                .monthName(affluence.getDateCalendar().getMonthName())
                                .monthNameAbbr(affluence.getDateCalendar().getMonthNameAbbr())
                                .year(affluence.getDateCalendar().getYear())
                                .build())
                        .build())
                .toList();
    }

    public AffluenceDto getGareAffluencesAtDate(Long gareId, String date) {
        LocalDateTime dateCalendar = LocalDateTime.parse(date);
        Affluence affluence =  affluenceRepository.getGareAffluencesAtDate(gareId, dateCalendar);
        return AffluenceDto.builder()
                .affluenceHabituelleUp(affluence.getAffluenceHabituelleUp())
                .affluenceHabituelleDown(affluence.getAffluenceHabituelleDown())
                .estimationUp(affluence.getEstimationUp())
                .estimationDown(affluence.getEstimationDown())
                .dateCalendar(DateCalendarDto.builder()
                        .date(affluence.getDateCalendar().getDate())
                        .dayName(affluence.getDateCalendar().getDayName())
                        .dayNameAbbr(affluence.getDateCalendar().getDayNameAbbr())
                        .monthName(affluence.getDateCalendar().getMonthName())
                        .monthNameAbbr(affluence.getDateCalendar().getMonthNameAbbr())
                        .year(affluence.getDateCalendar().getYear())
                        .build())
                .build();

    }

    public Affluence create(AffluenceDto affluenceDto) {
        Gare gare = gareRepository.findById(affluenceDto.getGare().getId())
                .orElseThrow(() -> new RuntimeException("La gare avec l'Id n°" + affluenceDto.getId() + " n'est pas trouvée"));
        DateCalendar dateCalendar = DateCalendarRepository.findById(affluenceDto.getDateCalendar().getDateId())
                .orElseThrow(() -> new RuntimeException("La date avec l'Id n°" + affluenceDto.getDateCalendar().getDateId() + " n'est pas trouvée"));
        Affluence affluence = Affluence.builder()
                .affluenceHabituelleDown(affluenceDto.getAffluenceHabituelleDown())
                .affluenceHabituelleUp(affluenceDto.getAffluenceHabituelleUp())
                .estimationDown(affluenceDto.getEstimationDown())
                .estimationUp(affluenceDto.getEstimationUp())
                .gare(gare)
                .dateCalendar(dateCalendar)
                .build();
        return affluenceRepository.save(affluence);
    }

    

    public AffluenceDto update(Long id, Affluence affluence) {
        System.out.println("Tentative de mise à jour de l'affluence avec l'ID : " + id);
        Affluence affluenceToUpdate = affluenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'affluence avec l'Id n°" + id + " n'est pas trouvée"));

        Helpers.UpdateObjectFields(affluence, affluenceToUpdate);

        affluenceRepository.save(affluenceToUpdate);
        return affluenceDtoMapper.from(affluenceToUpdate);
    }


    public void deleteAffluence(Long id) {
        affluenceRepository.deleteById(id);
    }

}
