package com.eikal.models.store.inventory;

import com.eikal.models.places.ContactInformation;
import lombok.*;

import javax.persistence.*;

/**
 * @author David Kinyanjui
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Manufacturer {

    @Id
    @SequenceGenerator(name = "manufacturer_sequence", sequenceName = "manufacturer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_sequence")
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "contact_info")
    private ContactInformation contactInformation;
    private String businessCategory;
    private String location;
}
