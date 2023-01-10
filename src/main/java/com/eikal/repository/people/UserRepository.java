package com.eikal.repository.people;

import com.eikal.models.patient.Patient;
import com.eikal.models.people.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByNationalId(long nationalId);

    List<User> findAllByBirthCertNoContaining(long birthCert);

    List<User> findAllByPhoneContaining(String phone);

    List<User> findAllByEmailContaining(String email);

    List<User> findAllByUsernameContaining(String username);
}
