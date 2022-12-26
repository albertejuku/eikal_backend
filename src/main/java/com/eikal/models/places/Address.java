package com.eikal.models.places;

import lombok.*;

import javax.persistence.*;

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
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(generator = "address_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(length = 50)
    private String code;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(length = 100)
    private double lat;

    @Column(length = 100)
    private double lon;

    private String street;

    @Lob
    private String description;

}