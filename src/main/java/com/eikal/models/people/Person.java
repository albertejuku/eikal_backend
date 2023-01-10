package com.eikal.models.people;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
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

@MappedSuperclass
public class Person {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private GenderType gender = GenderType.OTHER;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateModified = LocalDateTime.now();

}
