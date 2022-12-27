package com.eikal.models.facility;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;


/**
 * @author David Kinyajui
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class OperatingHours {
    @Id
    @SequenceGenerator(name = "operatingHours_sequence", sequenceName = "operatingHours_sequence", allocationSize = 1)
    @GeneratedValue(generator = "operatingHours_sequence", strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    private LocalTime mondayOpen;
    private LocalTime mondayClose;
    private LocalTime tuesdayOpen;
    private LocalTime tuesdayClose;
    private LocalTime wednesdayOpen;
    private LocalTime wednesdayClose;
    private LocalTime thursdayOpen;
    private LocalTime thursdayClose;
    private LocalTime fridayOpen;
    private LocalTime fridayClose;
    private LocalTime saturdayOpen;
    private LocalTime saturdayClose;
    private LocalTime sundayOpen;
    private LocalTime sundayClose;

}
