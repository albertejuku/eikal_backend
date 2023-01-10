package com.eikal.models.people;


import com.eikal.models.places.Address;
import com.eikal.models.places.ContactInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author David Kinyanjui
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Supplier {

    @Id
    @SequenceGenerator(name = "supplier_sequence", sequenceName = "supplier_sequence", allocationSize = 1)
    @GeneratedValue(generator = "sequence_generator", strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "contact_information")
    private ContactInformation contactInformation;

    private int deliveryPeriod;
    private String businessCategory;
    private Timestamp dateCreated;
    private Timestamp dateModified;


}
