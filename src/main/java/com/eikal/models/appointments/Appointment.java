package com.eikal.models.appointments;


import com.eikal.models.facility.Department;
import com.eikal.models.facility.Employee;
import com.eikal.models.patient.Patient;
import com.eikal.models.people.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author David Kinyanjui
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Appointment {

    @Id
    @SequenceGenerator(name = "appointment_sequence", sequenceName = "appointment_sequence")
    @GeneratedValue(generator = "appointment_sequence", strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate startDate;
    private LocalDate actualStartDate;
    private LocalDate endDate;
    private LocalDate actualEndDate;
    private LocalTime startTime;
    private LocalTime actualStartTime;
    private LocalTime endTime;
    private LocalTime actualEndTime;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateModified = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private AppUser createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by_id")
    private AppUser modifiedBy;

    private int duration;
    private String location;
    private String status;
    @Lob
    private String comments;

    @Lob
    private String notes;

    private String type;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medical_practitioner_id")
    private Employee medicalPractitioner;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
