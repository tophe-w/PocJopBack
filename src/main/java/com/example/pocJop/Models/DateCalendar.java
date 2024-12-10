package com.example.pocJop.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class DateCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dateId;
    private LocalDateTime date;
    @Length(max = 9)
    private String dayName;
    @Length(max = 9)
    private String dayNameAbbr;
    private int dayOfMonth;
    @Length(max = 9)
    private String monthName;
    @Length(max = 3)
    private String monthNameAbbr;
    @Column(name = "Year")
    private String year;


    @OneToMany (mappedBy = "dateCalendar", cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private List<Affluence> affluences;

    @OneToMany (mappedBy = "dateCalendar", cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private List<Gare> gares;
}
