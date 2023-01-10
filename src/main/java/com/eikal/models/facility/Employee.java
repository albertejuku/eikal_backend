package com.eikal.models.facility;

import com.eikal.models.people.AppUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author albert ejuku
 * @version 1.0
 */
@Getter
@Setter
@RequiredArgsConstructor

@Entity
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(generator = "employee_sequence", strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Lob
    private String details;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private EmployeeCategory category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateModified = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "created_by")
    private AppUser createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private AppUser modifiedBy;

    public Employee(long id) {
        this.id = id;
    }
}
