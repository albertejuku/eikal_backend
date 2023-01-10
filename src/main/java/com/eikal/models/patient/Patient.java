package com.eikal.models.patient;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.Facility;
import com.eikal.models.people.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Patient {

    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(generator = "patient_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference
    @JsonIgnoreProperties("facility")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    @ToString.Exclude
    private Facility facility;
    private Long nationalId;
    private boolean isPersonalId;
    private String relationship = "N/A";
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private String modificationReason;
    private Long modifierId;
    private Long modifierTable;

    @JsonBackReference
    @JsonIgnoreProperties("createdBy")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    @ToString.Exclude
    private Employee createdBy;

    @JsonBackReference
    @JsonIgnoreProperties("modifiedBy")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_by")
    @ToString.Exclude
    private Employee modifiedBy;

    public Patient(Long id) {
        this.id = id;
    }

}
