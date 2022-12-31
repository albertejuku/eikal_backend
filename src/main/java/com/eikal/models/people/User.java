package com.eikal.models.people;

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
public class User extends Person{

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_sequence", strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private Long birthCertNo;
    private Long nationalId;
    private String passportNumber;

    public User(long id) {
        this.id = id;
    }
}
